
--VIEW CLIENTE
DROP VIEW view_cliente;

CREATE VIEW view_cliente AS
SELECT cli.id_cliente AS id_cliente, 
	  (CONCAT(UPPER(SUBSTRING(cli.razao_social, 1, 1)) , LOWER(SUBSTRING(cli.razao_social, 2, 80)))) AS razao_social,
	   cli.cnpj as cnpj,
	   cli.segmento AS segmento,  
	   FORMAT(cli.datahora_cadastro , 'dd/MM/yyyy HH:mm:ss') as datahora_cadastro
FROM Cliente cli;

SELECT * FROM view_cliente
ORDER BY id_cliente ASC
-------------------------------------------------------------------------------------------------------------------------------------------

--VIEW USUARIO

DROP VIEW view_usuario;

CREATE VIEW view_usuario AS
SELECT usu.id_usuario AS id_usuario,
		(CONCAT(UPPER(SUBSTRING(usu.nome, 1, 1)) , LOWER(SUBSTRING(usu.nome, 2, 80)))) AS nome,
		(CONCAT(UPPER(SUBSTRING(usu.funcao, 1, 1)) , LOWER(SUBSTRING(usu.funcao, 2, 80)))) AS funcao,
		usu.usuario AS usuario,
		REPLACE(usu.senha, usu.senha, '****') AS senha
FROM Usuario usu;

SELECT * FROM view_usuario
ORDER BY id_usuario ASC
-------------------------------------------------------------------------------------------------------------------------------------------

--VIEW BRONZE
DROP VIEW view_cliente_produto;

CREATE VIEW view_cliente_produto AS
SELECT prod.nm_produto, cli.razao_social, cli.id_cliente FROM Cliente_Produto cp
LEFT JOIN Produto prod
	ON prod.id_produto = cp.id_produto
LEFT JOIN Cliente cli
	ON cli.id_cliente = cp.id_cliente;

SELECT razao_social, nm_produto FROM view_cliente_produto
WHERE id_cliente = 13
ORDER BY nm_produto ASC

-------------------------------------------------------------------------------------------------------------------------------------------

--VIEW BRONZE
DROP VIEW view_bronze;

CREATE VIEW view_bronze AS
SELECT fd.id_fonte_dado AS id_fonte_dado,
		prod.nm_produto AS nm_produto, 
		od.desc_origem AS desc_origem, 
		fort.formato AS formato,
		sis.sistema AS sistema, 
		fd.volume AS volume, 
		fd.frequencia AS frequencia,
		cp.id_cliente AS id_cliente,
		fd.id_cliente_produto,
		valid.desc_regra AS desc_regra,
		valid.obrigatorio AS obrigatorio,
		valid.id_validador AS id_validador,
		valid.id_gold AS id_gold,
		gol.operacao AS operacao,
		gol.descritivo_operacao AS descritivo_operacao
FROM Fonte_dado fd
LEFT JOIN Cliente_Produto cp
	ON cp.id_cliente_produto = fd.id_cliente_produto
LEFT JOIN Produto prod
	ON prod.id_produto = cp.id_produto
LEFT JOIN Origem_dado od
	ON od.id_origem_dado = fd.id_origem_dado
LEFT JOIN Formato fort
	ON fort.id_formato = fd.id_formato
LEFT JOIN Sistema sis
	ON sis.id_sistema = fd.id_sistema
LEFT JOIN Validador valid
	ON valid.id_fonte_dado = fd.id_fonte_dado
LEFT JOIN Gold gol
	ON gol.id_gold = valid.id_gold;

--TODOS
SELECT * FROM view_bronze
WHERE id_cliente = 13
ORDER BY id_fonte_dado

--BRONZE
SELECT nm_produto, desc_origem, formato, sistema, volume, frequencia FROM view_bronze
WHERE id_cliente = 13
ORDER BY id_fonte_dado

--SILVER
SELECT nm_produto, desc_origem, formato, sistema, volume, frequencia, desc_regra, obrigatorio FROM view_bronze
WHERE id_cliente = 13
ORDER BY id_fonte_dado

--GOLD
SELECT nm_produto, desc_origem, formato, sistema, volume, frequencia, desc_regra, obrigatorio, operacao, descritivo_operacao FROM view_bronze
WHERE id_cliente = 13
ORDER BY id_fonte_dado


-------------------------------------------------------------------------------------------------------------------------------------------


--VIEW CORE

DROP VIEW view_cliente_core;

CREATE VIEW view_cliente_core AS
SELECT id_clienteproduto_core, prod.nm_produto, cc.recurso , cp.id_cliente AS id_cliente, cp.id_cliente_produto FROM ClienteProduto_Core cpc
INNER JOIN Core cc
	ON cc.id_core = cpc.id_core
