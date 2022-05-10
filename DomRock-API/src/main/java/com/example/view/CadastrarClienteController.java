package com.example.view;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class CadastrarClienteController implements Initializable {
	
	@FXML
	private TextField txtCnpj;
	@FXML
	private TextField txtNome;
	@FXML
	private ComboBox<String> boxSegmento = new ComboBox<String>();
	private ClienteDAO cadastrarCliente = new ClienteDAO();

	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> list = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo",
				"Governo");

		boxSegmento.setItems(list);

		boxSegmento.getSelectionModel().selectFirst();
	}
	
	@FXML
	void boxSegmento(ActionEvent event) {
		ClienteDTO objclieClienteDTO = new ClienteDTO();
		if (boxSegmento.getSelectionModel().getSelectedItem() != null) {
			String nomeSetor = boxSegmento.getSelectionModel().getSelectedItem().toString();
			objclieClienteDTO.setNomeSetor(nomeSetor);
		}
	}

	@FXML
	void btnCadastrarCliente(ActionEvent event) {

		String selectnomeSetor = this.boxSegmento.getSelectionModel().getSelectedItem().toString();
		String nomeCliente = this.txtNome.getText();
		String cnpjCliente = this.txtCnpj.getText();
		
		ClienteDTO objclienteDTO = new ClienteDTO();
		
		objclienteDTO.setCnpj(cnpjCliente);
		objclienteDTO.setNomeCliente(nomeCliente);
		objclienteDTO.setNomeSetor(selectnomeSetor);
		
		cadastrarCliente.cadastarCliente(objclienteDTO);
		
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
		
		txtNome.setText(null);
        txtCnpj.setText(null);
        boxSegmento.getSelectionModel().selectFirst();
	}

}
