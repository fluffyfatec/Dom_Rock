package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.management.ObjectInstance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import modal.ComentarioDAO;
import modal.ComentarioDTO;
import modal.EscopoDTO;
import modal.ProdutoDAO;
import modal.ProdutoDTO;
import modal.Singleton;

public class ComentarioController implements Initializable{
	
	private ComentarioDAO dao;
	
    @FXML
    private TextArea txtComentario;
    
	public void initialize(URL url, ResourceBundle rb) {
		String idcliente = Singleton.getInstance().IdCliente;
    	String etapa = Singleton.getInstance().etapa;
		//Singleton.getInstance().IdCliente;
		System.out.println(idcliente + "ok" + etapa);
		
		ComentarioDAO dao = new ComentarioDAO();
		ComentarioDTO objcomentariodto = dao.consultarcomentario(idcliente, etapa);
		txtComentario.setText(objcomentariodto.getComentario());
		Singleton.getInstance().teste = txtComentario.getText();
	}
	
    @FXML
    void btnCadastrarComentario(ActionEvent event) {
    	String idcliente = Singleton.getInstance().IdCliente;
    	String etapa = Singleton.getInstance().etapa;
    	String teste = Singleton.getInstance().teste;
    	String comentario = this.txtComentario.getText();
    	System.out.println(teste);
		
    	if (teste!=null) {
			ComentarioDAO dao = new ComentarioDAO();
			ComentarioDTO objcomentariodto = dao.updatecomentario(comentario, idcliente, etapa);
			exibiDialogoINFO("Comentário ATUALIZADO com sucesso !");
		}
		else {
			ComentarioDAO dao = new ComentarioDAO();
			ComentarioDTO objcomentariodto = dao.cadastrocomentario(comentario, idcliente, etapa);
			exibiDialogoINFO("Comentário CADASTRADO com sucesso !");
		}
    	}

//Alertas//
private void exibiDialogoINFO(String informacao) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Informação");
	alert.setHeaderText(null);
	alert.setContentText(informacao);

	alert.showAndWait();

}
}