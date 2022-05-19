
DROP TABLE Validador;
DROP TABLE Fonte_dado;
DROP TABLE Sistema;
DROP TABLE Formato;
DROP TABLE Origem_dado;
DROP TABLE Cliente_Produto;
DROP TABLE Cliente_Core;
DROP TABLE Cliente_Funcionalidade;
DROP TABLE Produto;
DROP TABLE Solucao;
DROP TABLE Core;
DROP TABLE Funcionalidade;
DROP TABLE Descritivo;
DROP TABLE Cliente;

---------------------------------------------------------------------------------------------------------
----------------------------------ESCOPO-----------------------------------------------------------------
---------------------------------------------------------------------------------------------------------
--CRIA플O TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40),
    cnpj varchar(14),
	segmento varchar(40),
	datahora_cadastro datetime
);

--CRIA플O TABELA Descrivo
CREATE TABLE  Descritivo (
	id_descritivo int identity(1,1) primary key,
	objetivo_negocio varchar(70),
	entregavel_min varchar(60),
	entregavel_possivel varchar(60),
	id_cliente int foreign key references Cliente(id_cliente) 

);

--CRIA플O TABELA Funcionalidade
CREATE TABLE  Funcionalidade (
	id_funcionalidade int identity(1,1) primary key,
    nm_funcionalidade varchar(50)
);

--CRIA플O TABELA Core
CREATE TABLE  Core (
	id_core int identity(1,1) primary key,
    recurso varchar(50)
);

--CRIA플O TABELA Solucao
CREATE TABLE  Solucao (
	id_solucao int identity(1,1) primary key,
    nm_solucao varchar(30)
);


--CRIA플O TABELA Produto
CREATE TABLE  Produto (
	id_produto int identity(1,1) primary key,
    nm_produto varchar(30),
	dado_min varchar(30),
	id_solucao int foreign key references Solucao(id_solucao)
);


-----FK's
CREATE TABLE Cliente_Funcionalidade(
	id_cliente int foreign key references Cliente(id_cliente),
	id_funcionalidade int foreign key references Funcionalidade(id_funcionalidade),
	primary key (id_cliente, id_funcionalidade)
);

CREATE TABLE Cliente_Core(
	id_cliente int foreign key references Cliente(id_cliente),
	id_core int foreign key references Core(id_core) ,
	primary key (id_cliente, id_core)
);

CREATE TABLE Cliente_Produto(
	id_cliente_produto int identity(1,1) primary key,
	id_cliente int foreign key references Cliente(id_cliente),
	id_produto int foreign key references Produto(id_produto)
	
);




---------------------------------------------------------------------------------------------------------
----------------------------------BRONZE-----------------------------------------------------------------
---------------------------------------------------------------------------------------------------------

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
	id_cliente_produto int foreign key references Cliente_Produto(id_cliente_produto),
	id_origem_dado int foreign key references Origem_dado(id_origem_dado),
	id_formato int foreign key references Formato(id_formato),
	id_sistema int foreign key references Sistema(id_sistema)
);

CREATE TABLE  Validador (
	id_validador int identity(1,1) primary key,
    desc_regra varchar(40),
	obrigatorio varchar(1),
	id_fonte_dado int foreign key references Fonte_dado(id_fonte_dado)
);


















