package com.example.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IntroducaoController implements Initializable {
	@FXML
	private Menu bntClienteintro;
	@FXML
	private Menu inputAjudaintro;
	@FXML
	private ComboBox<String> boxSegmento = new ComboBox<String>();
	@FXML
	private TextField txtCnpj;
	@FXML
	private TextField txtNome;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> list = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo",
				"Governo");

		boxSegmento.setItems(list);

		boxSegmento.getSelectionModel().selectFirst();
	}

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

	@FXML
	void inputCadastrarCliente(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("Cadastro.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 380, 254);
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
	void boxSegmento(ActionEvent event) {

	}

	@FXML
	void btnCadastrarCliente(ActionEvent event) {

		String selectnomeSetor = this.boxSegmento.getSelectionModel().getSelectedItem().toString();
		String nomeCliente = this.txtNome.getText();
		String cnpjCliente = this.txtCnpj.getText();

		if (selectnomeSetor.length() == 0) {
			Alerts.display("ERRO", "Por favor, insira uma Razão Social");
		}

		if (cnpjCliente.length() != 14 && selectnomeSetor.length() != 0) {
			Alerts.display("ERRO", "Por favor, insira um CNPJ válido");
		}

		if (selectnomeSetor.length() != 0 && cnpjCliente.length() == 14) {
			System.out.println(selectnomeSetor);
			System.out.println(nomeCliente);
			System.out.println(cnpjCliente);
			
			Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");
		}
		
		txtNome.setText(null);
		txtCnpj.setText(null);
	}

	@FXML
	void btnLimparCliente(ActionEvent event) {

	}
}
