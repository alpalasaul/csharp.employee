
EXEC capacitacion..sp_estudiantes @i_codigo=10, @i_nombre='juanito', @i_apellido='perecito', @i_operacion='I'

EXEC capacitacion..sp_estudiantes @i_codigo=10, @i_operacion='I'

EXEC capacitacion..sp_estudiantes @i_operacion='U', @i_codigo=10, @i_nombre='juanito', @i_apellido='perecito'

EXEC capacitacion..sp_estudiantes @i_operacion='D', @i_codigo=10

select * from estudiantes

delete from estudiantes where es_codigo = 10