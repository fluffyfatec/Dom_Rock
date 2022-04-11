
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

--INSERIR DADOS NA TABELA Cliente
INSERT INTO Cliente (razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao)
VALUES ('vitor bumbum guloso','147852','COMPRAS','PAO','OITO','NOVE','10/10/2021 12:00','09/12/2021 18:00');

INSERT INTO Cliente_Funcionalidade (cf_id_cliente, cf_id_funcionalidade)
VALUES ('1', '1');

	

--INSERT INTO Cliente(razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao) VALUES ('Jorge Construtor', 95827801000131, 'Governamental', 'Objetivamente ok', 'Entregavel entregavel', 'Sim Sim Entregavel', '06/04/2022 15:00:20', '06/04/2022 05:48:06');

--INSERT INTO Cliente(razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao) VALUES ('Minedas House', 20737191000186, 'Atacado/Varejo', 'Objetivo do Negócio Sim', 'Minimamente entregavel talvez', 'Possivelmente entregarei isso', '01/04/2022 16:35:12', '05/04/2022 20:19:45');

--INSERT INTO Cliente(razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao) VALUES ('Manu Manu Tops', 78675344000198, 'Industrial', 'Negocio Objetivo', 'Entregarei isso', 'Maximamente entrego isso', '06/04/2022 09:17:58', '06/04/2022 16:39:38');

--INSERT INTO Cliente(razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_possivel, datahora_cadastro, datahora_atualizacao) VALUES ('Rei do Bife', 12345678912345, 'Atacado/Varejo', 'Objeto Negociavel', 'Entregando Possivel', 'Maximo Possivel', '06/04/2022 15:40:48', '06/04/2022 16:30:25');
