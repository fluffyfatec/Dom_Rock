
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
INSERT INTO Produto (nm_produto, dado_min, id_solucao)
VALUES ('Vox', '10GB', 1),
	   ('Marketing & Planning', '5GB', 1),
	   ('Sales & Distribution', '2GB', 1),
	   ('Pricing', '6GB', 1),
	   ('Optimization', '9GB', 2),
	   ('Matching & Risk', '1GB', 2);

--INSERIR DADOS NA TABELA Cliente
INSERT INTO Cliente (razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao)
VALUES ('CCR','147852','COMPRAS','PAO','OITO','NOVE','10/10/2021 12:00','09/12/2021 18:00');

INSERT INTO Cliente_Funcionalidade (cf_id_cliente, cf_id_funcionalidade)
VALUES ('1', '1');

