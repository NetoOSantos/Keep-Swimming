CREATE DATABASE KeepSwimming;

USE KeepSwimming;

CREATE TABLE Maquina (
ID INT PRIMARY KEY AUTO_INCREMENT,
sistemaOperacional varchar(50),
fabricante varchar(50),
arquitetura int,
permissoes varchar(50)
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
threads int
);

CREATE TABLE Hardware (
ID INT PRIMARY KEY auto_increment,
qtdDiscos int,
nomeDisco varchar(50),
tamanhoDisco Double,
memoriaTotal Double,
processadorNome varchar(50),
temperaturaAtual Double
);

desc Processos;
SELECT * FROM Sistema;
SELECT * FROM Processos;
SELECT * FROM Hardware;

truncate table Hardware;
truncate table Processos;

DROP TABLE Hardware;