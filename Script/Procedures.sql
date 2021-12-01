use capacitacion
go

if OBJECT_ID('sp_prueba') IS NOT NULL
begin
	DROP procedure sp_prueba
	print 'borra sp_prueba'
end
go

/*
 * 
 * Creado por: krypton
 * 
 */

create procedure sp_prueba
(
	@i_valor1 int,
	@i_valor2 varchar(100)='valor_inicial',
	@i_valor3 int = null
)
as
print 'ejecutanto sp_prueba'
print 'i_valor1: ' + convert(varchar(100), @i_valor1)
print 'i_valor2: ' + @i_valor2
print 'i_valor3: ' + isnull(convert(varchar(100), @i_valor3), 'null')