package com.example.view;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import DAO.*;
import DTO.*;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class HelloController implements Initializable {

	// Janela Inicial
	private ClienteDAO clientedao = new ClienteDAO();
	private DadosDAO dadosdao = new DadosDAO();
	private CoreDAO coredao = new CoreDAO();
	private FuncionalidadeDAO funcionalidadedao = new FuncionalidadeDAO();

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

	// Janela de Cadastro

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
	private TextField txtCnpj;

	@FXML
	private TextField txtNome;

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


	// Campos de Dados Mínimos

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


	// Botão Cadastrar

	@FXML
	private void btnCadastrar(ActionEvent event) throws InterruptedException, SQLException {

		if (txtNome.getText().length() == 0) {
			Alerts.display("ERRO", "Por favor, insira uma Razão Social");
		}

		if (txtCnpj.getText().length() != 14 && txtNome.getText().length() != 0) {
			Alerts.display("ERRO", "Por favor, insira um CNPJ válido");
		}

		if (txtNome.getText().length() != 0 && txtCnpj.getText().length() == 14) {

			// Metodos acessores do clienteDTO
			String nomeCliente = this.txtNome.getText();
			String cnpjCliente = this.txtCnpj.getText();
			String objCliente = this.txtObjNegocio.getText();
			String eMinimos = this.txteMinimos.getText();
			String ePossiveis = this.txtePossiveis.getText();
			String selectnomeSetor = this.boxSegmento.getSelectionModel().getSelectedItem().toString();

			ClienteDTO objclienteDTO = new ClienteDTO();

			objclienteDTO.setCnpj(cnpjCliente);
			objclienteDTO.setNomeCliente(nomeCliente);
			objclienteDTO.setEntregaMin(eMinimos);
			objclienteDTO.setEntregaPossivel(ePossiveis);
			objclienteDTO.setObjetivoNegocio(objCliente);
			objclienteDTO.setNomeSetor(selectnomeSetor);

			clientedao.cadastarCliente(objclienteDTO);

			// Metodos acesssores do ProdutoDTO

			String marketing = this.dmMarketing.getText();
			String matching = this.dmMatching.getText();
			String optimzation = this.dmOptimization.getText();
			String sales = this.dmSales.getText();
			String vox = this.dmVox.getText();
			String pricing = this.dmPricing.getText();

			ProdutoDTO objprodutoDTO = new ProdutoDTO();

			objprodutoDTO.setMarketingPlanning(marketing);
			objprodutoDTO.setMatchingRisk(matching);
			objprodutoDTO.setOptimization(optimzation);
			objprodutoDTO.setSalesDistribution(sales);
			objprodutoDTO.setVox(vox);
			objprodutoDTO.setPricing(pricing);

			if (produtoVox.isSelected()) {
				int id_produto = 1;
				objprodutoDTO.setCheckvox(id_produto);

				dadosdao.cadastrarDados(objprodutoDTO);
			}
			if (produtoMarketing.isSelected()) {
				int id_produto = 2;
				objprodutoDTO.setCheckmarketing(id_produto);

				dadosdao.cadastrarDados(objprodutoDTO);
			}
			if (produtoSales.isSelected()) {
				int id_produto = 3;
				objprodutoDTO.setChecksales(id_produto);

				dadosdao.cadastrarDados(objprodutoDTO);
			}
			if (produtoPricing.isSelected()) {
				int id_produto = 4;
				objprodutoDTO.setCheckpricing(id_produto);

				dadosdao.cadastrarDados(objprodutoDTO);
			}
			if (produtoOptimization.isSelected()) {
				int id_produto = 5;
				objprodutoDTO.setCheckoptimization(id_produto);

				dadosdao.cadastrarDados(objprodutoDTO);
			}
			if (produtoMatching.isSelected()) {
				int id_produto = 6;
				objprodutoDTO.setCheckmarketing(id_produto);

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

		// Limpar ComboBox
		boxSegmento.getSelectionModel().clearSelection();

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

		// Limpar Dados Mínimos
		dmPricing.setText(null);
		dmSales.setText(null);
		dmOptimization.setText(null);
		dmMatching.setText(null);
		dmMarketing.setText(null);
		dmVox.setText(null);
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

	// Janela de Pesquisa

	@FXML
	private TableColumn<ClienteDTO, String> colunaCnpj;

	@FXML
	private TableColumn<ClienteDTO, String> colunaNome;

	@FXML
	private TableView<ClienteDTO> tabelaPesquisa;

	public ObservableList<ClienteDTO> data;

	@FXML
	private TextField razaosocialconsulta;

	@FXML
	private TextField cnpjconsulta;

	@FXML
	private void btnBuscaconsulta(ActionEvent event) throws ClassNotFoundException, SQLException {

		ObservableList<String> nomes = FXCollections.observableArrayList();
		ObservableList<String> cnpjs = FXCollections.observableArrayList();

		if (Objects.equals(this.cnpjconsulta.getText(), "")) {
			String sql = "select * from Cliente where razao_social like '%" + this.razaosocialconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				System.out.println("NENHUM RESULTADO ENCONTRADO");
			} else {
				while (resultado.next()) {
					System.out.println(resultado.getString("razao_social"));
					nomes.add(resultado.getString("razao_social"));
					System.out.println("Lista: " + nomes);
				}
			}

		}
		if (Objects.equals(this.razaosocialconsulta.getText(), "")) {
			String sql = "select * from Cliente where cnpj like '%" + this.cnpjconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				System.out.println("NENHUM RESULTADO ENCONTRADO");
			} else {
				while (resultado.next()) {
					System.out.println(resultado.getString("razao_social"));
				}
			}

		}
		if ((!Objects.equals(this.razaosocialconsulta.getText(), ""))
				&& (!Objects.equals(this.cnpjconsulta.getText(), ""))) {
			String sql = "select * from Cliente where razao_social like '%" + this.razaosocialconsulta.getText()
					+ "%' and cnpj like '%" + this.cnpjconsulta.getText() + "%'";

			Connection conn = new ConexaoDAO().conectaBD();
			Statement stm = conn.createStatement();

			ResultSet resultado = stm.executeQuery(sql);

			if (!resultado.isBeforeFirst()) {
				System.out.println("NENHUM RESULTADO ENCONTRADO");
			} else {
				while (resultado.next()) {
					System.out.println(resultado.getString("razao_social"));
				}
			}

		}

	}

	@FXML
	void btnLimparconsulta(ActionEvent event) {

		razaosocialconsulta.setText(null);
		cnpjconsulta.setText(null);

	}

	@FXML
	void btnSegmento(ActionEvent event) {
		ClienteDTO objclieClienteDTO = new ClienteDTO();
		if (boxSegmento.getSelectionModel().getSelectedItem() != null) {
			String nomeSetor = boxSegmento.getSelectionModel().getSelectedItem().toString();
			objclieClienteDTO.setNomeSetor(nomeSetor);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo",
                "Governo");
        boxSegmento.setItems(list);

	}

}