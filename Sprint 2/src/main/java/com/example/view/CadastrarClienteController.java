package com.example.view;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.CadastroDAO;
import DAO.ConsultaId;
import DTO.CadastroDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CadastrarClienteController implements Initializable {
	
	@FXML
	private TextField txtCnpj = new TextField();
	@FXML
	private TextField txtNome;
	@FXML
	private ComboBox<String> boxSegmento = new ComboBox<String>();
	private CadastroDAO cadastroCliente = new CadastroDAO();
	private ConsultaId consultaId = new ConsultaId();

	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> list = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo",
				"Governo");

		boxSegmento.setItems(list);

		boxSegmento.getSelectionModel().selectFirst();
	}
	
	@FXML
	void boxSegmento(ActionEvent event) {
		CadastroDTO objcadastroDTO = new CadastroDTO();
		if (boxSegmento.getSelectionModel().getSelectedItem() != null) {
			String nomeSetor = boxSegmento.getSelectionModel().getSelectedItem().toString();
			objcadastroDTO.setNomeSetor(nomeSetor);
		}
	}
	
	@FXML
	void btnLimparCliente(ActionEvent event) {
		// Bot„o de alerta
		final Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("ConfirmaÁ„o");
		window.setMinWidth(500);
		window.setHeight(200);
		window.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));

		Label label = new Label();
		label.setText("Todos os campos ser„o limpos. Confirmar?");
		label.setAlignment(Pos.CENTER);
		label.setStyle("-fx-font-size: 18px ; -fx-background-color: transparent ; -fx-text-fill: white; ");

		Button closeButtom = new Button("Confirmar");
		closeButtom.setOnAction(e -> {
			window.close();
			
		txtNome.setText(null);
		txtCnpj.setText(null);
        boxSegmento.getSelectionModel().selectFirst();
        });
        
		closeButtom.setMinWidth(50);
		closeButtom.setMaxHeight(100);
		closeButtom.setStyle("-fx-font-size: 16px ; -fx-background-color: #1BB2CF; -fx-border-radius: 5px ;"
				+ "-fx-border-color: white ; -fx-border-width: 0.5px ; -fx-text-fill: white ; -fx-display: inline-block;");

		Button cancelButtom = new Button("Cancelar");
		cancelButtom.setOnAction(e -> {
			event.consume();
			window.close();
		});
		cancelButtom.setMinWidth(50);
		cancelButtom.setMaxHeight(100);
		cancelButtom.setStyle("-fx-font-size: 16px ; -fx-background-color: transparent ; -fx-border-radius: 5px ;"
				+ "-fx-border-color: white ; -fx-border-width: 0.5px ; -fx-text-fill: white ;-fx-display: inline-block;");

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButtom, cancelButtom);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #2d343a ;");

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	@FXML
	void btnCadastrarCliente(ActionEvent event) {

		String selectnomeSetor = this.boxSegmento.getSelectionModel().getSelectedItem().toString();
		String nomeCliente = this.txtNome.getText();
		String cnpjCliente = this.txtCnpj.getText();
		
		if (nomeCliente.length() == 0) {
			Alerts.display("ERRO", "Por favor, insira uma Raz√£o Social");
		}

		if (cnpjCliente.length() != 14) {
			Alerts.display("ERRO", "Por favor, insira um CNPJ v√°lido");
		}

		if (nomeCliente.length() != 0 && cnpjCliente.length() == 14) {
			
			CadastroDTO objcadastroDTO = new CadastroDTO();
			
			objcadastroDTO.setCnpj(cnpjCliente);
			objcadastroDTO.setNomeCliente(nomeCliente);
			objcadastroDTO.setNomeSetor(selectnomeSetor);
			
			cadastroCliente.cadastroCliente(objcadastroDTO);
			
			Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");
			
			txtNome.setText(null);
			txtCnpj.setText(null);
	        boxSegmento.getSelectionModel().selectFirst();
			
		}
		
		
	}

}
