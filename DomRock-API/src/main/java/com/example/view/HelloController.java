package com.example.view;


import java.io.IOException;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {


    //Janela Inicial
	private ClienteDAO clientedao = new ClienteDAO();
	

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
            scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Dom_Rock/main/DomRock-API/src/main/java/com/example/view/style.css");
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
    private MenuItem governo;

    @FXML
    private MenuItem industria;
    
    @FXML
    private MenuItem atacado;

    @FXML
    private MenuItem comercio;
    
    @FXML
    private TextField txtDadosmin;

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
            String dadosMin = this.txtDadosmin.getText();

            System.out.println("Razao social: "+nomeCliente+ "\nCNPJ: "+cnpjCliente+"\nObjetivo do Negocio: "+objCliente+"\nEntregaveis Minimos: "+eMinimos+"\nEntregaveis Possiveis: "+ePossiveis+"\n\n");


            // Metodos acessores do clienteDTO
            ClienteDTO objclienteDTO = new ClienteDTO();
            objclienteDTO.setCnpj(cnpjCliente);
            objclienteDTO.setNomeCliente(nomeCliente);
            objclienteDTO.setEntregaMin(eMinimos);
            objclienteDTO.setEntregaPossivel(ePossiveis);
            objclienteDTO.setObjetivoNegocio(objCliente);
            objclienteDTO.setDadosMin(dadosMin);
            
            
            
            clientedao.cadastarCliente(objclienteDTO);

            Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");

            
            
        }

    }
    
    // Definindo o split segmento 
    
    @FXML
    void itemComercio(ActionEvent event) {
    	ClienteDTO objclienteDTO = new ClienteDTO();
    	String nomeSetor = "comercio";
    	objclienteDTO.setNomeSetor(nomeSetor);
    	System.out.println(nomeSetor);
    }

    @FXML
    void itemGoverno(ActionEvent event) {
    	ClienteDTO objclienteDTO = new ClienteDTO();
    	String nomeSetor = "governo";
    	objclienteDTO.setNomeSetor(nomeSetor);
    	System.out.println(nomeSetor);
    }

    @FXML
    void itemIndustria(ActionEvent event) {
    	ClienteDTO objclienteDTO = new ClienteDTO();
    	String nomeSetor = "industria";
    	objclienteDTO.setNomeSetor(nomeSetor);
    	System.out.println(nomeSetor);

    }
    
    @FXML
    void itemAtatacado(ActionEvent event) {
    	ClienteDTO objclienteDTO = new ClienteDTO();
    	String nomeSetor = "atacado";
    	objclienteDTO.setNomeSetor(nomeSetor);
    	System.out.println(nomeSetor);


    }

    // Botão limpar
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
            scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Dom_Rock/main/DomRock-API/src/main/java/com/example/view/style.css");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle("Pesquisar Cliente - Dom Rock");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void btnTabela(ActionEvent event) {

    }

    @FXML
    void inputProduto(ActionEvent event) {

    }

    @FXML
    void inputSolucao(ActionEvent event) {

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
