--------------------------------------
----------DELETAR---------------------
--------------------------------------

DELETE FROM Cliente WHERE id_cliente='';

DELETE FROM Funcionalidade WHERE id_funcionalidade='';

DELETE FROM Core WHERE id_core='';

DELETE FROM Entregavel WHERE id_entregavel='';

DELETE FROM Solucao WHERE id_solucao='';

DELETE FROM Produto WHERE id_produto='';



--------------------------------------
----------PESQUISA--------------------
--------------------------------------

--Pesquisa Cliente
SELECT  id_cliente,
		razao_social,	
		cnpj,		
		segmento,		
		objetivo_negocio,
		entregavel_min,
		entregavel_possivel,
		datahora_cadastro,
		datahora_atualizacao
FROM Cliente
WHERE id_cliente = '';

--------------------------------------
--Pesquisa Funcionalidade
SELECT  id_funcionalidade,
		nm_funcionalidade
FROM Funcionalidade
WHERE id_funcionalidade = '';

--------------------------------------
--Pesquisa Core
SELECT  id_core,
		recurso
FROM Core
WHERE id_core = '';

--------------------------------------
--Pesquisa Solucao
SELECT  id_solucao,
		nm_solucao
FROM Solucao
WHERE id_solucao = '';

--------------------------------------
--Pesquisa Produto
SELECT  id_produto,
		nm_produto,
		dado_min,
		id_solucao
FROM Produto
WHERE id_produto = '';



--------------------------------------
----------ALTER  -- EDITAR------------
--------------------------------------