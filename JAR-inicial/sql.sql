use keepSwimming;

create table Empresa(
			idEmpresa int primary key auto_increment(100,1),
			cnpj char(18),
			nome varchar(50),
			email varchar (45),
			cep char(9),
			senha varchar(100)
			);

INSERT INTO empresa VALUES 
("03.778.130/0001-48", "Keep Swimming", 'Keep@hotmail.com', 06126020,'123');

CREATE TABLE FUNCIONARIO (
         idFuncionario INT PRIMARY KEY auto_increment,
         fkGestor Int,
         fkEmpresa Int,
         Nome varchar(50),
         EMAIL VARCHAR(50),
         SENHA VARCHAR(50),
         Cargo VARCHAR(50),
         foreign key (fkGestor) references FUNCIONARIO(idFuncionario),
         foreign key (fkEmpresa) references empresa(idEmpresa)
         on delete cascade
         );

-- INSERT INTO FUNCIONARIO VALUES (100, 'Gerson', 'Gerson@hotmail.com', '123', 'Gestor');
-- INSERT INTO [dbo].[FUNCIONARIO] VALUES ( 1, 100, 'Bruno', 'bruno@hotmail.com', '123', 'Desenvolvedor');

CREATE TABLE Maquina (
                idMaquina INT PRIMARY KEY auto_increment,
                fkUsuario INT,
                sistemaOperacional varchar(50),
                fabricante varchar(50),
                arquitetura int,
                hostName varchar(50),
                permissoes varchar(50),
                foreign key (fkUsuario) references FUNCIONARIO(idFuncionario)
                on delete cascade
                );

CREATE TABLE Processos (
                idProcesso INT PRIMARY KEY auto_increment,
                fkMaquina INT,
                PID INT ,
                Nome varchar(45),
                usoCPU FLOAT,
                usoMemoria FLOAT,
                bytesUtilizados INT,
                memVirtualUtilizada FLOAT,
                totalProcessos int,
                threads int,
                foreign key (fkMaquina) references Maquina(idMaquina)
                on delete cascade
                );

CREATE TABLE  ComponentesHardware (
                ID INT PRIMARY KEY auto_increment,
				fkMaquina INT,
                nomeDisco varchar(45),
                tamanhoDisco FLOAT,
                modeloDisco varchar(100),
                qtdDiscos int,
                memoriaTotal FLOAT,
                processadorNome varchar(50),
				foreign key (fkMaquina) references Maquina(idMaquina)
                );
                
CREATE TABLE  Historico (
                ID INT PRIMARY KEY auto_increment,
                fkMaquina INT,
                data datetime,
                tempoInicializado varchar(45),
                tempoDeAtividade varchar(45),
                temperaturaAtual varchar(45),
                memoriaEmUso FLOAT,
                memoriaDisponivel FLOAT,
                processadorUso FLOAT,
                foreign key (fkMaquina) references Maquina(idMaquina)
                on delete cascade
                );
