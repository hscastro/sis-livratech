create table categorias (id bigint not null auto_increment, nome varchar(80) not null, primary key (id)) type=MyISAM;
create table clientes (id bigint not null auto_increment, celular varchar(25) not null, cpf varchar(80) not null, data_nascimento DATE, email varchar(80) not null, nome varchar(80) not null, endereco_id_fk bigint, usuario_id_fk bigint, primary key (id)) type=MyISAM;
create table enderecos (id bigint not null auto_increment, bairro varchar(255) not null, cep varchar(9) not null, cidade varchar(255) not null, complemento varchar(255), logradouro varchar(255) not null, numero integer not null, uf varchar(2) not null, primary key (id)) type=MyISAM;
create table livros (id bigint not null auto_increment, autor varchar(80), data_entrada DATE, isbn varchar(20) not null, nome varchar(60) not null, id_categoria_fk bigint, primary key (id)) type=MyISAM;
create table usuarios (id bigint not null auto_increment, login varchar(50) not null, perfil integer, senha varchar(33) not null, primary key (id)) type=MyISAM;
alter table categorias add constraint UK_9qte5svl2i6n82lpdyyheoi1h unique (nome);
alter table clientes add constraint UK_7wflw78ibh162cmq12ii6ffly unique (cpf);
alter table livros add constraint UK_bm02y40a3t3ambvf91804i3kv unique (isbn);
alter table livros add constraint UK_jcnkqylr4sh9p7o802mch3re2 unique (nome);
alter table usuarios add constraint UK_r8oo98o39ykr4hi57md9nibmw unique (login);
alter table clientes add constraint FK54ol4y3qwt4gce8xfft0bmcs8 foreign key (endereco_id_fk) references enderecos (id);
alter table clientes add constraint FK4ncy5qcciaccv536x0kclfa1d foreign key (usuario_id_fk) references usuarios (id);
alter table livros add constraint FKgr505e1pff3lp9navmc2if2m5 foreign key (id_categoria_fk) references categorias (id);
insert into usuarios(id, perfil, login, senha) values (1, 1, 'admin', '202cb962ac59075b964b07152d234b70');