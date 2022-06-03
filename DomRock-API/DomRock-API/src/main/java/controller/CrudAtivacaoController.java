package controller;

import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modal.BronzeDAO;
import modal.BronzeDTO;
import modal.ClienteDTO;
import modal.EscopoDAO;
import modal.EscopoDTO;
import modal.EscopoTabelaCore;
import modal.EscopoTabelaFuncionalidades;
import modal.GoldDAO;
import modal.GoldDTO;
import modal.ProdutoDAO;
import modal.ProdutoDTO;
import modal.SilverDAO;
import modal.SilverDTO;

public class CrudAtivacaoController implements Initializable {

	@FXML
	private ComboBox<String> boxFormato = new ComboBox<String>();

	@FXML
	private ComboBox<String> boxFrequencia = new ComboBox<String>();

	@FXML
	private ComboBox<String> boxOrigem = new ComboBox<String>();

	@FXML
	private ComboBox<String> boxProduto = new ComboBox<String>();

	@FXML
	private ComboBox<String> boxSistema = new ComboBox<String>();
	// Escopo 2
	@FXML
	private ComboBox<String> boxCore = new ComboBox<String>();
	@FXML
	private ComboBox<String> boxProdutoIdEscopo = new ComboBox<String>();

	@FXML
	private ComboBox<String> boxProdutoIdEscopoDois = new ComboBox<String>();
	@FXML
	private ComboBox<String> boxFuncionalidadeEscopo = new ComboBox<String>();
	@FXML
	private CheckBox ckbObrigatorio = new CheckBox();
	@FXML
	private CheckBox produtoMarketing = new CheckBox();

	@FXML
	private CheckBox produtoMatching = new CheckBox();

	@FXML
	private CheckBox produtoOptimization = new CheckBox();

	@FXML
	private CheckBox produtoPricing = new CheckBox();

	@FXML
	private CheckBox produtoSales = new CheckBox();

	@FXML
	private CheckBox produtoVox = new CheckBox();

	@FXML
	private TableView<EscopoTabelaCore> TabelaCore;
	@FXML
	private TableColumn<EscopoTabelaCore, Integer> IdClienteProdutoCore;
	@FXML
	private TableColumn<EscopoTabelaCore, String> colIdClienteCore;
	@FXML
	private TableColumn<EscopoTabelaCore, String> colCore;
	@FXML
	private TableColumn<EscopoTabelaCore, String> colNomeProduto;

	// teste
	@FXML
	private TableView<EscopoTabelaFuncionalidades> TabelaFuncionalidade;
	@FXML
	private TableColumn<EscopoTabelaFuncionalidades, String> idFuncionalidade;
	@FXML
	private TableColumn<EscopoTabelaFuncionalidades, String> colFuncionalidade;

	@FXML
	private TableColumn<EscopoTabelaFuncionalidades, String> colIdProdutoFuncionalidade;

	@FXML
	private TableColumn<EscopoTabelaFuncionalidades, String> colIdCliente;
	@FXML
	private Tab escopo;

	///
	@FXML
	private Button btnCadastrarBronze1;

	@FXML
	private Button btnCadastrarEscopo;

	@FXML
	private Button btnCadastrarSilver;

	@FXML
	private Button btnLimparBronze1;

	@FXML
	private Button btnLimparEscopo;

	@FXML
	private Button btnLimparSilver;
	
	@FXML
	private Button btnAtualizar;

	@FXML
	private TableColumn<BronzeDTO, String> colFormato = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colFrequencia = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colOrigem = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colProduto = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colSistema = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<BronzeDTO, String> colVolume = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colIdFonte = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colFormatoSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colFrequenciaSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colOrigemSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colObrigatorio = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colValidador = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colIdSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colfontedadoBronze = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colProdutoSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colSistemaSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private TableColumn<SilverDTO, String> colVolumeSilver = new TableColumn<SilverDTO, String>();

	@FXML
	private Tab geral;

	@FXML
	private TableView<BronzeDTO> tabelaBronze = new TableView<BronzeDTO>();

	@FXML
	private TableView<SilverDTO> tabelaSilver = new TableView<SilverDTO>();

	@FXML
	private Tooltip toolConsultar;

	@FXML
	private Tooltip toolConsultar1;

	@FXML
	private Tooltip toolConsultar11;

	@FXML
	private Tooltip toolConsultar111;

	@FXML
	private Tooltip toolConsultar1111;

