package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.CadastroDTO;
import DTO.ClienteDTO;

public class ConsultaId {

	Connection conn; 
	PreparedStatement stm;
	ResultSet rs;


	public ClienteDTO consultarid (String cnpj){ 
		 try (Connection  conn = new ConexaoDAO().conectaBD(); ){ 
			 ClienteDTO objclienteDTO =new ClienteDTO();
			 stm = conn.prepareStatement("Select * from Cliente Where cnpj  = ?");
	         stm.setString(1, cnpj); rs = stm.executeQuery(); // verifica se a consulta encontrou o cliente com a cnpj informado
	            if(rs.next()){ // se encontrou o

	      objclienteDTO.setCnpj(rs.getString("cnpj"));
	      objclienteDTO.setNomeCliente(rs.getString("razao_social"));
	      objclienteDTO.setIdCliente(rs.getString("id_cliente"));
	      return objclienteDTO; 
	            } else {
	                return null;
	            }
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
}
