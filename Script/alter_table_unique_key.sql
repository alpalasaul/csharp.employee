alter table estudiantes 
add constraint pk_estudiantes unique(es_codigo)

insert into estudiantes values (20, 'savage', 'krypton')

select * from estudiantes e 