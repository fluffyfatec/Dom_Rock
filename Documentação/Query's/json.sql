SELECT * FROM Comentario;
SELECT * FROM Usuario;
SELECT * FROM Validador;

SELECT * FROM Fonte_dado;
SELECT * FROM ClienteProduto_Core;
SELECT * FROM ClienteProduto_Funcionalidade;
SELECT * FROM Cliente_Produto
ORDER BY 2 ASC

--INFO
SELECT * FROM Sistema;
SELECT * FROM Formato;
SELECT * FROM Origem_dado;
SELECT * FROM Core;
SELECT * FROM Funcionalidade;
SELECT * FROM Produto;
SELECT * FROM Solucao;

--PEGAR
SELECT * FROM Descritivo;
SELECT * FROM Cliente;


SELECT id_cliente, razao_social, cnpj, segmento, datahora_cadastro
FROM Cliente
FOR JSON AUTO

SELECT name, state_desc, recovery_model_desc
FROM Cliente
FOR JSON AUTO




SELECT * FROM Cliente_Produto
SELECT * FROM Fonte_dado
WHERE id_cliente_produto IN (1, 2, 3)


SELECT * FROM Cliente cli

INNER JOIN Descritivo dst
ON dst.id_cliente = cli.id_cliente
INNER JOIN Cliente_Produto cp
ON cp.id_cliente = cp.id_cliente


ORDER BY cp.id_cliente ASC









--
SELECT * FROM Cliente_Produto cp
INNER JOIN Descritivo dst
ON dst.id_cliente = cp.id_cliente
INNER JOIN Cliente cli
ON dst.id_cliente = cli.id_cliente
ORDER BY cp.id_cliente ASC













