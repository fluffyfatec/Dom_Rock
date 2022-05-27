package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.example.view.Alerts;

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
	     
	         if(rs.next()){ // se encontrou o usuario com a senha
	        	 LoginController objlogon = new LoginController();
	        	 exibiDialogoConfirmacao("LOGIN FEITO COM SUCESSO!");
	        	 objlogon.abrirIntroducao();
	        	return objusuarioDTO; 
	         } else {
	        	 exibiDialogoERRO("ERRO NO LOGIN");
	            return objusuarioDTO;
	         }
	 	 } catch (SQLException ex) {
	           return null;
	     }
	    }
	
	void exibiDialogoERRO(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(erro);

		alert.showAndWait();

	}

	private boolean exibiDialogoConfirmacao(String confirmacao) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText(null);
		alert.setContentText(confirmacao);

		Optional<ButtonType> opcao = alert.showAndWait();

		if (opcao.get() == ButtonType.OK)
			return true;
		return false;

	}
	
}