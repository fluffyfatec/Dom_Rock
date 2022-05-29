---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
--//DROP TABELAS
DROP TABLE Comentario;
DROP TABLE Usuario;
DROP TABLE Validador;
DROP TABLE Fonte_dado;
DROP TABLE ClienteProduto_Core;
DROP TABLE ClienteProduto_Funcionalidade;
DROP TABLE Cliente_Produto;
DROP TABLE Sistema;
DROP TABLE Formato;
DROP TABLE Origem_dado;
DROP TABLE Core;
DROP TABLE Funcionalidade;
DROP TABLE Produto;
DROP TABLE Solucao;
DROP TABLE Descritivo;
DROP TABLE Cliente;



---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
--//CRIAÇÃO TABELAS

--CRIAÇÃO TABELA Cliente
CREATE TABLE  Cliente (
	id_cliente int identity(1,1) primary key,
    razao_social varchar(40),
    cnpj varchar(14),
	segmento varchar(40),
	datahora_cadastro datetime
);

--CRIAÇÃO TABELA Descritivo
CREATE TABLE  Descritivo (
	id_descritivo int identity(1,1) primary key,
	objetivo_negocio varchar(70),
	entregavel_min varchar(60),
	entregavel_possivel varchar(60),
	id_cliente int foreign key references Cliente(id_cliente) 

);

--CRIAÇÃO TABELA Solucao
CREATE TABLE  Solucao (
	id_solucao int identity(1,1) primary key,
    nm_solucao varchar(30)
);


--CRIAÇÃO TABELA Produto
CREATE TABLE  Produto (
	id_produto int identity(1,1) primary key,
    nm_produto varchar(30),
	dado_min varchar(30),
	id_solucao int foreign key references Solucao(id_solucao)
);



--CRIAÇÃO TABELA Funcionalidade
CREATE TABLE  Funcionalidade (
	id_funcionalidade int identity(1,1) primary key,
    nm_funcionalidade varchar(50)
);

--CRIAÇÃO TABELA Core
CREATE TABLE  Core (
	id_core int identity(1,1) primary key,
    recurso varchar(50)
);


--CRIAÇÃO TABELA Origem_dado
CREATE TABLE  Origem_dado (
	id_origem_dado int identity(1,1) primary key,
    desc_origem varchar(40)
);

--CRIAÇÃO TABELA Formato
CREATE TABLE  Formato (
	id_formato int identity(1,1) primary key,
    formato varchar(40)
);

--CRIAÇÃO TABELA Sistema
CREATE TABLE  Sistema (
	id_sistema int identity(1,1) primary key,
    sistema varchar(40)
);


CREATE TABLE Cliente_Produto(
	id_cliente_produto int identity(1,1) primary key,
	id_cliente int foreign key references Cliente(id_cliente),
	id_produto int foreign key references Produto(id_produto),
);

CREATE TABLE ClienteProduto_Funcionalidade(
	id_cliente_produto int foreign key references Cliente_Produto(id_cliente_produto),
	id_funcionalidade int foreign key references Funcionalidade(id_funcionalidade),
	primary key (id_cliente_produto, id_funcionalidade)
);

CREATE TABLE ClienteProduto_Core(
	id_cliente_produto int foreign key references Cliente_Produto(id_cliente_produto),
	id_core int foreign key references Core(id_core) ,
	primary key (id_cliente_produto, id_core)
);


CREATE TABLE Fonte_dado(
	id_fonte_dado int identity(1,1) primary key,
	volume varchar(40),
	frequencia varchar(40),
	id_cliente_produto int foreign key references Cliente_Produto(id_cliente_produto),
	id_origem_dado int foreign key references Origem_dado(id_origem_dado),
	id_formato int foreign key references Formato(id_formato),
	id_sistema int foreign key references Sistema(id_sistema)
	--unique(id_cliente, id_produto)
);


CREATE TABLE  Validador (
	id_validador int identity(1,1) primary key,
    desc_regra varchar(40),
	obrigatorio varchar(1),
	id_fonte_dado int foreign key references Fonte_dado(id_fonte_dado)
);


CREATE TABLE  Usuario (
	id_usuario int identity(1,1) primary key,
    nome varchar(40),
	funcao varchar(40),
	usuario varchar(40),
	senha varchar(40)
);

CREATE TABLE Comentario (
	id_comentario int identity(1,1) primary key,
	comentario varchar(70),
	etapa varchar(60),
	id_cliente int foreign key references Cliente(id_cliente) 
);

---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------
--//INSERÇÃO TABELAS

--ESCOPO--

--INSERIR DADOS NA TABELA Funcionalidade
INSERT INTO Funcionalidade (nm_funcionalidade)
VALUES ('Ingestão Automatizada'),
	   ('Painéis, Gráficos e Relatórios'),
	   ('Busca por linguagem natural'),
	   ('Gerador de Data Lake');


--INSERIR DADOS NA TABELA Core
INSERT INTO Core (recurso)
VALUES ('Web App'),
	   ('API Gateway'),
	   ('Filas'),
	   ('Step Function'),
	   ('Lambda'),
	   ('Fargate'),
	   ('Containers'),
	   ('S3'),
	   ('Mongodb'),
	   ('Parquet'),
	   ('Quicksight'),
	   ('Cloudwatch');

--INSERIR DADOS NA TABELA Solucao	   
INSERT INTO Solucao (nm_solucao)
VALUES ('NX.Demand'),
	   ('NX.Operations');
	   
--INSERIR DADOS NA TABELA Produto
INSERT INTO Produto (nm_produto, id_solucao)
VALUES ('Vox', 1),
	   ('Marketing & Planning', 1),
	   ('Sales & Distribution', 1),
	   ('Pricing', 1),
	   ('Optimization', 2),
	   ('Matching & Risk', 2);


--INSERIR DADOS NA TABELA Origem Dado
INSERT INTO Origem_dado (desc_origem)
VALUES ('API'),
	   ('SFTP'),
	   ('Upload');

--INSERIR DADOS NA TABELA Formato
INSERT INTO Formato (formato)
VALUES ('JSON'),
	   ('csv'),
	   ('planilhas'),
	   ('tabelas'),
	   ('PDF'),
	   ('Audio'),
	   ('Texto');

--INSERIR DADOS NA TABELA Sistema
INSERT INTO Sistema (Sistema)
VALUES ('ERP'),
	   ('Vendas'),
	   ('Outros');

--INSERIR DADOS NA TABELA Sistema
INSERT INTO Usuario (nome, funcao, usuario, senha)
VALUES ('Admin', 'Admilson', 'admin', '123'),
	   ('Admin', 'Admilson', 'admin', 'admin');



