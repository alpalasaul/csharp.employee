insert into transacciones(tr_id, tr_monto, tr_fecha)
values(10, 200.23, getDate())

insert into transacciones(tr_id, tr_monto, tr_fecha)
values(10, 200.23, '2021-08-21')

insert into transacciones(tr_id, tr_monto, tr_fecha)
values(10, 200.23, '08-21-2021') /*no permitido*/

truncate table transacciones /*limpia la tabla*/

select * from transacciones

select tr_id, tr_monto, convert(varchar(20), tr_fecha, 101) from transacciones

/* 
 * Auto increment con identity(1, 1)
 * /

insert into transacciones(tr_monto, tr_fecha)
values(200.23, getDate())