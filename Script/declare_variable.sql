declare @w_resultado int

exec @w_resultado = capacitacion..sp_estudiantes @i_operacion='I', @i_codigo=30, @i_nombre='rose', @i_apellido='apellido'

select @w_resultado