	@FXML
	private Tooltip toolConsultar112;

	@FXML
	private Tooltip toolConsultar12;

	@FXML
	private Tooltip toolConsultar121;

	@FXML
	private Tooltip toolConsultar2;

	@FXML
	private TextField txtCnpj;

	@FXML
	private TextField txtIdCliente;

	@FXML
	private TextField txtIdFonteDados;

	@FXML
	private TextField txtNome;

	@FXML
	private TextArea txtObjNegocio;

	@FXML
	private TextField txtVolume;

	@FXML
	private TextArea txteMinimos;

	@FXML
	private TextArea txtePossiveis;

	@FXML
	private TextArea txtValidador;

	@FXML
	private CheckBox ckMatching;

	@FXML
	private CheckBox ckSerie;

	@FXML
	private TextArea txtMatching;

	@FXML
	private TextArea txtSerie;

	@FXML
	private CheckBox ckJoin;

	@FXML
	private CheckBox ckAgregacao;

	@FXML
	private TextArea txtJoin;

	@FXML
	private TextArea txtAgregacao;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// COMEÇO DO CODIGO///

	public void initialize(URL url, ResourceBundle rb) {

		// Populando o boxOrigem

		ObservableList<String> listOrigem = FXCollections.observableArrayList("API", "SFTP", "Upload");

		boxOrigem.setItems(listOrigem);

		boxOrigem.getSelectionModel().selectFirst();

		// Populando o boxFormato

		ObservableList<String> listFormato = FXCollections.observableArrayList("JSON", "csv", "planilhas", "tabelas",
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
		
		// Tabela Core
		List<EscopoTabelaCore> addcore = new ArrayList<EscopoTabelaCore>();
		addcoreativacao = FXCollections.observableList(addcore);

		IdClienteProdutoCore.setCellValueFactory(new PropertyValueFactory<>("idcoreproduto"));
		colIdClienteCore.setCellValueFactory(new PropertyValueFactory<>("idclienteproduto"));
		colNomeProduto.setCellValueFactory(new PropertyValueFactory<>("nmproduto"));
		colCore.setCellValueFactory(new PropertyValueFactory<>("core"));

		TabelaCore.setItems(addcoreativacao);

		// Tabela Funcionalidades
		List<EscopoTabelaFuncionalidades> addfun = new ArrayList<EscopoTabelaFuncionalidades>();
		addfunativacao = FXCollections.observableList(addfun);

		idFuncionalidade.setCellValueFactory(new PropertyValueFactory<>("idprodutofuncionalidade"));
		colIdCliente.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colIdProdutoFuncionalidade.setCellValueFactory(new PropertyValueFactory<>("nmproduto"));
		colFuncionalidade.setCellValueFactory(new PropertyValueFactory<>("funcionalidades"));

		TabelaFuncionalidade.setItems(addfunativacao);

		// Tabela bronze
		List<BronzeDTO> ativacaoDTOs = new ArrayList<BronzeDTO>();
		produtoAtivacaoObservableList = FXCollections.observableList(ativacaoDTOs);

		colfontedadoBronze.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("idFonteDado"));
		colProduto.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("nomeProduto"));
		colFormato.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("formato"));
		colSistema.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("sistema"));
		colFrequencia.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("frequencia"));
		colOrigem.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("origenDado"));
		colVolume.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("volume"));

		tabelaBronze.setItems(produtoAtivacaoObservableList);

		// Tabela Silver
		List<SilverDTO> addsil = new ArrayList<SilverDTO>();
		addsilver = FXCollections.observableList(addsil);
		colIdSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("idSilver"));
		colObrigatorio.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("obrigatorio"));
		colValidador.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("validador"));
		colIdFonte.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("idFonteDado"));
		colProdutoSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("nomeProduto"));
		colFormatoSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("formato"));
		colSistemaSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("sistema"));
		colFrequenciaSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("frequencia"));
		colOrigemSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("origenDado"));
		colVolumeSilver.setCellValueFactory(new PropertyValueFactory<SilverDTO, String>("volume"));

	}

	@FXML
	void btnAddTabelaCore() {
		String nmproduto = boxProdutoIdEscopo.getSelectionModel().getSelectedItem().toString();
		String core = boxCore.getSelectionModel().getSelectedItem().toString();
		String IdCliente = txtIdCliente.getText();

		EscopoDAO dao = new EscopoDAO();
		EscopoDTO objescopoDTO = dao.cadastrocore(nmproduto, core, IdCliente);

		EscopoTabelaCore obj = new EscopoTabelaCore(core, nmproduto);

		addcoreativacao.add(obj);
		btn();
	}

	@FXML
	void btnAddTabelaFuncionalidade() {

		String nmproduto = boxProdutoIdEscopoDois.getSelectionModel().getSelectedItem().toString();
		String funcionalidades = boxFuncionalidadeEscopo.getSelectionModel().getSelectedItem().toString();
		String IdCliente = txtIdCliente.getText();

		EscopoDAO dao = new EscopoDAO();
		EscopoDTO objescopoDTO = dao.cadastrofuncionalidade(nmproduto, funcionalidades, IdCliente);

		EscopoTabelaFuncionalidades objto = new EscopoTabelaFuncionalidades(funcionalidades, nmproduto);

		addfunativacao.add(objto);
		btn();
	}
	
	private void btn() {
		EscopoDAO dao = new EscopoDAO();
		List<EscopoDTO> core = new ArrayList<>();
		try {
			List<EscopoTabelaCore> resultado = dao.consultarCore(txtIdCliente.getText());
			if (resultado.isEmpty()) {
			} else {
				TabelaCore.setItems(FXCollections.observableArrayList(resultado));
			}
		} catch (Exception e) {
			// TODO: handle exception
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}
		List<EscopoTabelaFuncionalidades> funcionalidade = new ArrayList<>();
		try {
			List<EscopoTabelaFuncionalidades> resultado = dao.consultarFuncionalidades(txtIdCliente.getText());
			if (resultado.isEmpty()) {
			} else {
				TabelaFuncionalidade.setItems(FXCollections.observableArrayList(resultado));
			}

		} catch (Exception e) {
			// TODO: handle exception
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}
		
		colIdClienteCore.setVisible(true);
		colIdCliente.setVisible(true);
		idFuncionalidade.setVisible(true);
		IdClienteProdutoCore.setVisible(true);
	}
	
	@FXML
	void btnLimparEscopoDois() {
		if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
			boxProdutoIdEscopo.getSelectionModel().selectFirst();
			boxCore.getSelectionModel().selectFirst();
			boxProdutoIdEscopoDois.getSelectionModel().selectFirst();
			boxFuncionalidadeEscopo.getSelectionModel().selectFirst();
			
			TabelaCore.getItems().removeAll(TabelaCore.getItems());
			TabelaFuncionalidade.getItems().removeAll(TabelaFuncionalidade.getItems());
			
			colIdClienteCore.setVisible(false);
			colIdCliente.setVisible(false);
			idFuncionalidade.setVisible(false);
			IdClienteProdutoCore.setVisible(false);
			
		}
	}
	
	@FXML
	void btnDeletarEscopoDois() {
		if(TabelaCore.getSelectionModel().getSelectedItem() == null && TabelaFuncionalidade.getSelectionModel().getSelectedItem() == null) {
			exibiDialogoERRO("Nao ha nenhuma linha selecionada");
		}else {
			if (TabelaCore.getSelectionModel().getSelectedItem() != null) {
				if (exibiDialogoConfirmacao("Confirmar a exclusao do CORE selecionado?")) {
	
					try {
						EscopoDAO dao = new EscopoDAO();
						dao.deletarcore(TabelaCore.getSelectionModel().getSelectedItem().getIdcoreproduto());
						btn();
	
						exibiDialogoConfirmacao("CORE deletado com sucesso.");
						btn();
					} catch (Exception e) {
						exibiDialogoERRO("Falha ao deletar CORE.");
					}
				}
			}
			
			if (TabelaFuncionalidade.getSelectionModel().getSelectedItem() != null) {
				if (exibiDialogoConfirmacao("Confirmar a exclusao da FUNCIONALIDADE selecionada?")) {
	
					try {
						EscopoDAO dao = new EscopoDAO();
						dao.deletarfuncionalidade(TabelaFuncionalidade.getSelectionModel().getSelectedItem().getIdprodutofuncionalidade());
						btn();
	
						exibiDialogoConfirmacao("FUNCIONALIDADE deletada com sucesso.");
						btn();
					} catch (Exception e) {
						exibiDialogoERRO("Falha ao deletar FUNCIONALIDADE.");
					}
				}
			}
		}
		
	}


	@FXML
	void boxCore() {
		EscopoDTO escopo = new EscopoDTO();
		if (boxCore.getSelectionModel().getSelectedItem() != null) {
			String core = boxCore.getSelectionModel().getSelectedItem().toString();
			escopo.setNmProduto(core);

		}
	}

	@FXML
	void boxFuncionalidadeEscopo() {
		EscopoDTO escopo = new EscopoDTO();
		if (boxFuncionalidadeEscopo.getSelectionModel().getSelectedItem() != null) {
			String funcionalidades = boxFuncionalidadeEscopo.getSelectionModel().getSelectedItem().toString();
			escopo.setNmProduto(funcionalidades);

		}
	}

	@FXML
	void btnBuscaCliente() {
		String cnpj;
		cnpj = txtCnpj.getText();
		EscopoDAO consultaId = new EscopoDAO();
		EscopoDTO objescopoDTO = consultaId.consultaId(cnpj);
		txtIdCliente.setText(objescopoDTO.getIdCliente());
		txtNome.setText(objescopoDTO.getRazaoSocial());

		// Combo-box Produtos

		ObservableList<String> boxprodutocliente = FXCollections.observableArrayList();
		String IdCliente = txtIdCliente.getText();
		EscopoDAO dao = new EscopoDAO();
		objescopoDTO = dao.consultaboxproduto(boxprodutocliente, IdCliente);
		boxProdutoIdEscopo.setItems(objescopoDTO.boxprodutocliente);
		boxProdutoIdEscopo.getSelectionModel().selectFirst();

		// Popular lista produto cliente 2
		ObservableList<String> boxprodutoclientedois = FXCollections.observableArrayList();
		objescopoDTO = dao.consultaboxproduto(boxprodutoclientedois, IdCliente);
		boxProdutoIdEscopoDois.setItems(objescopoDTO.boxprodutoclientedois);
		boxProdutoIdEscopoDois.getSelectionModel().selectFirst();

		// Popular boxProduto bronze
		ObservableList<String> boxprodutobronze = FXCollections.observableArrayList();
		objescopoDTO = dao.consultaboxproduto(boxprodutobronze, IdCliente);
		boxProduto.setItems(objescopoDTO.boxprodutobronze);

		// Popular lista Core
		ObservableList<String> boxcores = FXCollections.observableArrayList();
		objescopoDTO = dao.selectcore(boxcores);
		boxCore.setItems(objescopoDTO.boxcores);
		boxCore.getSelectionModel().selectFirst();

		// Popular lista Funcionalidade
		ObservableList<String> boxfuncionalidade = FXCollections.observableArrayList();
		objescopoDTO = dao.select(boxfuncionalidade);
		boxFuncionalidadeEscopo.setItems(objescopoDTO.boxfuncionalidade);
		boxFuncionalidadeEscopo.getSelectionModel().selectFirst();

		// CRUD Descritivos
		objescopoDTO = dao.consultadescritivo(IdCliente);
		txteMinimos.setText(objescopoDTO.getEntregaveisMinimos());
		txtObjNegocio.setText(objescopoDTO.getObjNegocios());
		txtePossiveis.setText(objescopoDTO.getEntregaveisPossiveis());

		// CRUD CheckBox Produtdos
		ArrayList<String> crudprodutolist = new ArrayList();
		objescopoDTO = dao.consultacrudproduto(crudprodutolist, IdCliente);
		if (crudprodutolist.contains("Marketing & Planning")) {
			produtoMarketing.setSelected(true);
		}
		if (crudprodutolist.contains("Vox")) {
			produtoVox.setSelected(true);
		}
		if (crudprodutolist.contains("Sales & Distribution")) {
			produtoSales.setSelected(true);
		}
		if (crudprodutolist.contains("Pricing")) {
			produtoPricing.setSelected(true);
		}
		if (crudprodutolist.contains("Optimization")) {
			produtoOptimization.setSelected(true);
		}
		if (crudprodutolist.contains("Matching & Risk")) {
			produtoMatching.setSelected(true);
		}

		List<EscopoDTO> core = new ArrayList<>();
		try {
			List<EscopoTabelaCore> resultado = dao.consultarCore(txtIdCliente.getText());
			if (resultado.isEmpty()) {
			} else {
				TabelaCore.setItems(FXCollections.observableArrayList(resultado));
			}
		} catch (Exception e) {
			// TODO: handle exception
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}

		List<EscopoTabelaFuncionalidades> funcionalidade = new ArrayList<>();
		try {
			List<EscopoTabelaFuncionalidades> resultado = dao.consultarFuncionalidades(txtIdCliente.getText());
			if (resultado.isEmpty()) {
			} else {
				TabelaFuncionalidade.setItems(FXCollections.observableArrayList(resultado));
			}

		} catch (Exception e) {
			// TODO: handle exception
			exibiDialogoERRO("Falha ao realizar a consulta!");
			e.printStackTrace();
		}

		colIdClienteCore.setVisible(true);
		colIdCliente.setVisible(true);
		idFuncionalidade.setVisible(true);
		IdClienteProdutoCore.setVisible(true);
		
	}

	@FXML
	void btnAtualizarEscopo() {
		String IdCliente;
		IdCliente = txtIdCliente.getText();
		String entregavelminimos = this.txteMinimos.getText();
		String entregavelpossivel = this.txtePossiveis.getText();
		String objetivonegocio = this.txtObjNegocio.getText();
		EscopoDAO dao = new EscopoDAO();
		EscopoDTO objescopoDTO = dao.atualizardescritivo(IdCliente, entregavelminimos, entregavelpossivel,
				objetivonegocio);
	}

	// ESCOPO
	private ObservableList<EscopoTabelaCore> addcoreativacao;
	private ObservableList<EscopoTabelaFuncionalidades> addfunativacao;

	@FXML
	void btnCadastrarEscopo() {

		EscopoDTO e = new EscopoDTO();
		EscopoDAO dao = new EscopoDAO();
		String IdCliente = this.txtIdCliente.getText();
		e.setEntregaveisMinimos(txteMinimos.getText());
		e.setObjNegocios(txtObjNegocio.getText());
		e.setEntregaveisPossiveis(txtePossiveis.getText());
		e.setIdCliente(txtIdCliente.getText());
		try {
			dao.cadastrarDescritivo(e);
			exibiDialogoINFO(" Descritivo cadastrado com sucesso!");
			//btnLimparEscopo();

		} catch (Exception e1) {
			// TODO: handle exception
			exibiDialogoERRO("ERRO! Falha ao cadastrar descritivo.");
			e1.printStackTrace();
		}
		// Cadastrar Produtos

		ArrayList<String> listprodutos = new ArrayList<String>();
		if (produtoOptimization.isSelected()) {
			String produto = "5";
			listprodutos.add(produto);
		}
		if (produtoMatching.isSelected()) {
			String produto = "6";
			listprodutos.add(produto);
		}
		if (produtoVox.isSelected()) {
			String produto = "1";
			listprodutos.add(produto);
		}
		if (produtoPricing.isSelected()) {
			String produto = "4";
			listprodutos.add(produto);
		}
		if (produtoMarketing.isSelected()) {
			String produto = "2";
			listprodutos.add(produto);
		}
		if (produtoSales.isSelected()) {
			String produto = "3";
			listprodutos.add(produto);
		}
		EscopoDTO objescopoDTO = dao.cadastroproduto(listprodutos, IdCliente);

		// Popular lista produto cliente
		ObservableList<String> boxprodutocliente = FXCollections.observableArrayList();
		objescopoDTO = dao.consultaboxproduto(boxprodutocliente, IdCliente);
		boxProdutoIdEscopo.setItems(objescopoDTO.boxprodutocliente);

		// boxProdutoIdEscopoDois
		// Popular lista produto cliente 2
		ObservableList<String> boxprodutoclientedois = FXCollections.observableArrayList();
		objescopoDTO = dao.consultaboxproduto(boxprodutoclientedois, IdCliente);
		boxProdutoIdEscopoDois.setItems(objescopoDTO.boxprodutoclientedois);
	}

	@FXML
	void btnLimparCliente() {
		if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
			txtCnpj.clear();
			txtIdCliente.clear();
			txtNome.clear();
			txteMinimos.clear();
			txtObjNegocio.clear();
			txtePossiveis.clear();
			produtoOptimization.setSelected(false);
			produtoMatching.setSelected(false);
			produtoVox.setSelected(false);
			produtoPricing.setSelected(false);
			produtoMarketing.setSelected(false);
			produtoSales.setSelected(false);
			
			boxProdutoIdEscopo.getSelectionModel().selectFirst();
			boxCore.getSelectionModel().selectFirst();
			boxProdutoIdEscopoDois.getSelectionModel().selectFirst();
			boxFuncionalidadeEscopo.getSelectionModel().selectFirst();
			TabelaCore.getItems().removeAll(TabelaCore.getItems());
			TabelaFuncionalidade.getItems().removeAll(TabelaFuncionalidade.getItems());
			
			colIdClienteCore.setVisible(false);
			colIdCliente.setVisible(false);
			idFuncionalidade.setVisible(false);
			IdClienteProdutoCore.setVisible(false);

			txtVolume.clear();
			boxProduto.getSelectionModel().clearSelection();
			boxOrigem.getSelectionModel().selectFirst();
			boxFormato.getSelectionModel().selectFirst();
			boxFrequencia.getSelectionModel().selectFirst();
			boxSistema.getSelectionModel().selectFirst();
			tabelaBronze.getItems().removeAll(tabelaBronze.getItems());
			
			colObrigatorio.setVisible(false);
			colIdSilver.setVisible(false);
			colValidador.setVisible(false);
			txtValidador.clear();			
			ckbObrigatorio.setSelected(false);
			tabelaSilver.getItems().removeAll(tabelaSilver.getItems());

			ckMatching.setSelected(false);
    		ckSerie.setSelected(false);
    		ckJoin.setSelected(false);
    		ckAgregacao.setSelected(false);
    		txtMatching.clear();
    		txtMatching.setDisable(true);
    		txtSerie.clear();
    		txtSerie.setDisable(true);
    		txtJoin.clear();
    		txtJoin.setDisable(true);
    		txtAgregacao.clear();
    		txtAgregacao.setDisable(true);
		}
	}

	@FXML
	void btnLimparEscopo() {
		 if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
			 txteMinimos.clear();
				txtObjNegocio.clear();
				txtePossiveis.clear();
				produtoOptimization.setSelected(false);
				produtoMatching.setSelected(false);
				produtoVox.setSelected(false);
				produtoPricing.setSelected(false);
				produtoMarketing.setSelected(false);
				produtoSales.setSelected(false); 
		 }
		 
	}

	// Bronze
	private ObservableList<BronzeDTO> produtoAtivacaoObservableList;

	@FXML
	void btnAdc() throws SQLException {
		String volume = this.txtVolume.getText();
		String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
		String nomeFrequencia = boxFrequencia.getSelectionModel().getSelectedItem().toString();
		String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
		String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();
		String nomeProduto = boxProduto.getSelectionModel().getSelectedItem().toString();
		String idCliente = this.txtIdCliente.getText();

		BronzeDTO objBronzeDTO = new BronzeDTO(nomeFormato, nomeFrequencia, nomeOrigem, nomeSistema, volume,
				nomeProduto);

		produtoAtivacaoObservableList.add(objBronzeDTO);

		List<BronzeDTO> prods = new LinkedList<BronzeDTO>();
		prods.add(objBronzeDTO);

		BronzeDAO dao = new BronzeDAO();
		objBronzeDTO = dao.cadastrorBronze(nomeFormato, nomeFrequencia, nomeOrigem, nomeSistema, volume, nomeProduto,
				idCliente);

	}

	@FXML
	void bntConsultaBronze() throws SQLException {

		String idCliente = this.txtIdCliente.getText();
		BronzeDAO dao = new BronzeDAO();
		List<BronzeDTO> resultado = dao.consultar(idCliente);

		tabelaBronze.setItems(FXCollections.observableArrayList(resultado));
		colfontedadoBronze.setVisible(true);

	}

	@FXML
	void bntDeletarBronze() {

		if (exibiDialogoConfirmacao("Confirmar a exclusao do cliente selecionado?")) {

			try {

				BronzeDAO dao = new BronzeDAO();
				dao.deletar(tabelaBronze.getSelectionModel().getSelectedItem().getIdFonteDado());
				exibiDialogoConfirmacao("Cliente deletado com sucesso.");
				bntConsultaBronze();
			} catch (Exception e) {
			}
		}

	}

	@FXML
	void btnLimparBronze() {
		if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
			tabelaBronze.getItems().removeAll(tabelaBronze.getItems());

			txtVolume.clear();
			boxProduto.getSelectionModel().clearSelection();
			boxOrigem.getSelectionModel().selectFirst();
			boxFormato.getSelectionModel().selectFirst();
			boxFrequencia.getSelectionModel().selectFirst();
			boxSistema.getSelectionModel().selectFirst();
			colfontedadoBronze.setVisible(false);
		}
	}

	@FXML
	void boxOrigem() {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxOrigem.getSelectionModel().getSelectedItem() != null) {
			String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setOrigenDado(nomeOrigem);

		}
	}

	@FXML
	void boxFormato() {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxFormato.getSelectionModel().getSelectedItem() != null) {
			String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setFormato(nomeFormato);
		}
	}

	@FXML
	void boxFrequencia() {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxFrequencia.getSelectionModel().getSelectedItem() != null) {
			String nomeFrequencia = boxFrequencia.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setFrequencia(nomeFrequencia);
		}
	}

	@FXML
	void boxSistema() {

		BronzeDTO objbronzeDTO = new BronzeDTO();
		if (boxSistema.getSelectionModel().getSelectedItem() != null) {
			String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
			objbronzeDTO.setSistema(nomeSistema);
		}

	}

	// Silver

	private ObservableList<SilverDTO> addsilver;

	@FXML
	void btnCadastrarSilver() throws SQLException {
		String idCliente = this.txtIdCliente.getText();
		SilverDAO dao = new SilverDAO();
		List<SilverDTO> resultado = dao.consultar(idCliente);

		tabelaSilver.setItems(FXCollections.observableArrayList(resultado));
	}

	@FXML
	void btnAdcSilver() throws SQLException {
		String validador = this.txtValidador.getText();
		String idfontedado = (tabelaSilver.getSelectionModel().getSelectedItem().getIdFonteDado());
		String obrigatorio;

		if (ckbObrigatorio.isSelected()) {
			obrigatorio = "S";
		} else {
			obrigatorio = "N";
		}

		SilverDTO objsilverDTO = new SilverDTO();
		SilverDAO dao = new SilverDAO();
		objsilverDTO = dao.cadastrarSilver(validador, obrigatorio, idfontedado);

	}

	@FXML
	void btnLimparCamposSilver() {
		txtValidador.clear();
		ckbObrigatorio.setSelected(false);
	}

	@FXML
	void btnLimparSilver() {
		if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
			tabelaSilver.getItems().removeAll(tabelaSilver.getItems());
			txtValidador.clear();
			ckbObrigatorio.setSelected(false);
			btnAtualizar.setVisible(false);
			colObrigatorio.setVisible(false);
			colIdSilver.setVisible(false);
			colValidador.setVisible(false);
		}
	}

	@FXML
	void btnConsultarSilver() throws SQLException {

		String idCliente = this.txtIdCliente.getText();
		SilverDAO dao = new SilverDAO();
		List<SilverDTO> resultado = dao.consultarSilver(idCliente);

		tabelaSilver.setItems(FXCollections.observableArrayList(resultado));
		colObrigatorio.setVisible(true);
		colIdSilver.setVisible(true);
		colValidador.setVisible(true);
	}

	@FXML
	void btnDeletarSilver() {
		if (exibiDialogoConfirmacao("Confirmar a exclusao do cliente selecionado?")) {

			try {

				SilverDAO dao = new SilverDAO();
				dao.deletar(tabelaSilver.getSelectionModel().getSelectedItem().getIdSilver());
				exibiDialogoConfirmacao("Cliente deletado com sucesso.");
				btnConsultarSilver();
			} catch (Exception e) {
			}
		}
	}

	@FXML
	void btnAtualizarSilver(ActionEvent event) {
		tabelaSilver.getSelectionModel().getSelectedItem().getValidador();
		txtValidador.setText(tabelaSilver.getSelectionModel().getSelectedItem().getValidador());
		
		
		if (tabelaSilver.getSelectionModel().getSelectedItem().getObrigatorio().equals("S")) {
			ckbObrigatorio.setSelected(true);
		} else {
			
		}
		
		btnAtualizar.setVisible(true);
	}
	
    @FXML
    void btnAdcAtualizacaoSilver(ActionEvent event) throws SQLException {
    	String validador = this.txtValidador.getText();
		String idSilver = (tabelaSilver.getSelectionModel().getSelectedItem().getIdSilver());
		String obrigatorio;

		if (ckbObrigatorio.isSelected()) {
			obrigatorio = "S";
		} else {
			obrigatorio = "N";
		}

		SilverDTO objsilverDTO = new SilverDTO();
		SilverDAO dao = new SilverDAO();
		objsilverDTO = dao.Atualizar(validador, obrigatorio, idSilver);
		btnLimparCamposSilver();
		btnConsultarSilver();
		btnAtualizar.setVisible(false);
    }

	// Gold	
    private GoldDAO objGoldDAO = new GoldDAO();
	
    @FXML
    void ckMatching() {
		
		if (ckMatching.isSelected()) {
			txtMatching.setDisable(false);
        }else {
        	txtMatching.setDisable(true);
        }
    }
    
    @FXML
    void ckSerie() {
		
		if (ckSerie.isSelected()) {
			txtSerie.setDisable(false);
        }else {
        	txtSerie.setDisable(true);
        }
    }
    
    @FXML
    void ckJoin() {
		
		if (ckJoin.isSelected()) {
			txtJoin.setDisable(false);
        }else {
        	txtJoin.setDisable(true);
        }
    }
    
    @FXML
    void ckAgregacao() {
		
		if (ckAgregacao.isSelected()) {
			txtAgregacao.setDisable(false);
        }else {
        	txtAgregacao.setDisable(true);
        }
    }
    
    @FXML
	void btnLimparGold(){
    	if (exibiDialogoConfirmacao("Todos os campos serao limpos. Confirmar?")) {
    		ckMatching.setSelected(false);
    		ckSerie.setSelected(false);
    		ckJoin.setSelected(false);
    		ckAgregacao.setSelected(false);
    		txtMatching.clear();
    		txtMatching.setDisable(true);
    		txtSerie.clear();
    		txtSerie.setDisable(true);
    		txtJoin.clear();
    		txtJoin.setDisable(true);
    		txtAgregacao.clear();
    		txtAgregacao.setDisable(true);
		}
    }
    
    @FXML
	void btnCadastrarGold(){
    	
    	GoldDTO objGold = new GoldDTO();
    	
    	if ((ckMatching.isSelected() && txtMatching.getText().equals("")) || (ckSerie.isSelected() && txtSerie.getText().equals("")) ||
    		(ckJoin.isSelected() && txtJoin.getText().equals("")) || (ckAgregacao.isSelected() && txtAgregacao.getText().equals(""))) {
    		exibiDialogoERRO("ERRO! Por favor, insira os dados corretamente!");
    	}else{
    		if (ckMatching.isSelected() || ckSerie.isSelected() || ckJoin.isSelected() || ckAgregacao.isSelected()) {
	    		if (ckMatching.isSelected()){
		    		objGold.setOperacao("Matching");
		    		objGold.setStrMatching(txtMatching.getText());
		    		
		    		objGoldDAO.cadastrarOperacoes(objGold);
		    	}
		    	if (ckSerie.isSelected()) {
		    		objGold.setOperacao("Serie Temporal");
		    		objGold.setStrSerie(txtSerie.getText());
		    		
		    		objGoldDAO.cadastrarOperacoes(objGold);
		    	}
		    	if (ckJoin.isSelected()) {
		    		objGold.setOperacao("Join");
		    		objGold.setStrJoin(txtJoin.getText());
		    		
		    		objGoldDAO.cadastrarOperacoes(objGold);
		    	}
		    	if (ckAgregacao.isSelected()) {
		    		objGold.setOperacao("Agregacao");
		    		objGold.setStrAgregacao(txtAgregacao.getText());
		    		
		    		objGoldDAO.cadastrarOperacoes(objGold);
		    	}
		    	exibiDialogoConfirmacao("Cadastrado com sucesso!");
		    	ckMatching.setSelected(false);
	    		ckSerie.setSelected(false);
	    		ckJoin.setSelected(false);
	    		ckAgregacao.setSelected(false);
	    		txtMatching.clear();
	    		txtMatching.setDisable(true);
	    		txtSerie.clear();
	    		txtSerie.setDisable(true);
	    		txtJoin.clear();
	    		txtJoin.setDisable(true);
	    		txtAgregacao.clear();
	    		txtAgregacao.setDisable(true);
	    	}else{
	    		exibiDialogoERRO("ERRO! Por favor, selecione no minimo uma opcao!");
	    	}
    	}
    }

	private void exibiDialogoINFO(String informacao) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informacao");
		alert.setHeaderText(null);
		alert.setContentText(informacao);

		alert.showAndWait();

	}

	void exibiDialogoERRO(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText(null);
		alert.setContentText(erro);

		alert.showAndWait();

	}

	private boolean exibiDialogoConfirmacao(String confirmacao) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmacao");
		alert.setHeaderText(null);
		alert.setContentText(confirmacao);
		Optional<ButtonType> opcao = alert.showAndWait();

		if (opcao.get() == ButtonType.OK)
			return true;
		return false;

	}

}
