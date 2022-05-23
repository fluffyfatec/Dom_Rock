
package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EscopoDAO {

	Connection con;
	PreparedStatement stm;
	ResultSet rs;

	public EscopoDTO consultaId(String cnpj) {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			EscopoDTO objescopoDTO = new EscopoDTO();
			stm = con.prepareStatement("Select * from Cliente where cnpj = ?");
			stm.setString(1, cnpj);
			rs = stm.executeQuery();

			if (rs.next()) {
				objescopoDTO.setCnpj(rs.getString("cnpj"));
				objescopoDTO.setRazaoSocial(rs.getString("razao_social"));
				objescopoDTO.setIdCliente(rs.getString("id_cliente"));
				return objescopoDTO;
			} else {
				return null;
			}

		} catch (SQLException ex) {
			return null;
		}

	}
	public void cadastrarDescritivo(EscopoDTO escopo) {
		
		String sql = "INSERT INTO Descritivo (objetivo_negocio," 
				+ "entregavel_min,"
				+ "entregavel_possivel, id_cliente)" 
				+ "values (?,?,?,?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			
			
			stm.setString(1, escopo.getEntregaveisMinimos());
			stm.setString(2, escopo.getObjNegocios());
			stm.setString(3, escopo.getEntregaveisPossiveis());
			stm.setString(4, escopo.getidCliente());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public EscopoDTO consultaProduto(String idProduto) {
		try (Connection con = new ConnectionFactory().conectaBD()) {
			EscopoDTO objidProduto = new EscopoDTO();
			stm = con.prepareStatement("Select * from Produto where id_produto = ?");
			stm.setString(1, idProduto);
			rs = stm.executeQuery();

			if (rs.next()) {
				objidProduto.setOptimization(rs.getString("optimization"));
				objidProduto.setMatchingRisk(rs.getString("matchingRisk"));
				objidProduto.setVox(rs.getString("vox"));
				objidProduto.setPricing(rs.getString("pricing"));
				objidProduto.setMarketingPlanning(rs.getString("marketingPlanning"));
				objidProduto.setSalesDistribution(rs.getString("salesDistribution"));

				
				return objidProduto;
			} else {
				return null;
			}

		} catch (SQLException ex) {
			return null;
		}

	}
	
}
