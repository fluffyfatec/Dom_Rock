package com.example.view;

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
	void inputCadastrarintro(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("Hello.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 980, 580);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Cliente - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	@FXML
	private Menu bntClienteintro;
	@FXML
	private Menu inputCadastrarintro;
	@FXML
	private Menu inputAjudaintro;
	@FXML
	private Menu inputCadastrarcliente;
	@FXML
	private Menu inputBuscarintro;
	@FXML
	void inputAjudaintro (ActionEvent event) {
	}
	@FXML
	void inputDesconectarintro(ActionEvent event) {

	}

	@FXML
	void inputCadastrarCliente(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("CrudDomRock.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 679, 400);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Cliente - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	@FXML
	void inputBuscarintro(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("TelaBusca.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 980, 580 );
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Buscar Cliente - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	


}
