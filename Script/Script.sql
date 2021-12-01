EXEC capacitacion..sp_estudiantes @i_operacion='I', @i_nombre='teresa', @i_apellido='chavez'

EXEC capacitacion..sp_estudiantes @i_operacion='S', @i_codigo=31

EXEC capacitacion..sp_estudiantes @i_operacion='Q'

EXEC capacitacion..sp_estudiantes @i_operacion='T', @i_nombre='sa' /* select like coincidencia con 'sa' */

select * from estudiantes