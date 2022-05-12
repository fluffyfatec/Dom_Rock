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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class CadastrarClienteController implements Initializable {
	
	@FXML
	private TextField txtCnpj;
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
		txtNome.setText(null);
		txtCnpj.setText(null);
        boxSegmento.getSelectionModel().selectFirst();
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
