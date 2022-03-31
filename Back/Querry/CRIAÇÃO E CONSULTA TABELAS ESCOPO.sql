USE API_Dom_Rock

--------------------------------------
----------CRIA플O TABELAS-------------
--------------------------------------

--CRIA플O TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40) not null,
    cnpj numeric(20) not null,
    nm_setor varchar(40) not null,
    dt_cadastro datetime not null,
	dt_atualizacao datetime not null
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

--CRIA플O TABELA Entregavel
CREATE TABLE  Entregavel (
	id_entregavel int identity(1,1) primary key,
    objetivo_negocio varchar(70) not null,
	entregavel_min varchar(60) not null,
	entregavel_posseivel varchar(60) not null
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
	id_solucao int foreign key references Solucao(id_solucao) not null
);



