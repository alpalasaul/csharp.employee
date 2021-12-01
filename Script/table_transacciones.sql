if exists(select 1 from sysobjects where name = 'transacciones') 
	drop table transacciones
go

create table transacciones(
	tr_id 	int identity(1, 1),
	tr_monto money not null,
	tr_fecha date not null,
	tr_estado char(1) not null,
)

insert into transacciones(tr_monto, tr_fecha, tr_estado)
values(100, getDate(), 'V')

select * from transacciones 

update transacciones set tr_estado = 'E' where tr_id = 2

select * from transacciones where tr_id =2 and tr_estado = 'V'