package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modal.EscopoDAO;
import modal.EscopoDTO;
import modal.ExportarDAO;

public class IntroducaoController implements Initializable {
	
	@FXML
	private Menu bntClienteintro;
	@FXML
	private Menu inputUsuario;
	@FXML
	private Menu btnUsuario;
	@FXML
	private Menu inputCadastrarintro;
	@FXML
	private Menu inputAjudaintro;
	@FXML
	private Menu inputCadastrarcliente;
    @FXML
    private Menu bntProduto;

    @FXML
    private Menu menusair;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	//VAI PARA TELA CRUD ATIVAÇÃO
	@FXML
	void inputCadastrarintro( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudAtivacao.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 807, 550);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Etapas - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	

	//VAI PARA TELA CRUD CLIENTE
	@FXML
	void inputCadastrarCliente( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudCliente.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load() );
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Cadastrar Clientes - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();

	}
	
	//VAI PARA TELA CRUD USUARIO
	@FXML
	void btnUsuario( ) {

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/CrudUsuario.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 668, 432);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle(" Usuário - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();
	    }
	
	//VAI PARA TELA Login
	@FXML private javafx.scene.control.Button btnSair;
	
	@FXML
	void btnSair( ) {
		Stage stage = (Stage) btnSair.getScene().getWindow(); //Obtendo a janela atual
        stage.close();
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/Login.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 367, 297);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		stage.setTitle(" Login - Dom Rock");
		stage.setResizable(false);
		stage.setMaximized(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();
	}
	

    @FXML
    void btnDadosMinimos() {
    	FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/view/Produto.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(fxmlLoader.load(), 521, 339);
			scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Stage stage = new Stage();
		stage.setTitle("Dados Mínimos - Dom Rock");
		stage.setResizable(false);
		stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    void btnExportar(ActionEvent event) {
    	try {
		ExportarDAO dao = new ExportarDAO();
    	EscopoDTO objescopodto = dao.exportarjson();
    	
    	exibiDialogoINFO("JSON Exportado com SUCESSO!");
		} catch (Exception e) {
		 exibiDialogoERRO("ERRO ao exportar o JSON!");
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

}
