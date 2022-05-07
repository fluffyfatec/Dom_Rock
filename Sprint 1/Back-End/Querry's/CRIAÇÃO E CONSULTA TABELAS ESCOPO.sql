USE API_Dom_Rock

SELECT * FROM Cliente_Funcionalidade;
SELECT * FROM Cliente_Core;
SELECT * FROM Cliente_Solucao;
SELECT * FROM Cliente_Produto;
SELECT * FROM Funcionalidade;
SELECT * FROM Cliente_Core
SELECT * FROM Produto;
SELECT * FROM Cliente_Solucao;

--------------------------------------
----------CRIA��O TABELAS-------------
--------------------------------------

--CRIA��O TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40) not null unique,
    cnpj varchar(14) not null unique,
	segmento varchar(40),
	objetivo_negocio varchar(70),
	entregavel_min varchar(60),
	entregavel_possivel varchar(60),
	datahora_cadastro datetime,
	datahora_atualizacao datetime 
);

--CRIA��O TABELA Funcionalidade
CREATE TABLE  Funcionalidade (
	id_funcionalidade int identity(1,1) primary key,
    nm_funcionalidade varchar(50) not null unique
);

--CRIA��O TABELA Core
CREATE TABLE  Core (
	id_core int identity(1,1) primary key,
    recurso varchar(50) not null unique
);

--CRIA��O TABELA Solucao
--CRIA��O TABELA Solucao
CREATE TABLE  Solucao (
	id_solucao int identity(1,1) primary key,
    nm_solucao varchar(30)  not null unique
);


--CRIA��O TABELA Produto
CREATE TABLE  Produto (
	id_produto int identity(1,1) primary key,
    nm_produto varchar(30) not null unique,
	id_solucao int foreign key references Solucao(id_solucao) not null
);


-----FK's
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

CREATE TABLE Cliente_Produto(
	cp_id_cliente int foreign key references Cliente(id_cliente) not null,
	cp_id_produto int foreign key references Produto(id_produto) not null,
	dado_min varchar(30),
	primary key (cp_id_cliente, cp_id_produto)
);

----------------------------------------------------------------------------------------------------------


CREATE TABLE  Origem_dado (
	id_origem_dado int identity(1,1) primary key,
    desc_origem varchar(40)  not null unique
);

CREATE TABLE  Formato (
	id_formato int identity(1,1) primary key,
    formato varchar(40)  not null unique
);

CREATE TABLE  Sistema (
	id_sistema int identity(1,1) primary key,
    sistema varchar(40)  not null unique
);

CREATE TABLE Fonte_dado(

	id_fonte_dado int identity(1,1) primary key,
	volume varchar(40)  not null,
	frequencia varchar(40)  not null,
	id_cliente int foreign key references Cliente(id_cliente) not null,
	id_produto int foreign key references Produto(id_produto) not null,

	id_origem_dado int foreign key references Origem_dado(id_origem_dado) not null,
	id_formato int foreign key references Formato(id_formato) not null,
	id_sistema int foreign key references Sistema(id_sistema) not null
	
	unique (id_cliente, id_produto),
	unique (id_origem_dado, id_formato, id_sistema)
);

CREATE TABLE  Validador (
	id_validador int identity(1,1) primary key,
    desc_regra varchar(40)  not null unique,
	obrigatorio varchar(1)  not null unique,
	id_fonte_dado int foreign key references Fonte_dado(id_fonte_dado) not null
	
);






DROP TABLE Origem_dado;
DROP TABLE Formato;
DROP TABLE Sistema;
DROP TABLE Fonte_dado;

DROP TABLE Validador;



/*
DROP TABLE Cliente;
DROP TABLE Produto;
DROP TABLE Funcionalidade;
DROP TABLE Core;
DROP TABLE Solucao;

DROP TABLE Cliente_Funcionalidade;
DROP TABLE Cliente_Core;
DROP TABLE Cliente_Produto;
*/







SELECT * FROM Sys.tables
ORDER BY 1 ASC



CREATE TABLE  Origem_dado (
	id_origem_dado int identity(1,1) primary key,
    desc_origem varchar(40)  
);

CREATE TABLE  Formato (
	id_formato int identity(1,1) primary key,
    formato varchar(40)  
);

CREATE TABLE  Sistema (
	id_sistema int identity(1,1) primary key,
    sistema varchar(40) 
);

CREATE TABLE Fonte_dado(

	id_fonte_dado int identity(1,1) primary key,
	volume varchar(40),  
	frequencia varchar(40),
	id_cliente int foreign key references Cliente(id_cliente),
	id_produto int foreign key references Produto(id_produto),

	id_origem_dado int foreign key references Origem_dado(id_origem_dado),
	id_formato int foreign key references Formato(id_formato)  ,
	id_sistema int foreign key references Sistema(id_sistema)  
	
	
);

CREATE TABLE  Validador (
	id_validador int identity(1,1) primary key,
    desc_regra varchar(40)    ,
	obrigatorio varchar(1)    ,
	id_fonte_dado int foreign key references Fonte_dado(id_fonte_dado)  
	
);

select * from Fonte_dado