declare @w_resultado int

-- EXEC @w_resultado = cobis..sp_ciente_dml @i_cedula='666', @i_primer_nombre='junior', @i_primer_apellido='alpala', @i_fecha_nac='10-10-2000', @i_operacion='I', @i_formato_fecha='30'
EXEC cobis..sp_ciente_dml @i_cedula='666', @i_primer_nombre='artupa', @i_primer_apellido='alpala', @i_fecha_nac='10-10-2000', @i_operacion='I', @i_formato_fecha='30'

-- EXEC @w_resultado = cobis..sp_ciente_dml @i_operacion='U', @i_formato_fecha='30'

-- EXEC cobis..sp_ciente_dml @i_operacion='U', @i_formato_fecha='30'

EXEC cobis..sp_ciente_dml @i_operacion='U', @i_formato_fecha='30', @i_ente=1

EXEC cobis..sp_ciente_dml @i_operacion='U'

EXEC cobis..sp_ciente_dml @i_operacion='D'

EXEC cobis..sp_ciente_dml @i_operacion='S'

EXEC cobis..sp_ciente_dml @i_operacion='T', @i_nombre_c='ar'

EXEC cobis..sp_ciente_dml @i_operacion='Q', @i_cedula='55555'

EXEC cobis..sp_ciente_dml @i_operacion='A', @i_fecha_desde='1999-10-10', @i_fecha_hasta='2000-10-11'
select @w_resultado 

/*
select * from cl_ente

truncate table cl_ente 
*/

