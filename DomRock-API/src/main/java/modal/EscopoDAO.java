
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
			stm.setString(4, escopo.getIdCliente());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
public List<EscopoDTO> consultar(String idclienteproduto) {
		
		List<EscopoDTO> clientes = new ArrayList<>();
	String sql = "SELECT * FROM Fonte_dado WHERE id_cliente_produto LIKE '%" +idclienteproduto+ "%'";
	  
	try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
		ResultSet resultSet = stm.executeQuery();
		
		while (resultSet.next()){
		
			EscopoDTO escopo = new EscopoDTO();
			
			escopo.setIdclienteproduto(resultSet.getInt("id_cliente_produto"));
			escopo.setIdCliente(resultSet.getString("id_cliente"));
			escopo.setIdProduto(resultSet.getInt("id_produto"));
			
			clientes.add(escopo);
			
	
		}
		
		resultSet.close();
		stm.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	
	
	return clientes;
}
}
			
	
