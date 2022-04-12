package com.example.view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class HelloController implements Initializable{

    //Janela Inicial
	private ClienteDAO clientedao = new ClienteDAO();

	@FXML
    private ComboBox<String> boxSegmento = new ComboBox<String>();

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
            scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
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
            String selectnomeSetor = this.boxSegmento.getSelectionModel().getSelectedItem().toString();
            
            System.out.println("Razao social: "+nomeCliente+ "\nCNPJ: "+cnpjCliente+"\nObjetivo do Negocio: "+objCliente+"\nEntregaveis Minimos: "+eMinimos+"\nEntregaveis Possiveis: "+ePossiveis+"\n\n");


            // Metodos acessores do clienteDTO
            ClienteDTO objclienteDTO = new ClienteDTO();
            objclienteDTO.setCnpj(cnpjCliente);
            objclienteDTO.setNomeCliente(nomeCliente);
            objclienteDTO.setEntregaMin(eMinimos);
            objclienteDTO.setEntregaPossivel(ePossiveis);
            objclienteDTO.setObjetivoNegocio(objCliente);
            objclienteDTO.setDadosMin(dadosMin);
            objclienteDTO.setNomeSetor(selectnomeSetor);
            
            
           
            clientedao.cadastarCliente(objclienteDTO);

            Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");    
            
        }

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
            scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
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

    @FXML
    void btnSegmento(ActionEvent event) {
    	ClienteDTO objclieClienteDTO = new ClienteDTO();
    	String nomeSetor = boxSegmento.getSelectionModel().getSelectedItem().toString();
    	objclieClienteDTO.setNomeSetor(nomeSetor);
    }
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	   	ObservableList<String> list = FXCollections.observableArrayList("Varejo/Atacado","Governo","esqueci o resto");
	   	boxSegmento.setItems(list);
		
	}
 
}