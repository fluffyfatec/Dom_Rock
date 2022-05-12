package com.example.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.BronzeDAO;
import DAO.CadastroDAO;
import DAO.ClienteDAO;
import DAO.ConsultaId;
import DAO.CoreDAO;
import DAO.DadosDAO;
import DAO.DescritivoDAO;
import DAO.FuncionalidadeDAO;
import DTO.BronzeDTO;
import DTO.CadastroDTO;
import DTO.ClienteDTO;
import DTO.CoreDTO;
import DTO.FuncionalidadeDTO;
import DTO.ProdutoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController implements Initializable {

	// Janela Inicial
	private CadastroDAO cadastrodao = new CadastroDAO();
	private ClienteDAO clientedao = new ClienteDAO();
	private DadosDAO dadosdao = new DadosDAO();
	private CoreDAO coredao = new CoreDAO();
	private FuncionalidadeDAO funcionalidadedao = new FuncionalidadeDAO();
	private BronzeDAO bronze = new BronzeDAO();
	private DescritivoDAO descritivodao = new DescritivoDAO();
	private ConsultaId consultaid = ConsultaId();

	
	// List2 - LISTA BRONZE
	private ObservableList<String> list2 = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> boxSegmento = new ComboBox<String>();

	// Janela de Cadastro
	
///// Cadastro

	@FXML
	private TextField txtCnpj;

	@FXML
	private TextField txtNome;
   
	@FXML
    private TextField txtIdCliente = new TextField();
	
  //// Tab



    @FXML
	private Tab geral;

	@FXML
	private TextArea txtObjNegocio;

	@FXML
	private TextArea txteMinimos;

	@FXML
	private TextArea txtePossiveis;

	// CheckBox CORE

	@FXML
	private CheckBox coreCloud;

	@FXML
	private CheckBox coreContainers;

	@FXML
	private CheckBox coreFargate;

	@FXML
	private CheckBox coreFilas;

	@FXML
	private CheckBox coreGateway;

	@FXML
	private CheckBox coreLambda;

	@FXML
	private CheckBox coreMongo;

	@FXML
	private CheckBox coreParquet;

	@FXML
	private CheckBox coreQuick;

	@FXML
	private CheckBox coreS3;

	@FXML
	private CheckBox coreStep;

	@FXML
	private CheckBox coreWeb;

	// Check Box Funcionalidades

	@FXML
	private CheckBox funcaoPainel;

	@FXML
	private CheckBox funcaoBusca;

	@FXML
	private CheckBox funcaoGeradorRelatorio;

	@FXML
	private CheckBox funcaoGeradorData;

	// Campos de Dados Minimos

	@FXML
	private TextField dmMarketing;

	@FXML
	private TextField dmMatching;

	@FXML
	private TextField dmOptimization;

	@FXML
	private TextField dmPricing;

	@FXML
	private TextField dmSales;

	@FXML
	private TextField dmVox;

	// Check Box Produto/Operations

	@FXML
	private CheckBox produtoOptimization;

	@FXML
	private CheckBox produtoMatching;

	// Check Box Produto/Demand

	@FXML
	private CheckBox produtoMarketing;

	@FXML
	private CheckBox produtoPricing;

	@FXML
	private CheckBox produtoSales;

	@FXML
	private CheckBox produtoVox;

	// Tooltip botões

	@FXML
	private Tooltip toolCadastrar;

	@FXML
	private Tooltip toolConsultar;

	@FXML
	private Tooltip toolLimpar;
	
	// Janela Escopo 
	// Botões 
	
	@FXML
	private Button btnLimparEscopo;
	
	@FXML
	private Button btnCadastrarEscopo;
	
	// Janela Bronze 
	// Botões 

	@FXML
	private Button btnLimparBronze;
	
	@FXML
	private Button btnCadastrarBronze;
	
	
	CadastroDTO objcadastroDTO = new CadastroDTO();

	  @FXML
	    void btnBuscaCliente(ActionEvent event) {	    
		   String cnpj;
	        cnpj = txtCnpj.getText();
	        ConsultaId dao = new ConsultaId();
	        ClienteDTO objclienteDTO = dao.consultarid(cnpj);

	        txtIdCliente.setText(objclienteDTO.getIdCliente());
	        txtNome.setText(objclienteDTO.getNomeCliente());


	    }
	  
	// Botão Cadastrar
	 

	@FXML
	private void btnCadastrar(ActionEvent event) throws InterruptedException, SQLException {


			

			

		}

	private ClienteDTO ClienteDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	private ConsultaId ConsultaId() {
		// TODO Auto-generated method stub
		return null;
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
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.show();
	}

	@FXML
	void btnTabela(ActionEvent event) {

	}

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		boxProduto.setItems(list2);
		boxProduto.getSelectionModel().selectFirst();

		// Populando o boxOrigem

		ObservableList<String> listOrigem = FXCollections.observableArrayList("API", "SFTP", "Upload");

		boxOrigem.setItems(listOrigem);

		boxOrigem.getSelectionModel().selectFirst();

		// Populando o boxFormato

		ObservableList<String> listFormato = FXCollections.observableArrayList("JSON", "CSV", "Planilhas", "Tabela",
				"PDF", "Audio", "Texto");

		boxFormato.setItems(listFormato);

		boxFormato.getSelectionModel().selectFirst();

		// Populando o boxFrequencia

		ObservableList<String> listFrequencia = FXCollections.observableArrayList("Diariamente", "7 dias", "15 dias",
				"30 dias", "45 dias", "60 dias");

		boxFrequencia.setItems(listFrequencia);

		boxFrequencia.getSelectionModel().selectFirst();

		// Populando o boxSistema

		ObservableList<String> listSistema = FXCollections.observableArrayList("ERP", "Vendas", "Outros");

		boxSistema.setItems(listSistema);

		boxSistema.getSelectionModel().selectFirst();

		//
		List<BronzeDTO> ativacaoDTOs = new ArrayList<BronzeDTO>();
		produtoAtivacaoObservableList = FXCollections.observableList(ativacaoDTOs);

		colProduto.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("nomeProduto"));
		colFormato.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("formato"));
		colSistema.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("frequencia"));
		colFrequencia.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("origenDado"));
		colOrigem.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("sistema"));
		colVolume.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("volume"));
		tabelaBronze.setItems(produtoAtivacaoObservableList);
	}

	// Função de habilitar de dasabilitar DADOS Minimos (TextFields)

	@FXML
	void produtoOptimization(ActionEvent event) {

		if (produtoOptimization.isSelected()) {
			dmOptimization.setDisable(false);
			list2.add("Optimization");
		} else {
			dmOptimization.setDisable(true);
			list2.removeAll("Optimization");
		}
	}

	@FXML
	void produtoMatching(ActionEvent event) {
		if (produtoMatching.isSelected()) {
			dmMatching.setDisable(false);
			list2.add("Matching & Risk");
		} else {
			dmMatching.setDisable(true);
			list2.removeAll("Matching & Risk");
		}
	}

	@FXML
	void produtoVox(ActionEvent event) {
		if (produtoVox.isSelected()) {
			dmVox.setDisable(false);
			list2.add("Vox");
		} else {
			dmVox.setDisable(true);
			list2.removeAll("Vox");
		}
	}

	@FXML
	void produtoMarketing(ActionEvent event) {
		if (produtoMarketing.isSelected()) {
			dmMarketing.setDisable(false);
			list2.add("Marketing & Planning");
		} else {
			dmMarketing.setDisable(true);
			list2.removeAll("Marketing & Planning");
		}
	}

	@FXML
	void produtoSales(ActionEvent event) {
		if (produtoSales.isSelected()) {
			dmSales.setDisable(false);
			list2.add("Sales & Distributions");
		} else {
			dmSales.setDisable(true);
			list2.removeAll("Sales & Distributions");
		}
	}

	@FXML
	void produtoPricing(ActionEvent event) {
		if (produtoPricing.isSelected()) {
			dmPricing.setDisable(false);
			list2.add("Pricing");
		} else {
			dmPricing.setDisable(true);
			list2.removeAll("Pricing");
		}
	}
	// Bronze

	@FXML
	private ComboBox<String> boxProduto = new ComboBox<String>();

	@FXML
	void boxProduto(ActionEvent event) {
		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxProduto.getSelectionModel().getSelectedItem() != null) {
			String nomeProduto = boxProduto.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setNomeProduto(nomeProduto);
		}

	}

	@FXML
	private ComboBox<String> boxOrigem = new ComboBox<String>();

	@FXML
	void boxOrigem(ActionEvent event) {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxOrigem.getSelectionModel().getSelectedItem() != null) {
			String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setOrigenDado(nomeOrigem);

		}
	}

	@FXML
	private ComboBox<String> boxFormato = new ComboBox<String>();

	@FXML
	void boxFormato(ActionEvent event) {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxFormato.getSelectionModel().getSelectedItem() != null) {
			String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setFormato(nomeFormato);
		}
	}

	@FXML
	private ComboBox<String> boxFrequencia = new ComboBox<String>();

	@FXML
	void boxFrequencia(ActionEvent event) {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxFrequencia.getSelectionModel().getSelectedItem() != null) {
			String nomeFrequencia = boxFrequencia.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setFrequencia(nomeFrequencia);
		}
	}

	@FXML
	private ComboBox<String> boxSistema = new ComboBox<String>();

	@FXML
	void boxSistema(ActionEvent event) {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxSistema.getSelectionModel().getSelectedItem() != null) {
			String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setSistema(nomeSistema);
		}
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		tabelaBronze.getItems().removeAll(tabelaBronze.getSelectionModel().getSelectedItems());

	}

	@FXML
	void btnSilver(ActionEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("Silver.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 485, 348);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css%22");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Silver - Dom Rock");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png%22"));
		stage.show();

	}

	@FXML
	private TableView<BronzeDTO> tabelaBronze = new TableView<BronzeDTO>();

	@FXML
	private TableColumn<BronzeDTO, String> colOrigem = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colFormato = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colVolume = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colFrequencia = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colSistema = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colProduto = new TableColumn<BronzeDTO, String>();

	@FXML
	private TextField txtVolume;

	private ObservableList<BronzeDTO> produtoAtivacaoObservableList;

	@FXML
	void btnAdc(ActionEvent event) throws SQLException {
		String volume = this.txtVolume.getText();
		String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
		String nomeFrequencia = boxFrequencia.getSelectionModel().getSelectedItem().toString();
		String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
		String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();
		String nomeProduto = boxProduto.getSelectionModel().getSelectedItem().toString();

		BronzeDTO objtesteDTO = new BronzeDTO(nomeFormato, nomeFrequencia, nomeOrigem, nomeSistema, volume, nomeProduto,
				null);

		produtoAtivacaoObservableList.add(objtesteDTO);

		List<BronzeDTO> prods = new LinkedList<BronzeDTO>();
		prods.add(objtesteDTO);

		while (prods.add(objtesteDTO)) {
			bronze.cadastarBronze(prods);
			break;
		}
	}
	
	// Janela Escopo 
	// Métodos Botões LIMPAR/CADASTRAR 
	
	@FXML
	void btnLimparEscopo(ActionEvent event) {
		// Botão de alerta
		final Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirmação");
		window.setMinWidth(500);
		window.setHeight(200);
		window.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));

		Label label = new Label();
		label.setText("Todos os campos serão limpos. Confirmar?");
		label.setAlignment(Pos.CENTER);
		label.setStyle("-fx-font-size: 18px ; -fx-background-color: transparent ; -fx-text-fill: white; ");

		Button closeButtom = new Button("Confirmar");
		closeButtom.setOnAction(e -> {
			window.close();

			//txtNome.setText(null);
			//txtCnpj.setText(null);
			//txtObjNegocio.setText(null);
			//txteMinimos.setText(null);
			//txtePossiveis.setText(null);
			
	
			// Limpar Funcionalidades
			funcaoPainel.setSelected(false);
			funcaoBusca.setSelected(false);
			funcaoGeradorRelatorio.setSelected(false);
			funcaoGeradorData.setSelected(false);
	
			// Limpar Core
			coreWeb.setSelected(false);
			coreFilas.setSelected(false);
			coreFargate.setSelected(false);
			coreMongo.setSelected(false);
			coreParquet.setSelected(false);
			coreStep.setSelected(false);
			coreContainers.setSelected(false);
			coreQuick.setSelected(false);
			coreS3.setSelected(false);
			coreLambda.setSelected(false);
			coreCloud.setSelected(false);
			coreGateway.setSelected(false);
	
			// Limpar Produto
			produtoMatching.setSelected(false);
			produtoOptimization.setSelected(false);
			produtoPricing.setSelected(false);
			produtoSales.setSelected(false);
			produtoMarketing.setSelected(false);
			produtoVox.setSelected(false);
	
			// Limpar Dados Minimos
			dmPricing.setText(null);
			dmSales.setText(null);
			dmOptimization.setText(null);
			dmMatching.setText(null);
			dmMarketing.setText(null);
			dmVox.setText(null);
	
			// Desativar DADOS MINIMOS
			dmOptimization.setDisable(true);
			dmMatching.setDisable(true);
			dmVox.setDisable(true);
			dmMarketing.setDisable(true);
			dmSales.setDisable(true);
			dmPricing.setDisable(true);
	
			// Limpar ComboBox Produto
			list2.removeAll("Optimization");
			list2.removeAll("Matching & Risk");
			list2.removeAll("Vox");
			list2.removeAll("Marketing & Planning");
			list2.removeAll("Sales & Distributions");
			list2.removeAll("Pricing");

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
	void btnCadastrarEscopo(ActionEvent event) throws InterruptedException, SQLException {
		// Metodos acessores do clienteDTO
		
		String objCliente = this.txtObjNegocio.getText();
		String eMinimos = this.txteMinimos.getText();
		String ePossiveis = this.txtePossiveis.getText();
		String idCliente = this.txtIdCliente.getText();
		
		CadastroDTO objcadastroDTO = new CadastroDTO();
		ClienteDTO objclienteDTO = new ClienteDTO();
		
		objclienteDTO.setEntregaMin(eMinimos);
		objclienteDTO.setEntregaPossivel(ePossiveis);
		objclienteDTO.setObjetivoNegocio(objCliente);
		objclienteDTO.setIdCliente(idCliente);
		//System.out.println(eMinimos + ePossiveis + objCliente);
		
		cadastrodao.cadastroCliente(objcadastroDTO);
		//clientedao.cadastarCliente(objclienteDTO);
		descritivodao.cadastrarDescritivo(objclienteDTO);
	    

		// Metodos acesssores do ProdutoDTO

		String marketing = this.dmMarketing.getText();
		String matching = this.dmMatching.getText();
		String optimzation = this.dmOptimization.getText();
		String sales = this.dmSales.getText();
		String vox = this.dmVox.getText();
		String pricing = this.dmPricing.getText();

		if (produtoVox.isSelected()) {
			int id_produto = 1;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(vox);

			dadosdao.cadastrarDados(objprodutoDTO);
		}
		if (produtoMarketing.isSelected()) {
			int id_produto = 2;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(marketing);

			dadosdao.cadastrarDados(objprodutoDTO);
		}
		if (produtoSales.isSelected()) {
			int id_produto = 3;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(sales);

			dadosdao.cadastrarDados(objprodutoDTO);
		}
		if (produtoPricing.isSelected()) {
			int id_produto = 4;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(pricing);

			dadosdao.cadastrarDados(objprodutoDTO);
		}
		if (produtoOptimization.isSelected()) {
			int id_produto = 5;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(optimzation);

			dadosdao.cadastrarDados(objprodutoDTO);
		}
		if (produtoMatching.isSelected()) {
			int id_produto = 6;
			ProdutoDTO objprodutoDTO = new ProdutoDTO();
			objprodutoDTO.setIdProduto(id_produto);
			objprodutoDTO.setIdProduto1(matching);

			dadosdao.cadastrarDados(objprodutoDTO);
		}

		// Metodos acessores do CoreDAO

		if (coreWeb.isSelected()) {
			int id_core = 1;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setWeb(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreGateway.isSelected()) {
			int id_core = 2;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setGateway(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreFilas.isSelected()) {
			int id_core = 3;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setFilas(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreStep.isSelected()) {
			int id_core = 4;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setStepfunction(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreLambda.isSelected()) {
			int id_core = 5;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setLambda(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreFargate.isSelected()) {
			int id_core = 6;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setFargate(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreContainers.isSelected()) {
			int id_core = 7;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setContainers(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreS3.isSelected()) {
			int id_core = 8;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setS3(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreMongo.isSelected()) {
			int id_core = 9;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setMongodb(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreParquet.isSelected()) {
			int id_core = 10;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setParquet(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreQuick.isSelected()) {
			int id_core = 11;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setQuicksight(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		if (coreCloud.isSelected()) {
			int id_core = 12;
			CoreDTO objcoreDTO = new CoreDTO();
			objcoreDTO.setCloudwatch(id_core);

			coredao.cadastrarCore(objcoreDTO);
		}

		// Metodos acessores do FuncionalidadeDAO

		if (funcaoGeradorRelatorio.isSelected()) {
			int id_funcionalidade = 1;
			FuncionalidadeDTO objfuncionalidadeDTO = new FuncionalidadeDTO();
			objfuncionalidadeDTO.setGeradorRelat(id_funcionalidade);

			funcionalidadedao.cadastrarFuncionalidade(objfuncionalidadeDTO);
		}
		if (funcaoPainel.isSelected()) {
			int id_funcionalidade = 2;
			FuncionalidadeDTO objfuncionalidadeDTO = new FuncionalidadeDTO();
			objfuncionalidadeDTO.setPaineis(id_funcionalidade);

			funcionalidadedao.cadastrarFuncionalidade(objfuncionalidadeDTO);
		}
		if (funcaoBusca.isSelected()) {
			int id_funcionalidade = 3;
			FuncionalidadeDTO objfuncionalidadeDTO = new FuncionalidadeDTO();
			objfuncionalidadeDTO.setBuscaNlp(id_funcionalidade);

			funcionalidadedao.cadastrarFuncionalidade(objfuncionalidadeDTO);
		}
		if (funcaoGeradorData.isSelected()) {
			int id_funcionalidade = 4;
			FuncionalidadeDTO objfuncionalidadeDTO = new FuncionalidadeDTO();
			objfuncionalidadeDTO.setGeradorData(id_funcionalidade);

			funcionalidadedao.cadastrarFuncionalidade(objfuncionalidadeDTO);
		}

		Alerts.display("SUCESSO", "Cliente cadastrado com sucesso");
        
		txtIdCliente.setText((null));
		txtNome.setText(null);
		txtCnpj.setText(null);
		txtObjNegocio.setText(null);
		txteMinimos.setText(null);
		txtePossiveis.setText(null);

		// Limpar ComboBox
		boxSegmento.getSelectionModel().selectFirst();

		// Limpar Funcionalidades
		funcaoPainel.setSelected(false);
		funcaoBusca.setSelected(false);
		funcaoGeradorRelatorio.setSelected(false);
		funcaoGeradorData.setSelected(false);

		// Limpar Core
		coreWeb.setSelected(false);
		coreFilas.setSelected(false);
		coreFargate.setSelected(false);
		coreMongo.setSelected(false);
		coreParquet.setSelected(false);
		coreStep.setSelected(false);
		coreContainers.setSelected(false);
		coreQuick.setSelected(false);
		coreS3.setSelected(false);
		coreLambda.setSelected(false);
		coreCloud.setSelected(false);
		coreGateway.setSelected(false);

		// Limpar Produto
		produtoMatching.setSelected(false);
		produtoOptimization.setSelected(false);
		produtoPricing.setSelected(false);
		produtoSales.setSelected(false);
		produtoMarketing.setSelected(false);
		produtoVox.setSelected(false);

		// Limpar Dados Minimos
		dmPricing.setText(null);
		dmSales.setText(null);
		dmOptimization.setText(null);
		dmMatching.setText(null);
		dmMarketing.setText(null);
		dmVox.setText(null);

		// Desativar DADOS Minimos
		dmOptimization.setDisable(true);
		dmMatching.setDisable(true);
		dmVox.setDisable(true);
		dmMarketing.setDisable(true);
		dmSales.setDisable(true);
		dmPricing.setDisable(true);

		// Limpar ComboBox Produto
		list2.removeAll("Optimization");
		list2.removeAll("Matching & Risk");
		list2.removeAll("Vox");
		list2.removeAll("Marketing & Planning");
		list2.removeAll("Sales & Distributions");
		list2.removeAll("Pricing");
	}
	
	// Janela Bronze 
	// Métodos Botões LIMPAR/CADASTRAR 
	
	@FXML
	void btnLimparBronze(ActionEvent event) {
		
	}

	@FXML
	void btnCadastrarBronze(ActionEvent event) throws InterruptedException, SQLException {
		// Teste

		String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
		String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
		String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();

		// Estrutura de controle para definir o ID da origem
		if (nomeOrigem == "API") {
			int idOrigem = 1;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdOrigem(idOrigem);
		} else if (nomeOrigem == "SFTP") {
			int idOrigem = 2;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdOrigem(idOrigem);
		} else if (nomeOrigem == "Upload") {
			int idOrigem = 3;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdOrigem(idOrigem);
		}

		// Estrutura de controle para definir o ID do formato
		if (nomeFormato == "JSON") {
			int idformato = 1;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "CSV") {
			int idformato = 2;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "Planilhas") {
			int idformato = 3;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "Tabela") {
			int idformato = 4;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "PDF") {
			int idformato = 5;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "Audio") {
			int idformato = 6;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		} else if (nomeFormato == "Texto") {
			int idformato = 7;
			BronzeDTO BronzeDTO = new BronzeDTO();
			BronzeDTO.setIdFormato(idformato);
		}

		// Estrutura de controle para definir o ID do sistema

		if (nomeSistema == "ERP") {
			int idSistema = 1;
			BronzeDTO BronzeDTO1 = new BronzeDTO();
			BronzeDTO1.setIdSistema(idSistema);
		} else if (nomeSistema == "Vendas") {
			int idSistema = 2;
			BronzeDTO BronzeDTO1 = new BronzeDTO();
			BronzeDTO1.setIdSistema(idSistema);
		} else if (nomeSistema == "Outros") {
			int idSistema = 3;
			BronzeDTO BronzeDTO1 = new BronzeDTO();
			BronzeDTO1.setIdSistema(idSistema);
		}
	}
	
	
}