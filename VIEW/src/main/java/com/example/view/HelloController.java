package com.example.view;

// Importando
import DTO.ClienteDTO;
import DTO.EntregavelDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
//Botões Tabela

    @FXML
    private TableColumn<?, ?> bntDlt;

    @FXML
    private Button btnAdd;

//Botões Menu Icons

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnComentar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnPesquisar;

// Tabela/Colunas tabela

    @FXML
    private TableColumn<?, ?> inputDado;

    @FXML
    private TableColumn<?, ?> inputProdutos;

    @FXML
    private TableColumn<?, ?> inputServicos;

    @FXML
    private TableView<?> inputTable;

//Caixa texto

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextArea txtMinimo;

    @FXML
    private TextArea txtObjNegocio;

    @FXML
    private TextField txtRazao;

    @FXML
    private TextArea txtePossiveis;

//Checkbox

    @FXML
    void inpuWeb(ActionEvent event) {

    }

    @FXML
    void inputApi(ActionEvent event) {

    }

    @FXML
    void inputCloudWatch(ActionEvent event) {

    }

    @FXML
    void inputContainers(ActionEvent event) {

    }

    @FXML
    void inputFargate(ActionEvent event) {

    }

    @FXML
    void inputFilas(ActionEvent event) {

    }

    @FXML
    void inputFunction(ActionEvent event) {

    }

    @FXML
    void inputGateway(ActionEvent event) {

    }

    @FXML
    void inputLambda(ActionEvent event) {

    }

    @FXML
    void inputMongo(ActionEvent event) {

    }

    @FXML
    void inputParquet(ActionEvent event) {

    }

    @FXML
    void inputProduto(ActionEvent event) {

    }

    @FXML
    void inputQuick(ActionEvent event) {

    }

    @FXML
    void inputS3(ActionEvent event) {

    }

    @FXML
    void inputSegmento(ActionEvent event) {

    }
// Dropbox itens
    @FXML
    private MenuItem txtComercio;

    @FXML
    private MenuItem txtGoverno;

    @FXML
    private MenuItem txtIndustria;

    @FXML
    private MenuItem txtAtacado;

    @FXML
    void inputSolucao(ActionEvent event) {

    }
    @FXML
    private void btnCadastrar(ActionEvent event) {
        String nomeCliente = this.txtRazao.getText();
        String cnpjCliente = this.txtCnpj.getText();
        String objCliente = this.txtObjNegocio.getText();
        String eMinimos = this.txtePossiveis.getText();
        String ePossiveis = this.txtePossiveis.getText();

// Metodos acessores do clienteDTO
        ClienteDTO objclienteDTO = new ClienteDTO();
        objclienteDTO.setCnpj(cnpjCliente);
        objclienteDTO.setNomeCliente(nomeCliente);
        objclienteDTO.setNomeSetor();

// Metodos acessores do entregavelDTO
        EntregavelDTO objentregavelDTO = new EntregavelDTO();
        objentregavelDTO.setEntregaMin(eMinimos);
        objentregavelDTO.setEntregaPossivel(ePossiveis);
        objentregavelDTO.setObjetivoNegocio(objCliente);


    }


}