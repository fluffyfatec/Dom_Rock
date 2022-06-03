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

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClienteDAO {

	
	//Connection connection;
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	
	
	public void cadastrar(ClienteDTO cliente) {
		
		String sql = "INSERT INTO Cliente(razao_social, cnpj, segmento, datahora_cadastro) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			
			// Puxando a data e hora e formatando
			Calendar cal = Calendar.getInstance();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
			String date = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(timestamp);
			//exibiDialogoERRO(cliente.getRazao_social());
			
			stm.setString(1, cliente.getRazao_social());
			stm.setString(2, cliente.getCnpj());
			stm.setString(3, cliente.getSegmento());
			stm.setString(4, date);
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	public void atualizar(ClienteDTO cliente) {
		String sql = "UPDATE Cliente SET razao_social = ?, cnpj = ?, segmento = ? WHERE id_cliente = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, cliente.getRazao_social());
			stm.setString(2, cliente.getCnpj());
			stm.setString(3, cliente.getSegmento());
			stm.setInt(4, cliente.getId_cliente());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void deletar(Integer id_cliente) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setInt(1, id_cliente);
			
			stm.execute();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<ClienteDTO> consultar(String cnpj) {
		
		List<ClienteDTO> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM view_cliente WHERE cnpj LIKE '%" + cnpj + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				ClienteDTO cliente = new ClienteDTO();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setRazao_social(resultSet.getString("razao_social"));
				cliente.setCnpj(resultSet.getString("cnpj"));
				cliente.setSegmento(resultSet.getString("segmento"));
				cliente.setDatahora_cadastro(resultSet.getString("datahora_cadastro"));
				clientes.add(cliente);
				
		
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
