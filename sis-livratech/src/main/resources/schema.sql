drop table if exists usuarios;

create table if not exists usuarios (
	id bigint not null auto_increment,
	perfil int(11) not null,
	login varchar(50) not null,
	senha varchar(33) not null,
	primary key (id)
);