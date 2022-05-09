package com.example.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IntroducaoController {
	@FXML
	private Menu bntClienteintro;
	@FXML
	private Menu inputAjudaintro;

	
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
	void inputDesconectarintro(ActionEvent event) {

	}
	@FXML
	void inputBuscarintro(ActionEvent event) {

	}
}
