use cobis
go

if OBJECT_ID('sp_ciente_dml') IS NOT NULL
begin
	DROP procedure sp_ciente_dml
end
go

create procedure sp_ciente_dml(
	@i_ente				int			 = null,
	@i_cedula 			varchar(13)  = null,
	@i_primer_nombre	varchar(100) = null,
	@i_segundo_nombre 	varchar(100) = null,
	@i_primer_apellido 	varchar(100) = null,
	@i_segundo_apellido varchar(100) = null,
	@i_fecha_nac 		date 		 = null,
	@i_operacion 		char(1),
	@i_formato_fecha	int			 = null,
	@i_fecha_hasta		date		 = null,
	@i_fecha_desde		date		 = null,
	@i_nombre_c			varchar(100) = null
)
as
declare @w_nombre_completo varchar(200)-- permite concatenar
declare @w_en_ente int

if @i_operacion = 'I'
BEGIN 
	if @i_cedula is null
	begin
		raiserror ('La cedula no puede ser null', 1, 5)
		return 1300
	end
	if @i_primer_nombre is null
	begin
		raiserror ('El primer nombre no puede ser null', 1, 5)
		return 1300
	end	
	if @i_primer_apellido is null
	begin
		raiserror ('El primer apellido no puede ser null', 1, 5)
		return 1300
	end
	if @i_fecha_nac is null
	begin
		raiserror ('La fecha de nacimiento no puede ser null', 1, 5)
		return 1300
	end
	if @i_operacion is null
	begin
		raiserror ('La operacion no puede ser null', 1, 5)
		return 1300
	end
	if @i_formato_fecha is null
	begin
		raiserror ('El formato de fecha no puede ser null', 1, 5)
		return 1300
	end
	
	select @w_en_ente = max(en_ente) from cl_ente
	if @w_en_ente is null
		select @w_en_ente = 0
	select @w_en_ente = @w_en_ente + 1 
	
	select @w_nombre_completo = @i_primer_nombre + ' ' + isnull(@i_segundo_nombre + ' ', '') +  @i_primer_apellido  + ' ' + isnull(@i_segundo_apellido + ' ', '')
	
	insert into cl_ente(
		en_ente,	en_ced_ruc,	en_nombre_p,		en_nombre_s,		en_apellido_p,		en_apellido_s,			en_fecha_nacimiento,	en_nombre_completo,	en_fecha_creacion,						en_estado)
	values(
		@w_en_ente,	@i_cedula,	@i_primer_nombre,	@i_segundo_nombre,	@i_primer_apellido,	@i_segundo_apellido,	@i_fecha_nac,			@w_nombre_completo,	convert(varchar(100), getDate(), @i_formato_fecha),	'V')		
	
		-- falta controlar el error que se produce al insertar (try-cath)??
END
if @i_operacion = 'U'
BEGIN
	if @i_formato_fecha is null
	begin
		raiserror ('El formato de fecha no puede ser null', 1, 5)
		return 1300
	end
	if @i_ente is null
	begin
		raiserror ('El ente no puede ser null', 1, 5)
		return 1300
	end
	update cl_ente 
	set
		en_fecha_modificacion = convert(varchar(100), getDate(), @i_formato_fecha)	
	where 
		en_ente = @i_ente
END
if @i_operacion = 'D'
BEGIN 	
	if @i_ente is null
	begin
		raiserror ('El ente no puede ser null', 1, 5)
		return 1300
	end
	update cl_ente 
	set
		en_estado = 'D'
	where 
		en_ente > 0
END
if @i_operacion = 'S'
BEGIN 	
	select 
		en_ente,
		en_nombre_completo,
		en_fecha_nacimiento 
	from cl_ente 
	where en_estado = 'V'
END
if @i_operacion = 'Q'
BEGIN 	
	if @i_cedula is null
	begin
		raiserror ('La cedula no puede ser null', 1, 5)
		return 1300
	end
	select 
		en_ente,
		en_nombre_completo,
		en_fecha_nacimiento
	from cl_ente 
	where en_ced_ruc = @i_cedula and en_estado = 'V'
END
if @i_operacion = 'A'
BEGIN 
	if @i_fecha_desde is null
	begin
		raiserror ('La fecha desde no puede ser null', 1, 5)
		return 1300
	end
	if @i_fecha_hasta is null
	begin
		raiserror ('La fecha hasta no puede ser null', 1, 5)
		return 1300
	end
	select *
	from cl_ente 
	where 
		en_fecha_nacimiento BETWEEN @i_fecha_desde and @i_fecha_hasta
END
if @i_operacion = 'T'
BEGIN 	
	if @i_nombre_c is null
	begin
		raiserror ('El nombre completo entrante no puede ser null', 1, 5)
		return 1300
	end
	select * 
	from cl_ente
	where 
		en_nombre_completo like '%' + @i_nombre_c + '%'
END

RETURN 0


