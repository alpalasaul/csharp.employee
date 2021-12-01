IF OBJECT_ID('estudiantes') is not null
begin
	DROP TABLE estudiantes
	print 'entra borrando'
end

CREATE TABLE estudiantes 
(
	es_codigo int not null,
	es_nombre varchar(100) not null,
	es_apellido varchar(100) not null
)

select * from estudiantes