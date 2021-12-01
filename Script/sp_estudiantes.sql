use capacitacion
go

if OBJECT_ID('sp_estudiantes') IS NOT NULL
begin
	DROP procedure sp_estudiantes
end
go

/* 
 * Creado por krypton
 * */

create procedure sp_estudiantes(
	@i_codigo 		int			 = null,
	@i_nombre		varchar(100) = null,
	@i_apellido 	varchar(100) = null,
	@i_operacion 	char(1)
)
as
declare  @w_codigo int

if @i_operacion = 'I'
begin
	if @i_nombre is null
	begin
		raiserror ('nombre no puede ser null', 1, 5)
		return 1200
	end
	if @i_apellido is null
	begin
		raiserror ('apellido no puede ser null',1, 5)
		return 1201
	end
	if @i_codigo is null
	begin
		raiserror ('codigo no puede ser null', 1, 5)
		return 1204
	end
	
	select @w_codigo = max(es_codigo) from estudiantes
	select @w_codigo = @w_codigo + 1 
	
	insert into estudiantes(
		es_codigo,	es_nombre,	es_apellido) 
	values (
		@w_codigo,	@i_nombre,	@i_apellido)
end

if @i_operacion = 'U'
begin
	if @i_codigo is null
	begin
		print 'codigo no puede ser null'
		return 1204
	end
	update estudiantes 
	set 
		es_nombre 	= @i_nombre, 
		es_apellido = @i_apellido 
	where 
		es_codigo 	= @i_codigo
end

if @i_operacion = 'D'
begin
	delete from estudiantes 
	where es_codigo = @i_codigo
end

if @i_operacion = 'S'
begin
	select 
		es_codigo,
		es_nombre,
		es_apellido
	from estudiantes
	where es_codigo = @i_codigo
end

if @i_operacion = 'Q'
begin
	select 
		es_codigo,
		es_nombre,
		es_apellido
	from estudiantes
end

if @i_operacion = 'T'
begin
	select 
		es_codigo,
		es_nombre,
		es_apellido
	from estudiantes
	where es_nombre like '%' + @i_nombre + '%'
end

RETURN 0 /* ejecucion exitosa */


















