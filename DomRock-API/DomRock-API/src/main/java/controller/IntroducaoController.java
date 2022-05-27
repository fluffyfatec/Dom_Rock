package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IntroducaoController implements Initializable {
	
	@FXML
	private Menu bntClienteintro;
	@FXML
	private Menu inputUsuario;
	@FXML
	private Menu btnUsuario;
	@FXML
	private Menu inputCadastrarintro;
	@FXML
	private Menu inputAjudaintro;
	@FXML
	private Menu inputCadastrarcliente;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	//VAI PARA TELA CRUD ATIVAÇÃO
	@FXML
	void inputCadastrarintro( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudAtivacao.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 807, 550);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Etapas - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	

	//VAI PARA TELA CRUD CLIENTE
	@FXML
	void inputCadastrarCliente( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudCliente.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load() );
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Clientes - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	
	//VAI PARA TELA CRUD USUARIO
	@FXML
	void btnUsuario( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudUsuario.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 668, 432);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle(" Usuário - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();
	    }
	
	//VAI PARA TELA LOGON
	@FXML
	void btnSair( ) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/Logon.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 367, 297);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle(" Logon - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();
	}
	
	


}
