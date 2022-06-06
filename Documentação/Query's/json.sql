--SELECT CLIENTE PRODUTO CORE
SELECT cli.razao_social, vcc.nm_produto, vcc.recurso FROM view_cliente_core vcc LEFT JOIN Cliente cli ON cli.id_cliente = vcc.id_cliente ORDER BY cli.razao_social, vcc.nm_produto ASC


--SELECT CLIENTE PRODUTO FUNCIONALIDADE
SELECT cli.razao_social, vcf.nm_produto, vcf.nm_funcionalidade  FROM view_cliente_funcionalidade vcf LEFT JOIN Cliente cli ON cli.id_cliente = vcf.id_cliente ORDER BY cli.razao_social, vcf.nm_produto ASC


--SELECT BRONZE SILVER GOLD
SELECT * FROM view_json_bronze_silver_gold ORDER BY razao_social, nm_produto ASC



CREATE VIEW view_json_bronze_silver_gold AS

SELECT ISNULL(cli.razao_social, 'NULL') AS razao_social, 
	ISNULL(vb.nm_produto, 'NULL') AS nm_produto, 
	ISNULL(vb.desc_origem, 'NULL') AS desc_origem, 
	ISNULL(vb.formato, 'NULL') AS formato, 
	ISNULL(vb.sistema, 'NULL') AS sistema, 
	ISNULL(vb.volume, 'NULL') AS volume, 
	ISNULL(vb.frequencia, 'NULL') AS frequencia, 
	ISNULL(vb.desc_regra, 'NULL') AS desc_regra, 
	ISNULL(vb.obrigatorio, 'NULL') AS obrigatorio, 
	ISNULL(vb.operacao, 'NULL') AS operacao, 
	ISNULL(vb.descritivo_operacao, 'NULL') AS descritivo_operacao 
FROM view_bronze vb
LEFT JOIN Cliente cli
  ON cli.id_cliente = vb.id_cliente;


--------------------------------------------------------------------------------------------------------

SELECT id_cliente, razao_social, cnpj, segmento, datahora_cadastro
FROM Cliente
FOR JSON AUTO

SELECT name, state_desc, recovery_model_desc
FROM Cliente
FOR JSON AUTO













