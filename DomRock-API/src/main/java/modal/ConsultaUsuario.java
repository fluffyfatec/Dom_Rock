package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import controller.LoginController;
import modal.UsuarioDTO;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import modal.ConnectionFactory;

public class ConsultaUsuario {

	Connection conn; 
	PreparedStatement stm;
	ResultSet rs;
	
	public UsuarioDTO consultarusuario (String usuario, String senha){ 
		 try (Connection conn = new ConnectionFactory().conectaBD();){ 
			 UsuarioDTO objusuarioDTO = new UsuarioDTO();
			 
			 stm = conn.prepareStatement("Select * from Usuario Where usuario  = ? and senha = ?");
			 // verifica se a consulta encontrou o usuario com usuario e senha informado
	         stm.setString(1, usuario); 
	         stm.setString(2, senha); 
	         rs = stm.executeQuery(); 
	     
	         LoginController objlogin = new LoginController();
	         
	         if(rs.next()){ // se encontrou o usuario com a senha
	        	 objlogin.abrirIntroducao();
	        	 objusuarioDTO.setControle(1);
	        	return objusuarioDTO; 
	         } else {
	        	 exibiDialogoERRO("ERRO NO LOGIN");
	        	 objusuarioDTO.setControle(2);
	            return objusuarioDTO;
	         }
	 	 } catch (SQLException ex) {
	           return null;
	     }
	    }
	
	void exibiDialogoERRO(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Informacao");
		alert.setHeaderText(null);
		alert.setContentText(erro);

		alert.showAndWait();

	}
	
}
