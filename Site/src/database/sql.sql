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

CREATE TABLE Sistema (
ID INT PRIMARY KEY AUTO_INCREMENT,
SistemaOperacional varchar(50),
Fabricante varchar(50),
Arquitetura int,
Inicializado varchar(50),
TempoDeAtividade varchar(50),
Permissoes varchar(50),
fkusuario int,
foreign key(fkusuario) references usuario(idUsuario)
);

CREATE TABLE Processos (
ID INT PRIMARY KEY AUTO_INCREMENT,
Nome Varchar(100),
UsoCPU double,
UsoMemoria double,
BytesUtilizados int,
MemVirtual decimal,
PID int,
totalProcessos int,
threads int,
fkusuario int,
foreign key(fkusuario) references usuario(idUsuario)
);

CREATE TABLE Hardware (
ID INT PRIMARY KEY auto_increment,
qtdDiscos int,
nomeDisco varchar(50),
tamanhoDisco Double,
memoriaTotal Double,
processadorNome varchar(50),
temperaturaAtual Double,
fkusuario int,
foreign key(fkusuario) references usuario(idUsuario)
);

desc Processos;
SELECT * FROM Sistema;
SELECT * FROM Processos;
SELECT * FROM Hardware;

truncate table Hardware;
truncate table Processos;

DROP TABLE Hardware;