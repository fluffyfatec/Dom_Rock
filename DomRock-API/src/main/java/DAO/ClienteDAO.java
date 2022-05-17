package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DTO.Cliente;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClienteDAO {

	
	//Connection connection;
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	
	
	public void cadastrar(Cliente cliente) {
		
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
	
	void exibiDialogoERRO(String erro) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Informação");
    	alert.setHeaderText(null);
    	alert.setContentText(erro);
    	alert.showAndWait();
    	
    }

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE Cliente SET razao_social = ?, cnpj = ?, segmento = ? WHERE id_cliente = ?";
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			stm.setString(1, cliente.getRazao_social());
			stm.setString(2, cliente.getCnpj());
			stm.setString(3, cliente.getSegmento());
			stm.setInt(4, cliente.getId_cliente());
			
			System.out.println('1'+ cliente.getRazao_social());
			System.out.println('2'+ cliente.getCnpj());
			System.out.println('3'+ cliente.getSegmento());
			System.out.println('4'+ cliente.getId_cliente());

			
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

	public List<Cliente> consultar(String razao_social) {
		
		List<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM Cliente WHERE razao_social LIKE '%" + razao_social + "%'";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				Cliente cliente = new Cliente();
				
				cliente.setId_cliente(resultSet.getInt("id_cliente"));
				cliente.setRazao_social(resultSet.getString("razao_social"));
				cliente.setCnpj(resultSet.getString("cnpj"));
				cliente.setSegmento(resultSet.getString("segmento"));
				cliente.setDatahora_cadastro(resultSet.getDate("datahora_cadastro"));
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
	
	
public List<Cliente> lista(Cliente cliente) {
		
		List<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT id_cliente, razao_social FROM Cliente WHERE segmento = 'Atacado' ";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				Cliente cliente1 = new Cliente();
				
				cliente1.setId_cliente(resultSet.getInt("id_cliente"));
				cliente1.setRazao_social(resultSet.getString("razao_social"));
				
				clientes.add(cliente1);
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
