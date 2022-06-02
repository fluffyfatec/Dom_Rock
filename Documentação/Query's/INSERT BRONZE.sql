--MEGA GAMBIARRA MASTER


INSERT INTO Fonte_dado(volume , frequencia , id_cliente_produto, id_origem_dado, id_formato, id_sistema)
VALUES( '200' , '15 dias' ,
		(SELECT cp.id_cliente_produto FROM Cliente_Produto cp
		INNER JOIN Produto prod
		ON prod.id_produto = cp.id_produto
		WHERE cp.id_cliente = 1
		AND prod.nm_produto = 'Vox')
		,
		(SELECT id_origem_dado FROM Origem_dado od
		WHERE od.desc_origem = 'SFTP')
		,
		(SELECT fmt.id_formato FROM Formato fmt
		WHERE fmt.formato = 'planilhas')
		,
		(SELECT sis.id_sistema FROM Sistema sis
		WHERE sis.sistema = 'Outros')
	  )

/*
		String sql = "INSERT INTO Fonte_dado(volume , frequencia , id_cliente_produto, id_origem_dado, id_formato, id_sistema)"
				+ "VALUES( ? , ? ,"
				+ "		(SELECT cp.id_cliente_produto FROM Cliente_Produto cp"
				+ "		INNER JOIN Produto prod"
				+ "		ON prod.id_produto = cp.id_produto"
				+ "		WHERE cp.id_cliente = ?"
				+ "		AND prod.nm_produto = ?)"
				+ "		,"
				+ "		(SELECT id_origem_dado FROM Origem_dado od"
				+ "		WHERE od.desc_origem = ?)"
				+ "		,"
				+ "		(SELECT fmt.id_formato FROM Formato fmt"
				+ "		WHERE fmt.formato = ?)"
				+ "		,"
				+ "		(SELECT sis.id_sistema FROM Sistema sis"
				+ "		WHERE sis.sistema = ?)"
				+ "	  )";

1 - getVolume
2 - getFrequencia
3 - getIdCliente
4 - getProduto
5 - getOrigemDado
6 - getFormato
7 - getSistema

SELECT * FROM Fonte_dado

SELECT * FROM Fonte_dado

SELECT cp.id_cliente_produto FROM Cliente_Produto cp
INNER JOIN Produto prod
ON prod.id_produto = cp.id_produto
WHERE cp.id_cliente = 1
AND prod.nm_produto = 'Vox'


SELECT prod.nm_produto FROM Cliente_Produto cp
INNER JOIN Produto prod
ON prod.id_produto = cp.id_produto
WHERE cp.id_cliente = 1
*/

-------------------------------------------------------------------
--Silver

SELECT * FROM Cliente_Produto cp
		INNER JOIN Produto prod
		ON prod.id_produto = cp.id_produto
		WHERE cp.id_cliente = 1
		AND prod.nm_produto = ?

SELECT * FROM Validador


SELECT * FROM Fonte_dado

DELETE Fonte_dado WHERE id_sistema = (SELECT id_sistema FROM Sistema WHERE sistema = 'Outros') AND id_origem_dado = (SELECT id_origem_dado FROM Origem_dado WHERE desc_origem = 'Upload') AND id_formato = (SELECT id_formato FROM Formato WHERE formato = 'planilhas') AND frequencia = '7 dias' AND volume = 'ffsdfed' 

/*
1 - Sistemas
2 - Origem Dado
3 - Formato
4 - Frequencia
5 - Volume
*/

