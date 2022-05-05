
--------------------------------------
----------PESQUISA TABELAS-------------
--------------------------------------


-------PESQUISA CLIENTE-------
SELECT * FROM Cliente

--------PESQUISA PRODUTO-------
SELECT * FROM Produto;

--------PESQUISA CORE-------
SELECT * FROM Core;

-------PESQUISA FUNCIONALIDADE-------
SELECT * FROM Funcionalidade;



--------DENTRO DO WHERE INFORMAR O ID_CLIENTE DA PESQUISA---------

--------------------PESQUISA CLIENTE_CORE-------------------------
SELECT client.razao_social, cor.recurso 
FROM Cliente client
INNER JOIN Cliente_Core client_cor
  ON client_cor.cc_id_cliente = client.id_cliente
INNER JOIN Core cor
  ON cor.id_core = client_cor.cc_id_core
WHERE client.id_cliente = 155;


--------------------PESQUISA CLIENTE_PRODUTO------------------------- 
SELECT client.razao_social, prod.nm_produto, client_prod.dado_min
FROM Cliente client
INNER JOIN Cliente_Produto client_prod
  ON client_prod.cp_id_cliente = client.id_cliente
INNER JOIN Produto prod
  ON prod.id_produto = client_prod.cp_id_produto
WHERE client.id_cliente = 155;


--------------------PESQUISA CLIENTE_FUNCIONALIDADE-------------------
SELECT client.razao_social, func.nm_funcionalidade
FROM Cliente client
INNER JOIN Cliente_Funcionalidade client_func
  ON client_func.cf_id_cliente = client.id_cliente
INNER JOIN Funcionalidade func
  ON func.id_funcionalidade = client_func.cf_id_funcionalidade
WHERE client.id_cliente = 155;

