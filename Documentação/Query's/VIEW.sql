SELECT * FROM Cliente


--VIEW CLIENTE
DROP VIEW view_cliente;

CREATE VIEW view_cliente AS
SELECT cli.id_cliente AS id_cliente, 
	  (CONCAT(UPPER(SUBSTRING(cli.razao_social, 1, 1)) , LOWER(SUBSTRING(cli.razao_social, 2, 80)))) AS razao_social,
	   cli.cnpj as cnpj,
	   cli.segmento AS segmento,  
	   FORMAT(cli.datahora_cadastro , 'dd/MM/yyyy HH:mm:ss') as datahora_cadastro
FROM Cliente cli;

------------------------------------------------------------------------------------------
--VIEW USUARIO

DROP VIEW view_usuario;

CREATE VIEW view_usuario AS
SELECT usu.id_usuario AS id_usuario,
		(CONCAT(UPPER(SUBSTRING(usu.nome, 1, 1)) , LOWER(SUBSTRING(usu.nome, 2, 80)))) AS nome,
		(CONCAT(UPPER(SUBSTRING(usu.funcao, 1, 1)) , LOWER(SUBSTRING(usu.funcao, 2, 80)))) AS funcao,
		usu.usuario AS usuario,
		REPLACE(usu.senha, usu.senha, '****') AS senha
FROM Usuario usu;



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
DELETE Validador WHERE id_validador = 4
--VIEW BRONZE-----------------------------------------------
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
valid.id_validador AS id_validador
FROM Fonte_dado fd
INNER JOIN Cliente_Produto cp
ON cp.id_cliente_produto = fd.id_cliente_produto
INNER JOIN Produto prod
ON prod.id_produto = cp.id_produto
INNER JOIN Origem_dado od
ON od.id_origem_dado = fd.id_origem_dado
INNER JOIN Formato fort
ON fort.id_formato = fd.id_formato
INNER JOIN Sistema sis
ON sis.id_sistema = fd.id_sistema
INNER JOIN Validador valid
ON valid.id_fonte_dado = fd.id_fonte_dado;
----------------------------------------------------------
SELECT id_fonte_dado, nm_produto, desc_origem, formato, volume, sistema, frequencia, desc_regra, obrigatorio, id_validador FROM view_bronze WHERE id_cliente = ?

--VIEW CORE-----------------------------------------------
DROP VIEW view_cliente_core;

CREATE VIEW view_cliente_core AS
SELECT id_clienteproduto_core, prod.nm_produto, cc.recurso , cp.id_cliente AS id_cliente, cp.id_cliente_produto FROM ClienteProduto_Core cpc
INNER JOIN Core cc
	ON cc.id_core = cpc.id_core
INNER JOIN Cliente_Produto cp
	ON cp.id_cliente_produto = cpc.id_cliente_produto
INNER JOIN Produto prod
	ON prod.id_produto = cp.id_produto;
--CORE
SELECT id_clienteproduto_core, id_cliente_produto, nm_produto, recurso FROM view_cliente_core WHERE id_cliente = ?
SELECT * FROM ClienteProduto_Core
----------------------------------------------------------


--VIEW CORE-----------------------------------------------
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
----------------------------------------------------------


