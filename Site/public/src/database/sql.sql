create database keepSwimming;

use keepSwimming;

create table usuario(
idUsuario int primary key auto_increment,
cnpj char(14),
nome varchar(50),
email varchar (45),
cep char(9),
senha varchar(100)
)auto_increment 100;