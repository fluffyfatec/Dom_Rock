
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
-------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

