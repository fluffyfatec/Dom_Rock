package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.view.Alerts;

import DTO.CadastroUsuarioDTO;
import javafx.scene.control.Alert;
import modal.ConnectionFactory;

public class ConsultaUsuario {

	Connection conn; 
	PreparedStatement stm;
	ResultSet rs;
	
	public CadastroUsuarioDTO consultarusuario (String usuario, String senha){ 
		 try (Connection conn = new ConnectionFactory().conectaBD();){ 
			 CadastroUsuarioDTO objusuarioDTO = new CadastroUsuarioDTO();
			 
			 stm = conn.prepareStatement("Select * from Usuario Where usuario  = ? and senha = ?");
			 // verifica se a consulta encontrou o usuario com usuario e senha informado
	         stm.setString(1, usuario); 
	         stm.setString(2, senha); 
	         rs = stm.executeQuery(); 
	         
	         if(rs.next()){ // se encontrou o usuario com a senha
	        	 Alerts.display("AVISO", "LOGIN FEITO COM SUCESSO!");
	        	return objusuarioDTO; 
	         } else {
	        	 Alerts.display("AVISO", "ERRO NO LOGIN");
	            return objusuarioDTO;
	         }
	 	 } catch (SQLException ex) {
	           return null;
	     }
	    }
	
}
