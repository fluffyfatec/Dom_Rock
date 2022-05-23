DROP VIEW view_cliente;

CREATE VIEW view_cliente AS
SELECT id_cliente AS id_cliente, 
	   LOWER(razao_social) AS razao_social, 
	   cnpj AS cnpj, 
	   segmento AS segmento,  
	   FORMAT(datahora_cadastro , 'dd/MM/yyyy HH:mm:ss') as datahora_cadastro
FROM Cliente;


SELECT CONCAT(id_cliente , razao_social)  FROM Cliente