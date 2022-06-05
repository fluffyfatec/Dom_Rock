package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modal.ClienteDTO;
import modal.ClienteDAO;
import modal.ConnectionFactory;

public class CrudClienteController implements Initializable {

	@FXML
	private Label Cnpj;

	@FXML
	private TabPane abas;

	@FXML
	private Tab atualizar;

	// @FXML
	// private ComboBox<?> box_cad_segmento;

	@FXML
	private Tab cliente;

	@FXML
	private Tab consultar;

	@FXML
	private Tab silver;

	@FXML
	private TableView<ClienteDTO> table_cliente;

	@FXML
	private TableColumn<ClienteDTO, Integer> table_cliente_id;

	@FXML
	private TableColumn<ClienteDTO, String> table_cliente_razao_social;

	@FXML
	private TableColumn<ClienteDTO, String> table_cliente_cnpj;

	@FXML
	private TableColumn<ClienteDTO, String> table_cliente_segmento;

	@FXML
	private TableColumn<ClienteDTO, Date> table_cliente_data;

	@FXML
	private TextField txt_att_cnpj;

	@FXML
	private TextField txt_att_razao_social;

	@FXML
	private TextField txt_cad_cnpj;

	@FXML
	private TextField txt_cad_razao_social;

	@FXML
	private TextField txt_consulta_cnpj;

	private ClienteDTO clienteSelecionado;

	@FXML
	private ComboBox<String> box_cad_segmento = new ComboBox<String>();
	@FXML
	private ComboBox<String> box_att_segmento = new ComboBox<String>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/// INICIO DO CODIGO///

	private ClienteDAO dao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		dao = new ClienteDAO();

		ObservableList<String> list = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo", "Governo");
		box_cad_segmento.setItems(list);
		box_cad_segmento.getSelectionModel().selectFirst();

		ObservableList<String> lista2 = FXCollections.observableArrayList("Industria", "Atacado", "Comercio/Varejo", "Governo");
		box_att_segmento.setItems(lista2);
		//box_att_segmento.getSelectionModel().selectFirst();

		table_cliente_id.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		table_cliente_razao_social.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
		table_cliente_cnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		table_cliente_segmento.setCellValueFactory(new PropertyValueFactory<>("segmento"));
		table_cliente_data.setCellValueFactory(new PropertyValueFactory<>("datahora_cadastro"));

	}

	/// CADASTRAR CLIENTE///
	@FXML
	void btn_cad_salvar() {
		if(txt_cad_razao_social.getText().equals("") || txt_cad_cnpj.getLength() != 14) {
			exibiDialogoERRO("ERRO! Por favor, insira todos os campos corretamente.");
		}else {
			ClienteDTO cliente = new ClienteDTO();
	
			cliente.setRazao_social(txt_cad_razao_social.getText());
			cliente.setCnpj(txt_cad_cnpj.getText()); // cliente.setSegmento(box_cad_segmento.getSelectionModel().getSelectedItem().toString());
			String segmento = box_cad_segmento.getSelectionModel().getSelectedItem().toString();
			cliente.setSegmento(segmento);
	
			try {
				dao.cadastrar(cliente);
				exibiDialogoINFO("Cliente cadastrado com SUCESSO!");
				txt_cad_razao_social.clear();
				txt_cad_cnpj.clear();
				box_cad_segmento.getSelectionModel().selectFirst();
	
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("ERRO! Falha ao cadastrar CLIENTE.");
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btn_cad_limpar() {
		
		if (exibiDialogoConfirmacao("Todos os campos serao LIMPOS. Confirmar?")) {
			txt_cad_razao_social.clear();
			txt_cad_cnpj.clear();
			box_cad_segmento.getSelectionModel().selectFirst();
		}
	}

	/// CONSULTAR / EXCLUIR CLIENTE///
	@FXML
	void btn_consulta_cnpj() {
		try {
			List<ClienteDTO> resultado = dao.consultar(txt_consulta_cnpj.getText());
			if (resultado.isEmpty()) {
				exibiDialogoINFO("Nenhum CLIENTE encontrado!");
			} else {

				table_cliente.setItems(FXCollections.observableArrayList(resultado));

			}

		} catch (Exception e) {
			// TODO: handle exception
			exibiDialogoERRO("Falha ao realizar a CONSULTA!");
			e.printStackTrace();
		}

	}

	@FXML
	void btn_consulta_atualizar() {

		clienteSelecionado = table_cliente.getSelectionModel().getSelectedItem();
		if (table_cliente.getSelectionModel().getSelectedItem() == null) {
			exibiDialogoERRO("Nao há LINHA selecionada");

		} else {
			atualizar.setDisable(false);
			txt_att_razao_social.setText(clienteSelecionado.getRazao_social());
			txt_att_cnpj.setText(clienteSelecionado.getCnpj());
			box_att_segmento.setPromptText(clienteSelecionado.getSegmento());
		}

	}

	// EXCLUIR
	@FXML
	void btn_consulta_deletar() {
		if (table_cliente.getSelectionModel().getSelectedItem() == null) {
			exibiDialogoERRO("Nao há LINHA selecionada");

		} else {

			if (exibiDialogoConfirmacao("Confirmar a exclusão da LINHA selecionada?")) {

				try {
					dao.deletar(table_cliente.getSelectionModel().getSelectedItem().getId_cliente());
					;
					exibiDialogoConfirmacao("Cliente DELETADO com sucesso.");
					btn_consulta_cnpj();
				} catch (Exception e) {
					exibiDialogoERRO("Falha ao DELETAR cliente.");
				}
			}

		}
	}

	/// ATUALIZAR CLIENTE///
	@FXML
	void btn_att_limpar() {
		if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
			txt_att_razao_social.clear();
			txt_att_cnpj.clear();
			box_att_segmento.getSelectionModel().selectFirst();
		}
	}

	@FXML
	void btn_att_salvar() {
		if(txt_att_razao_social.getText().equals("") || txt_att_cnpj.getLength() != 14) {
			exibiDialogoERRO("ERRO! Por favor, insira todos os campos corretamente.");
		}else {
			clienteSelecionado = table_cliente.getSelectionModel().getSelectedItem();
	
			clienteSelecionado.setCnpj(txt_att_cnpj.getText());
			clienteSelecionado.setRazao_social(txt_att_razao_social.getText());
			String segmento = box_att_segmento.getSelectionModel().getSelectedItem().toString();
			clienteSelecionado.setSegmento(segmento);
			try {
				dao.atualizar(clienteSelecionado);
				exibiDialogoINFO("Cliente ATUALIZADO com sucesso!");
				abas.getSelectionModel().select(consultar);
				btn_consulta_cnpj();
				atualizar.setDisable(true);
			} catch (Exception e) {
				exibiDialogoERRO("ERRO! Falha ao ATUALIZAR.");
	
			}
		}
	}

	/// GERENCIAR ABAS///
	@FXML
	void gerenciarAbas() {
		if (cliente.isSelected() || consultar.isSelected()) {
			atualizar.setDisable(true);
		}

	}

	private void exibiDialogoINFO(String informacao) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
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
		alert.setTitle("Confirmação");
		alert.setHeaderText(null);
		alert.setContentText(confirmacao);

		Optional<ButtonType> opcao = alert.showAndWait();

		if (opcao.get() == ButtonType.OK)
			return true;
		return false;

	}

}
