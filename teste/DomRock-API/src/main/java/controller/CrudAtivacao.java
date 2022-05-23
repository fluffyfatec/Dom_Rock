package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import modal.BronzeDTO;

public class CrudAtivacao implements Initializable {
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
	private CheckBox ckbObrigatorio;

	@FXML
	private TableColumn<BronzeDTO, String> colFormato = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<?, ?> colFormatoSilver;

	@FXML
	private TableColumn<BronzeDTO, String> colFrequencia = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<?, ?> colFrequenciaSilver;

	@FXML
	private TableColumn<?, ?> colIdFonteSilver;

	@FXML
	private TableColumn<BronzeDTO, String> colOrigem = new TableColumn<BronzeDTO, String>();
	@FXML
	private TableColumn<?, ?> colOrigemSilver;

	@FXML
	private TableColumn<BronzeDTO, String> colProduto = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<?, ?> colProdutoSilver;

	@FXML
	private TableColumn<BronzeDTO, String> colSistema = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<?, ?> colSistemaSilver;

	@FXML
	private TableColumn<BronzeDTO, String> colVolume = new TableColumn<BronzeDTO, String>();

	@FXML
	private TableColumn<?, ?> colVolumeSilver;

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

	@FXML
	private CheckBox funcaoBusca;

	@FXML
	private CheckBox funcaoGeradorData;

	@FXML
	private CheckBox funcaoGeradorRelatorio;

	@FXML
	private CheckBox funcaoPainel;

	@FXML
	private Tab geral;

	@FXML
	private CheckBox produtoMarketing;

	@FXML
	private CheckBox produtoMatching;

	@FXML
	private CheckBox produtoOptimization;

	@FXML
	private CheckBox produtoPricing;

	@FXML
	private CheckBox produtoSales;

	@FXML
	private CheckBox produtoVox;

	@FXML
	private TableView<BronzeDTO> tabelaBronze = new TableView<BronzeDTO>();

	@FXML
	private TableView<?> tabelaSilver;

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
	private TextField txtValidador;

	@FXML
	private TextField txtVolume;

	@FXML
	private TextArea txteMinimos;

	@FXML
	private TextArea txtePossiveis;

	
	
	public void initialize(URL url, ResourceBundle rb) {

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
		colSistema.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("sistema"));
		colFrequencia.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("frequencia"));
		colOrigem.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("origenDado"));
		colVolume.setCellValueFactory(new PropertyValueFactory<BronzeDTO, String>("volume"));

		tabelaBronze.setItems(produtoAtivacaoObservableList);
	}
	
	
	
	
	
	
	@FXML
	void boxProduto() {

	}

	@FXML
	void btnAdcSilver() {

	}

	@FXML
	void btnBuscaCliente() {

	}

	@FXML
	void btnCadastrarBronze() {

	}

	@FXML
	void btnCadastrarEscopo() {

	}

	@FXML
	void btnCadastrarSilver() {

	}

	@FXML
	void btnLimparBronze() {

	}

	@FXML
	void btnLimparCliente() {

	}

	@FXML
	void btnLimparEscopo() {

	}

	// Bronze
	private ObservableList<BronzeDTO> produtoAtivacaoObservableList;

	@FXML
	void btnAdc(ActionEvent event) throws SQLException {
		String volume = this.txtVolume.getText();
		String nomeSistema = boxSistema.getSelectionModel().getSelectedItem().toString();
		String nomeFrequencia = boxFrequencia.getSelectionModel().getSelectedItem().toString();
		String nomeOrigem = boxOrigem.getSelectionModel().getSelectedItem().toString();
		String nomeFormato = boxFormato.getSelectionModel().getSelectedItem().toString();
		String nomeProduto = boxProduto.getSelectionModel().getSelectedItem().toString();

		BronzeDTO objtesteDTO = new BronzeDTO(nomeFormato, nomeFrequencia, nomeOrigem, nomeSistema, volume,
				nomeProduto);

		produtoAtivacaoObservableList.add(objtesteDTO);

		List<BronzeDTO> prods = new LinkedList<BronzeDTO>();
		prods.add(objtesteDTO);

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

	@FXML
	void btnLimparSilver() {

	}

	

}
