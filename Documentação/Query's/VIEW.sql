--VIEW CLIENTE
DROP VIEW view_cliente;

CREATE VIEW view_cliente AS
SELECT cli.id_cliente AS id_cliente, 
	  (CONCAT(UPPER(SUBSTRING(cli.razao_social, 1, 1)) , LOWER(SUBSTRING(cli.razao_social, 2, 80)))) AS razao_social,
	   CONCAT(SUBSTRING(cli.cnpj, 1, 2), '.', SUBSTRING(cli.cnpj, 3, 3) , '.' , SUBSTRING(cli.cnpj, 6, 3), '/',  SUBSTRING(cli.cnpj, 9, 4), '-', SUBSTRING(cli.cnpj, 13, 2)) AS cnpj,
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
		REPLACE(usu.senha, usu.senha, '**********') AS senha
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

