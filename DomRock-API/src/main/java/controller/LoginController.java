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

public class LoginController {

	@FXML
    private TextField txtUsuario;
	
    @FXML
    private PasswordField txtSenha;
    
    private String resposta;

    public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@FXML private javafx.scene.control.Button btnConectar;
    
    @FXML
    void btnConectar(ActionEvent event) {
    	String usuario = txtUsuario.getText();
    	String senha = txtSenha.getText();
    	
    	ConsultaUsuario dao = new ConsultaUsuario();
		UsuarioDTO objusuarioDTO = dao.consultarusuario(usuario, senha);
		
		if (objusuarioDTO.getControle() == 1) {
		Stage stage = (Stage) btnConectar.getScene().getWindow(); //Obtendo a janela atual
        stage.close();
		}
    }    
    
    @FXML
    public void abrirIntroducao() {
    	Stage stage = new Stage();
    	stage.close();
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/Introducao.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load());
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		stage.setTitle("Sistema de Gerenciamento de Clientes - Dom Rock");
		stage.setResizable(true);
		stage.setMaximized(true);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
    
   
}
    
