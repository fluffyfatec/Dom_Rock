
--------------------------------------
----------CRIAÇÃO TABELAS-------------
--------------------------------------

--CRIAÇÃO TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40) not null,
    cnpj varchar(14) not null,
	segmento varchar(40),
	datahora_cadastro datetime,
	unique(razao_social, cnpj)
);

--CRIAÇÃO TABELA Descrivo
CREATE TABLE  Descritivo (
	id_descritivo int identity(1,1) primary key,
	objetivo_negocio varchar(70),
	entregavel_min varchar(60),
	entregavel_possivel varchar(60),
	id_cliente int foreign key references Cliente(id_cliente) not null,
	unique(id_cliente)
);

--CRIAÇÃO TABELA Funcionalidade
CREATE TABLE  Funcionalidade (
	id_funcionalidade int identity(1,1) primary key,
    nm_funcionalidade varchar(50) not null,
	unique(nm_funcionalidade)
);

--CRIAÇÃO TABELA Core
CREATE TABLE  Core (
	id_core int identity(1,1) primary key,
    recurso varchar(50) not null,
	unique(recurso)
);

--CRIAÇÃO TABELA Solucao
CREATE TABLE  Solucao (
	id_solucao int identity(1,1) primary key,
    nm_solucao varchar(30)  not null,
	unique(nm_solucao)
);


--CRIAÇÃO TABELA Produto
CREATE TABLE  Produto (
	id_produto int identity(1,1) primary key,
    nm_produto varchar(30) not null,
	id_solucao int foreign key references Solucao(id_solucao) not null,
	dado_min varchar(30)
	unique(nm_produto)
);


-----FK's
CREATE TABLE Cliente_Funcionalidade(
	id_cliente int foreign key references Cliente(id_cliente) not null,
	id_funcionalidade int foreign key references Funcionalidade(id_funcionalidade) not null,
	primary key (id_cliente, id_funcionalidade)
);

CREATE TABLE Cliente_Core(
	id_cliente int foreign key references Cliente(id_cliente) not null,
	id_core int foreign key references Core(id_core) not null,
	primary key (id_cliente, id_core)
);

CREATE TABLE Cliente_Produto(
	id_cliente_produto int identity(1,1) primary key,
	id_cliente int foreign key references Cliente(id_cliente) not null,
	id_produto int foreign key references Produto(id_produto) not null
);

----------------------------------------------------------------------------------------------------------
--BRONZE

CREATE TABLE  Origem_dado (
	id_origem_dado int identity(1,1) primary key,
    desc_origem varchar(40)  not null,
	unique(desc_origem)
);

CREATE TABLE  Formato (
	id_formato int identity(1,1) primary key,
    formato varchar(40)  not null,
	unique(formato)
);

CREATE TABLE  Sistema (
	id_sistema int identity(1,1) primary key,
    sistema varchar(40)  not null,
	unique(sistema)
);

CREATE TABLE Fonte_dado(

	id_fonte_dado int identity(1,1) primary key,
	volume varchar(40)  not null,
	frequencia varchar(40)  not null,
	id_cliente_produto int foreign key references Cliente_Produto(id_cliente_produto) not null,

	id_origem_dado int foreign key references Origem_dado(id_origem_dado) not null,
	id_formato int foreign key references Formato(id_formato) not null,
	id_sistema int foreign key references Sistema(id_sistema) not null,
	unique (id_origem_dado, id_formato, id_sistema)
);

CREATE TABLE  Validador (
	id_validador int identity(1,1) primary key,
    desc_regra varchar(40)  not null unique,
	obrigatorio varchar(1)  not null unique,
	id_fonte_dado int foreign key references Fonte_dado(id_fonte_dado) not null
);


------------------------------------------------------------------------------------------------------------------------------
