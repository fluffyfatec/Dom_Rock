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
		nm_setor,		
		dt_cadastro
FROM Cliente
WHERE id_cliente = '';


--Pesquisa Funcionalidade
SELECT  id_funcionalidade,
		nm_funcionalidade
FROM Funcionalidade
WHERE id_funcionalidade = '';


--Pesquisa Core
SELECT  id_core,
		recurso
FROM Core
WHERE id_core = '';


--Pesquisa Entregavel
SELECT  id_entregavel,
		objetivo_negocio,
		entregavel_min,
		entregavel_posseivel
FROM Entregavel
WHERE id_entregavel = '';



--Pesquisa Solucao
SELECT  id_solucao,
		nm_solucao
FROM Solucao
WHERE id_solucao = '';


--Pesquisa Produto
SELECT  id_produto,
		nm_produto,
		dado_min,
		id_solucao
FROM Produto
WHERE id_produto = '';

ALTER  -- EDITAR






--------------------------------------
----------INSERT - INSERIR------------
--------------------------------------
select * from Cliente;
INSERT INTO Cliente (razao_social, cnpj, segmento, objetivo_negocio, entregavel_min, entregavel_posseivel)
VALUES ('value1', '12356789', 'value3', 'value4', 'value5', 'value6');

INSERT INTO Funcionalidade (nm_cliente, cnpj, nm_setor, dt_cadastro, dt_atualizacao)
VALUES ('value1', 'value2', 'value3', 'value4', 'value5', 'value6', 'value', 'value5');

INSERT INTO Core (recurso)
VALUES ('value1');

INSERT INTO Entregavel (objetivo_negocio, entregavel_min, entregavel_posseivel)
VALUES ('value1', 'value2', 'value3');

INSERT INTO Solucao (nm_solucao)
VALUES ('value1');

INSERT INTO Produto (nm_produto, dado_min)
VALUES ('value1', 'value2');


--------------------------------------
----------ALTER  -- EDITAR------------
--------------------------------------