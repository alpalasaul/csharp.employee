if exists(select name from sysobjects where name = 'cl_ente') 
	drop table cl_ente

create table cl_ente(
	en_ente 				int 			not null,
	en_ced_ruc 				varchar(13) 	not null,
	en_estado 				char(1) 		not null,
	en_nombre_completo		varchar(200) 	null, -- duda
	en_nombre_p 			varchar(100) 	not null,
	en_nombre_s 			varchar(100) 	null,
	en_apellido_p 			varchar(100) 	not null,
	en_apellido_s 			varchar(100) 	null,
	en_fecha_nacimiento 	date 			not null,
	en_fecha_creacion 		varchar(100) 	null,
	en_fecha_modificacion 	varchar(100) 	null
)

select * from cl_ente 

alter table cl_ente 
add constraint pk_cl_ente unique(en_ced_ruc)