create database projetoDaniel;



create table usuario(
id serial not null,
usuario varchar (45) not null,
senha varchar (45) not null,
email varchar (100) not null,
tipoUsuario varchar(32) not null,
primary key (id)
);

create table projeto(
id serial not null,
nomeProjeto varchar (100) not null,
descricaoProjeto varchar (200) not null,
versao int not null,
nomeCliente varchar (45) not null,
primary key (id)
);


create table requisito(
id serial not null,
nomeRequisito varchar (100) not null,
descricaoRequisito varchar (200) not null,
prioridadeRequisito varchar (200) not null,
tipoRequisito varchar (100) not null,
complexidade varchar (45) not null,
projeto_id int,
primary key (id),
CONSTRAINT fk_requisitos_projeto
FOREIGN KEY (projeto_id)
REFERENCES projeto (id)
);
