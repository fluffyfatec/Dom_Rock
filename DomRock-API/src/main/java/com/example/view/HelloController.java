package com.example.view;


import java.time.format.DateTimeFormatter;
import java.util.Date;

import DTO.ClienteDTO;
import DTO.EntregavelDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML
    private Tab geral;
    
    @FXML
    private MenuItem oi;

    @FXML
    private MenuItem sim;

    @FXML
    private SplitMenuButton splitSegmento;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtObjNegocio;

    @FXML
    private TextArea txteMinimos;

    @FXML
    private TextArea txtePossiveis;

    @FXML
    private void btnCadastrar(ActionEvent event) {
    	
        String nomeCliente = this.txtNome.getText();
        String cnpjCliente = this.txtCnpj.getText();
        String objCliente = this.txtObjNegocio.getText();
        String eMinimos = this.txtePossiveis.getText();
        String ePossiveis = this.txtePossiveis.getText();

        if (txtNome.getText().length()==0) {
            txtNome.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
            Alerts.display("ERRO", "Por favor, insira uma Razão Social válida");
        }
        else {
            txtNome.setStyle(null);
        }

        if (txtCnpj.getText().length()==0) {
            txtCnpj.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
            Alerts.display("ERRO", "Por favor, insira um CNPJ válido");
        }
        else {
            txtNome.setStyle(null);
        }

        

// Metodos acessores do clienteDTO
        ClienteDTO objclienteDTO = new ClienteDTO();
        objclienteDTO.setCnpj(cnpjCliente);
        objclienteDTO.setNomeCliente(nomeCliente);
        objclienteDTO.setEntregaMin(eMinimos);
        objclienteDTO.setEntregaPossivel(ePossiveis);
        objclienteDTO.setObjetivoNegocio(objCliente);



// Metodos acessores do entregavelDTO
        EntregavelDTO objentregavelDTO = new EntregavelDTO();
        objentregavelDTO.setEntregaMin(eMinimos);
        objentregavelDTO.setEntregaPossivel(ePossiveis);
        objentregavelDTO.setObjetivoNegocio(objCliente);


    }

    @FXML
    void btnSegmento(ActionEvent event) {

	splitSegmento = new SplitMenuButton();
	
	 oi = new MenuItem();
	 sim = new MenuItem();
	
	splitSegmento.getItems().addAll(oi, sim);    
	
	oi.setOnAction((e)->{
		System.out.println("deu certo");
	});

    }
    


}
