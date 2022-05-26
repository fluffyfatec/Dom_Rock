package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modal.ConsultaUsuario;
import modal.UsuarioDTO;

public class LogonController {

	@FXML
    private TextField txtUsuario;
	
    @FXML
    private PasswordField txtSenha;

    @FXML
    void btnConectar(ActionEvent event) {
    	String usuario = txtUsuario.getText();
    	String senha = txtSenha.getText();
    	
    	ConsultaUsuario dao = new ConsultaUsuario();
        UsuarioDTO objusuarioDTO = dao.consultarusuario(usuario, senha);
    }    

}
