package com.example.view;


import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.ClienteDTO;
import DTO.EntregavelDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Menu;

import javax.swing.*;


public class HelloController {


    //Janela Inicial

    @FXML
    private Menu bntClienteintro;

    @FXML
    private Menu inputAjudaintro;

    @FXML
    void inputBuscarintro(ActionEvent event) {

    }

    @FXML
    void inputCadastrarintro(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Hello.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1178, 681);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Cliente - Dom Rock");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void inputDesconectarintro(ActionEvent event) {

    }



    //Janela de Cadastro

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

        if (txtNome.getText().length()==0) {
            Alerts.display("ERRO", "Por favor, insira uma Razão Social");
        }

        if (txtCnpj.getText().length()!=14 && txtNome.getText().length()!=0) {
            Alerts.display("ERRO", "Por favor, insira um CNPJ válido");
        }

        if (txtNome.getText().length()!=0 && txtCnpj.getText().length()==14) {

            String nomeCliente = this.txtNome.getText();
            String cnpjCliente = this.txtCnpj.getText();
            String objCliente = this.txtObjNegocio.getText();
            String eMinimos = this.txteMinimos.getText();
            String ePossiveis = this.txtePossiveis.getText();

            System.out.println("Razao social: "+nomeCliente+ "\nCNPJ: "+cnpjCliente+"\nObjetivo do Negocio: "+objCliente+"\nEntregaveis Minimos: "+eMinimos+"\nEntregaveis Possiveis: "+ePossiveis+"\n\n");


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

            Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");
        }

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

    @FXML
    void btnLimpar(ActionEvent event) {

        txtNome.setText(null);
        txtCnpj.setText(null);
        txtObjNegocio.setText(null);
        txteMinimos.setText(null);
        txtePossiveis.setText(null);

    }

    @FXML
    void btnBuscar(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("TelaBusca.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 358, 432);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Pesquisar Cliente - Dom Rock");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        scene.getStylesheets().add("https://github.com/fluffyfatec/Dom_Rock/blob/cce996222f745eeacf3e72becb231ffe8c58dae5/DomRock-API/src/main/java/com/example/view/tablecell.css");
    }



    //Janela de Pesquisa

    @FXML
    private TableColumn<?, ?> colunaCnpj;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableView<?> tabelaPesquisa;

    @FXML
    void btnBuscaconsulta(ActionEvent event) {

    }

    @FXML
    void btnLimparconsulta(ActionEvent event) {

    }

    @FXML
    void txtCnpjconsulta(ActionEvent event) {

    }

    @FXML
    void txtRazaosocialconsulta(ActionEvent event) {

    }

}