INNER JOIN Cliente_Produto cp
	ON cp.id_cliente_produto = cpc.id_cliente_produto
INNER JOIN Produto prod
	ON prod.id_produto = cp.id_produto;


--TODOS
SELECT nm_produto, recurso FROM view_cliente_core
WHERE id_cliente = 13
ORDER BY id_clienteproduto

-------------------------------------------------------------------------------------------------------------------------------------------


--VIEW CORE
DROP VIEW view_cliente_funcionalidade;
CREATE VIEW view_cliente_funcionalidade AS
SELECT id_clienteproduto_funcionalidade, prod.nm_produto, func.nm_funcionalidade, cp.id_cliente AS id_cliente, cp.id_cliente_produto FROM ClienteProduto_Funcionalidade cpf
INNER JOIN Funcionalidade func
	ON func.id_funcionalidade = cpf.id_funcionalidade
INNER JOIN Cliente_Produto cp
	ON cp.id_cliente_produto = cpf.id_cliente_produto
INNER JOIN Produto prod
	ON prod.id_produto = cp.id_produto

SELECT * FROM view_cliente_funcionalidade
--FUNCIONALIDADE
SELECT id_clienteproduto_funcionalidade, id_cliente_produto, nm_produto, nm_funcionalidade FROM view_cliente_funcionalidade WHERE id_cliente = ?

-------------------------------------------------------------------------------------------------------------------------------------------

--TESTE
SELECT * FROM view_bronze WHERE id_cliente = 13
UPDATE Validador SET id_gold = NULL WHERE id_validador in (SELECT id_validador FROM view_bronze WHERE id_cliente = 13)



--CADASTRAR GOLD
DROP PROCEDURE proc_Cad_Gold_Silver
CREATE PROCEDURE proc_Cad_Gold_Silver @oparacao nvarchar(100), @desc_operacao nvarchar(100), @idcliente nvarchar(100)  AS

	INSERT INTO Gold (operacao, descritivo_operacao) values (@oparacao, @desc_operacao);

	UPDATE Validador SET id_gold = (SELECT MAX(id_gold) FROM Gold) WHERE id_validador in (SELECT id_validador FROM view_bronze WHERE id_cliente = @idcliente)

EXEC proc_Cad_Gold_Silver @oparacao = 'Série Temporal', @desc_operacao = 'aaaaaaaa' , @idcliente = 14;

-----------------------------------------------------

--EXCLUIR GOLD
DROP PROCEDURE proc_Excluir_Gold
CREATE PROCEDURE proc_Excluir_Gold @idgold nvarchar(100), @idcliente nvarchar(100)  AS

	UPDATE Validador SET id_gold = NULL WHERE id_validador IN (SELECT id_validador FROM view_bronze WHERE id_cliente = @idcliente);
	DELETE Gold WHERE id_gold = @idgold

EXEC proc_Excluir_Gold @idgold = 15, @idcliente = 14;

-----------------------------------------------------

--SELECT GOLD
SELECT DISTINCT id_gold, operacao, descritivo_operacao FROM view_bronze WHERE id_cliente = 15



--ATUALIZAR GOLD
UPDATE Gold SET operacao = ?, descritivo_operacao = ? WHERE id_gold = ?

SELECT operacao, descritivo_operacao FROM Gold






/*
--PROXIMA VIEW
INSERT INTO ClienteProduto_Core (id_cliente_produto, id_core)
VALUES (3,1),
	   (5,2),
	   (5,3),
	   (5,4),
	   (4,4),
	   (2,3);

INSERT INTO ClienteProduto_Funcionalidade (id_cliente_produto, id_funcionalidade)
VALUES (3,1),
	   (5,2),
	   (5,3),
	   (5,4),
	   (4,4),
	   (2,3);


SELECT prod.nm_produto, cc.recurso FROM ClienteProduto_Core cpc
INNER JOIN Core cc
ON cc.id_core = cpc.id_core
INNER JOIN Cliente_Produto cp
ON cp.id_cliente_produto = cpc.id_cliente_produto
INNER JOIN Produto prod
ON prod.id_produto = cp.id_produto
WHERE cp.id_cliente = 1
--AND prod.nm_produto = 'Marketing & Planning'
ORDER BY 1, 2 ASC



SELECT prod.nm_produto, func.nm_funcionalidade FROM ClienteProduto_Funcionalidade cf
INNER JOIN Funcionalidade func
ON func.id_funcionalidade = cf.id_funcionalidade
INNER JOIN Cliente_Produto cp
ON cp.id_cliente_produto = cf.id_cliente_produto
INNER JOIN Produto prod
ON prod.id_produto = cp.id_produto
WHERE cp.id_cliente = 1
--AND prod.nm_produto = 'Marketing & Planning'
ORDER BY 1, 2 ASC

*/