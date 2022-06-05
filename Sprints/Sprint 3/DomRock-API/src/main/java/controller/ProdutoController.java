package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import modal.ProdutoDAO;
import modal.ProdutoDTO;

public class ProdutoController implements Initializable {

	private ProdutoDAO dao;
	
    @FXML
    private ComboBox<String> boxProdutoProduto = new ComboBox<String>();

    @FXML
    private ComboBox<String> boxSolucaoProduto = new ComboBox<String>();
    
	ObservableList<String> listdemand = FXCollections.observableArrayList ("Vox", "Marketing & Planning", "Sales & Distribution", "Pricing");
	ObservableList<String> listoperations = FXCollections.observableArrayList("Optimization","Matching & Risk");
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	dao = new ProdutoDAO();
    	ObservableList<String> listsolucao = FXCollections.observableArrayList ("NX.Demand","NX.Operations"); //Lista da Solu��o
    	boxSolucaoProduto.setItems(listsolucao);
    	boxProdutoProduto.setItems(listdemand);
    	boxProdutoProduto.getSelectionModel().selectFirst();
    	boxSolucaoProduto.getSelectionModel().selectFirst();
    	
    	// Selecionar o primeiro Produto e enviar para o DAO 
    	String produto;
		produto = boxProdutoProduto.getSelectionModel().getSelectedItem().toString();
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoDTO objprodutoDTO = dao.consultadadominimo(produto);
		txtDadoMinimoProduto.setText(objprodutoDTO.getDadoMinimo());
    }
    
    @FXML
    void boxSolucaoProduto(ActionEvent event) {	
    	String solucao = boxSolucaoProduto.getSelectionModel().getSelectedItem().toString();
    	if ("NX.Demand".equals(solucao)) {
    		boxProdutoProduto.setItems(listdemand);
    	}
    	else if ("NX.Operations".equals(solucao)) {
    		boxProdutoProduto.setItems(listoperations);
    	}
		boxProdutoProduto.getSelectionModel().selectFirst();
    }
    
    
    @FXML
    void boxProdutoProduto(ActionEvent event) {
    	String produto;
		produto = boxProdutoProduto.getSelectionModel().getSelectedItem();
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoDTO objprodutoDTO = dao.consultadadominimo(produto);
		txtDadoMinimoProduto.setText(objprodutoDTO.getDadoMinimo());
    }
    
    @FXML
    private TextArea txtDadoMinimoProduto;

    @FXML
    void btnAtualizarProduto(ActionEvent event) {
    	if (txtDadoMinimoProduto.getText().equals("")) {
    		exibiDialogoERRO("ERRO! Por favor, insira os dados corretamente.");
    	}else {
	    	String produto;
			produto = boxProdutoProduto.getSelectionModel().getSelectedItem().toString();
			String dadominimo = this.txtDadoMinimoProduto.getText();
			ProdutoDAO dao = new ProdutoDAO();
			ProdutoDTO objprodutoDTO = dao.produtodadominimo(produto, dadominimo);
    	}
    }
    
    void exibiDialogoERRO(String erro) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Informacao");
    	alert.setHeaderText(null);
    	alert.setContentText(erro);
    	
    	alert.showAndWait();
    	
    }
}
