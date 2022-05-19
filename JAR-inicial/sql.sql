use keepSwimming;


INSERT INTO [dbo].[FUNCIONARIO] VALUES (null, 100, 'Gerson', 'Gerson@hotmail.com', '123', 'Gestor');
INSERT INTO [dbo].[FUNCIONARIO] VALUES ( 1, 100, 'Bruno', 'bruno@hotmail.com', '123', 'Desenvolvedor');

CREATE TABLE [dbo].[Maquina] (
                idMaquina INT PRIMARY KEY IDENTITY,
                fkUsuario INT,
                sistemaOperacional varchar(50),
                fabricante varchar(50),
                arquitetura int,
                permissoes varchar(50),
                foreign key (fkUsuario) references FUNCIONARIO(idFuncionario)
                on delete cascade
                );

alter table [dbo].[Maquina] add  hostName varchar;

CREATE TABLE [dbo].[Processos] (
                idProcesso INT PRIMARY KEY IDENTITY,
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

CREATE TABLE  [dbo].[ComponentesHardware] (
                ID INT PRIMARY KEY IDENTITY,
				fkMaquina INT,
                nomeDisco varchar(45),
                tamanhoDisco FLOAT,
                modeloDisco varchar(100),
                qtdDiscos int,
                memoriaTotal FLOAT,
                processadorNome varchar(50),
				foreign key (fkMaquina) references Maquina(idMaquina)
                );
                
CREATE TABLE  [dbo].[Historico] (
                ID INT PRIMARY KEY IDENTITY,
                fkMaquina INT,
                data datetime,
                tempoInicializado varchar(45),
                tempoDeAtividade varchar(45),
                temperaturaAtual varchar(45),
                memoriaEmUso FLOAT,
                memoriaDisponivel FLOAT,
                processadorUso FLOAT,
                foreign key (fkMaquina) references Maquina(idMaquina)
                );
