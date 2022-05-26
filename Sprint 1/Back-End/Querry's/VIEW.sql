DROP VIEW view_cliente;

CREATE VIEW view_cliente AS
SELECT cli.id_cliente AS id_cliente, 
	  (CONCAT(UPPER(SUBSTRING(cli.razao_social, 1, 1)) , LOWER(SUBSTRING(cli.razao_social, 2, 80)))) AS razao_social,
	   CONCAT(SUBSTRING(cli.cnpj, 1, 2), '.', SUBSTRING(cli.cnpj, 3, 3) , '.' , SUBSTRING(cli.cnpj, 6, 3), '/',  SUBSTRING(cli.cnpj, 9, 4), '-', SUBSTRING(cli.cnpj, 13, 2)) AS cnpj,
	   cli.segmento AS segmento,  
	   FORMAT(cli.datahora_cadastro , 'dd/MM/yyyy HH:mm:ss') as datahora_cadastro
FROM Cliente cli;


SELECT CONCAT(id_cliente , razao_social)  FROM Cliente
------------------------------------------------------------------------------------------
DROP VIEW view_usuario;
CREATE VIEW view_usuario AS
SELECT usu.id_usuario AS id_usuario,
		(CONCAT(UPPER(SUBSTRING(usu.nome, 1, 1)) , LOWER(SUBSTRING(usu.nome, 2, 80)))) AS nome,
		(CONCAT(UPPER(SUBSTRING(usu.funcao, 1, 1)) , LOWER(SUBSTRING(usu.funcao, 2, 80)))) AS funcao,
		usu.usuario AS usuario,
		REPLACE(usu.senha, usu.senha, '**********') AS senha
FROM Usuario usu;


