USE API_Dom_Rock
DROP TABLE Cliente_Funcionalidade;

DROP TABLE Cliente;

DROP TABLE Modulo;
DROP TABLE Produto;
DROP TABLE Funcionalidade;
DROP TABLE Core;

INSERT INTO Cliente (razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao)
VALUES ('CCR','147852','COMPRAS','PAO','OITO','NOVE','10/10/2021 12:00','09/12/2021 18:00');

INSERT INTO Funcionalidade (nm_funcionalidade)
VALUES ('Aquisi豫o');

INSERT INTO Cliente_Funcionalidade (cf_id_cliente, cf_id_funcionalidade)
VALUES ('1', '1');


SELECT * FROM Cliente;
SELECT * FROM Funcionalidade;
SELECT * FROM Cliente_Funcionalidade;

--------------------------------------
----------CRIA플O TABELAS-------------
--------------------------------------

--CRIA플O TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40) not null,
    cnpj numeric(20) not null,
	segmento varchar(40) not null,
	objetivo_negocio varchar(70) not null,
	entregavel_min varchar(60) not null,
	entregavel_possivel varchar(60) not null,
	datahora_cadastro datetime not null,
	datahora_atualizacao datetime  
);

--CRIA플O TABELA Funcionalidade
CREATE TABLE  Funcionalidade (
	id_funcionalidade int identity(1,1) primary key,
    nm_funcionalidade varchar(50) not null
);

--CRIA플O TABELA Core
CREATE TABLE  Core (
	id_core int identity(1,1) primary key,
    recurso varchar(50) not null
);


--CRIA플O TABELA Solucao
CREATE TABLE  Solucao (
	id_solucao int identity(1,1) primary key,
    nm_solucao varchar(30) not null
);


--CRIA플O TABELA Produto
CREATE TABLE  Produto (
	id_produto int identity(1,1) primary key,
    nm_produto varchar(30) not null,
	dado_min varchar(30) not null,
	id_solucao int foreign key references Solucao(id_solucao) not null,
);
----------------------------------------------------------------------------------------------------
----FK's
CREATE TABLE Cliente_Funcionalidade(
	cf_id_cliente int foreign key references Cliente(id_cliente) not null,
	cf_id_funcionalidade int foreign key references Funcionalidade(id_funcionalidade) not null,
	primary key (cf_id_cliente, cf_id_funcionalidade)
);

CREATE TABLE Cliente_Core(
	cc_id_cliente int foreign key references Cliente(id_cliente) not null,
	cc_id_core int foreign key references Core(id_core) not null,
	primary key (cc_id_cliente, cc_id_core)
);

CREATE TABLE Cliente_Solucao(
	cs_id_cliente int foreign key references Cliente(id_cliente) not null,
	cs_id_solucao int foreign key references Solucao(id_solucao) not null,
	primary key (cs_id_cliente, cs_id_solucao)
);

CREATE TABLE Cliente_Produto(
	cp_id_cliente int foreign key references Cliente(id_cliente) not null,
	cp_id_produto int foreign key references Produto(id_produto) not null,
	primary key (cp_id_cliente, cp_id_produto)
);




select * from Cliente_Funcionalidade

