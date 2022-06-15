package modal;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExportarDAO {
	Connection con;
	PreparedStatement stm;
	ResultSet rs;


	public EscopoDTO exportarjson() {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("Select * from Cliente");
			rs = stm.executeQuery();
			JSONArray listcliente = new JSONArray();
			while (rs.next()) {
				JSONObject jsoncliente = new JSONObject();
				jsoncliente.put("cliente_id_cliente",rs.getString("id_cliente"));
				jsoncliente.put("cliente_razao_social",rs.getString("razao_social"));
				jsoncliente.put("cliente_cnpj",rs.getString("cnpj"));
				jsoncliente.put("cliente_segmento",rs.getString("segmento"));
				jsoncliente.put("cliente_datahora",rs.getString("datahora_cadastro"));
				System.out.println(jsoncliente);
				listcliente.add(jsoncliente);
				}
			try {
		        FileWriter file = new FileWriter("cliente.json");
		        file.write(listcliente.toJSONString());
		        file.flush();
		        file.close();
			} catch (IOException e) {
	        e.printStackTrace();}
		} catch (SQLException ex) {
			return null;
		}
		JSONArray listclienteproduto = new JSONArray();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("SELECT cp.id_cliente_produto, c.razao_social, prod.nm_produto FROM Cliente_Produto cp INNER JOIN Produto prod ON prod.id_produto = cp.id_produto INNER JOIN Cliente c ON c.id_cliente = cp.id_cliente;");
			rs = stm.executeQuery();
			while (rs.next()) {
				JSONObject jsonclienteproduto = new JSONObject();
				jsonclienteproduto.put("id_cliente_produto",rs.getString("id_cliente_produto"));
				jsonclienteproduto.put("razao_social",rs.getString("razao_social"));
				jsonclienteproduto.put("nm_produto",rs.getString("nm_produto"));
				listclienteproduto.add(jsonclienteproduto);
				}
			stm.close();
			try {
		        FileWriter file = new FileWriter("produtocliente.json");
		        file.write(listclienteproduto.toJSONString());
		        file.flush();
		        file.close();
			} catch (IOException e) {
	        e.printStackTrace();}
		} catch (SQLException ex) {
			return null;
		}
		JSONArray listclienteprodutocore = new JSONArray();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("SELECT cli.razao_social, vcc.nm_produto, vcc.recurso FROM view_cliente_core vcc LEFT JOIN Cliente cli ON cli.id_cliente = vcc.id_cliente ORDER BY cli.razao_social, vcc.nm_produto ASC");
			rs = stm.executeQuery();
		while (rs.next()) {
			JSONObject jsonclienteprodutocore = new JSONObject();
			jsonclienteprodutocore.put("razao_social",rs.getString("razao_social"));
			jsonclienteprodutocore.put("nm_produto",rs.getString("nm_produto"));
			jsonclienteprodutocore.put("recurso",rs.getString("recurso"));
			listclienteprodutocore.add(jsonclienteprodutocore);
			}
		stm.close();
		try {
	        FileWriter file = new FileWriter("produtoclientecore.json");
	        file.write(listclienteprodutocore.toJSONString());
	        file.flush();
	        file.close();
		} catch (IOException e) {
        e.printStackTrace();}
	} catch (SQLException ex) {
		return null;
	}
		JSONArray listclienteprodutofunc = new JSONArray();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("SELECT cli.razao_social, vcf.nm_produto, vcf.nm_funcionalidade  FROM view_cliente_funcionalidade vcf LEFT JOIN Cliente cli ON cli.id_cliente = vcf.id_cliente ORDER BY cli.razao_social, vcf.nm_produto ASC");
			rs = stm.executeQuery();
		while (rs.next()) {
			JSONObject jsonclienteprodutofunc = new JSONObject();
			jsonclienteprodutofunc.put("razao_social",rs.getString("razao_social"));
			jsonclienteprodutofunc.put("nm_produto",rs.getString("nm_produto"));
			jsonclienteprodutofunc.put("nm_funcionalidade",rs.getString("nm_funcionalidade"));
			listclienteprodutofunc.add(jsonclienteprodutofunc);
			}
		stm.close();
		try {
	        FileWriter file = new FileWriter("produtoclientefunc.json");
	        file.write(listclienteprodutofunc.toJSONString());
	        file.flush();
	        file.close();
		} catch (IOException e) {
        e.printStackTrace();}
	} catch (SQLException ex) {
		return null;
	}
		JSONArray listativacao = new JSONArray();
		try (Connection con = new ConnectionFactory().conectaBD()) {
			stm = con.prepareStatement("SELECT * FROM view_json_bronze_silver_gold ORDER BY razao_social, nm_produto ASC");
			rs = stm.executeQuery();
		while (rs.next()) {
			JSONObject jsonativacao = new JSONObject();
			jsonativacao.put("razao_social",rs.getString("razao_social"));
			jsonativacao.put("nm_produto",rs.getString("nm_produto"));
			jsonativacao.put("desc_origem",rs.getString("desc_origem"));
			jsonativacao.put("formato",rs.getString("formato"));
			jsonativacao.put("sistema",rs.getString("sistema"));
			jsonativacao.put("volume",rs.getString("volume"));
			jsonativacao.put("frequencia",rs.getString("frequencia"));
			jsonativacao.put("desc_regra",rs.getString("desc_regra"));
			jsonativacao.put("obrigatorio",rs.getString("obrigatorio"));
			jsonativacao.put("operacao",rs.getString("operacao"));
			jsonativacao.put("descritivo_operacao",rs.getString("descritivo_operacao"));
			listativacao.add(jsonativacao);
			}
		stm.close();
		try {
	        FileWriter file = new FileWriter("ativacao.json");
	        file.write(listativacao.toJSONString());
	        file.flush();
	        file.close();
		} catch (IOException e) {
        e.printStackTrace();}
	} catch (SQLException ex) {
		return null;
	}
		return null;
	}
		
	
	
}

			
	


