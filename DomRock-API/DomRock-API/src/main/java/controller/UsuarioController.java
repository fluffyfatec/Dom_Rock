package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modal.UsuarioDAO;
import modal.UsuarioDTO;
import modal.ClienteDTO;
import modal.ClienteDAO;

public class UsuarioController implements Initializable {

    @FXML
    private Label lblUsuario;

    @FXML
    private TabPane abas;

    @FXML
    private Tab atualizarUsuario;
    
    @FXML
    private Tab consultar;

    @FXML
    private TableView<UsuarioDTO> tabelaUsuario;

    @FXML
    private TableColumn<UsuarioDTO, Integer> colUsuarioId;
    
    @FXML
    private TableColumn<UsuarioDTO, String> colUsuarioFuncao;

    @FXML
    private TableColumn<UsuarioDTO, String> colUsuarioNome;

    @FXML
    private TableColumn<UsuarioDTO, String> colUsuarioUsuario;
    
    @FXML
    private TableColumn<UsuarioDTO, String> colUsuarioSenha;

    @FXML
    private TextField txtNomeCadastro;

    @FXML
    private TextField txtFuncaoCadastro;    

    @FXML
    private TextField txtUsuarioCadastro;
    
    @FXML
    private PasswordField txtSenhaCadastro;
    
    @FXML
    private PasswordField txtConfirmarSenha;

    @FXML
    private TextField txtNomeAt;

    @FXML
    private TextField txtFuncaoAt;    

    @FXML
    private TextField txtUsuarioAt;
    
    @FXML
    private PasswordField txtSenhaAt;
    
    @FXML
    private PasswordField txtConfirmarSenhaAt;
    
    @FXML
    private TextField txtUsuarioConsultar;


    
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///COME�O DO CODIGO///
    
    private UsuarioDTO usuarioSelecionado;
    private UsuarioDAO dao;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	dao = new UsuarioDAO();
    	
    	colUsuarioId.setCellValueFactory(new PropertyValueFactory<>("id_usuario"));
		colUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colUsuarioFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));
		colUsuarioUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		colUsuarioSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
	}
    
    ///CADASTRAR USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnCadastrarUsuario() {
    	if (txtNomeCadastro.getText().equals("") || txtFuncaoCadastro.getText().equals("") || 
    			txtUsuarioCadastro.getText().equals("") || txtSenhaCadastro.getText().equals("") ) {
    		exibiDialogoERRO("ERRO! Por favor, insira os dados corretamente.");
    	}else {
	    	if (txtSenhaCadastro.getText().equals(txtConfirmarSenha.getText())) {
	    	
				UsuarioDTO usuario = new UsuarioDTO();
	
				usuario.setNome(txtNomeCadastro.getText());
				usuario.setFuncao(txtFuncaoCadastro.getText());
				usuario.setUsuario(txtUsuarioCadastro.getText());
				usuario.setSenha(txtSenhaCadastro.getText());
				
				try {
					dao.cadastrarUsuario(usuario);
					exibiDialogoINFO("Usuario CADASTRADO com sucesso!");
					txtNomeCadastro.clear();
			    	txtFuncaoCadastro.clear();
			    	txtUsuarioCadastro.clear();
			    	txtSenhaCadastro.clear();
			    	txtConfirmarSenha.clear();
				} catch (Exception e) {
					// TODO: handle exception
					exibiDialogoERRO("ERRO! Falha ao CADASTRAR usuario.");
					e.printStackTrace();
				}
	    	}else {
	    		exibiDialogoINFO("Por favor, digite a SENHA corretamente nos dois campos");
	    	}    		
    	}
    }
    
    ///LIMPAR CAMPOS CADASTRO USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnLimparUsuario() {
    	if (exibiDialogoConfirmacao("Todos os campos serão LIMPOS. Confirmar?")) {
	    	txtNomeCadastro.clear();
	    	txtFuncaoCadastro.clear();
	    	txtUsuarioCadastro.clear();
	    	txtSenhaCadastro.clear();
	    	txtConfirmarSenha.clear();
    	}
    }
    
    ///CONSULTAR USUARIO////////////////////////////////////////////////////////////////    
    @FXML
    void btnUsuarioConsultar() {
    	try {
    		List<UsuarioDTO> resultado =  dao.consultar(txtUsuarioConsultar.getText());
        	if(resultado.isEmpty()) {
        		exibiDialogoINFO("Nenhum USUÁRIO encontrado!");
        	}else {
        		tabelaUsuario.setItems(FXCollections.observableArrayList(resultado));
        	}
			
		} catch (Exception e) {

			exibiDialogoERRO("Falha ao realizar a CONSULTA!");
			e.printStackTrace();
		}
    }
    
    ///BOTAO ATUALIZAR USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnUsuarioAtualizar() {
    	usuarioSelecionado = tabelaUsuario.getSelectionModel().getSelectedItem();
    	if (tabelaUsuario.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há usuário SELECIONADO");

    	} else {
    		atualizarUsuario.setDisable(false);
    		txtNomeAt.setText(usuarioSelecionado.getNome());
    		txtFuncaoAt.setText(usuarioSelecionado.getFuncao());
    		txtUsuarioAt.setText(usuarioSelecionado.getUsuario());
    		txtConfirmarSenhaAt.clear();
    	}
    }

    ///DELETAR USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnUsuarioDeletar() {
    	if (tabelaUsuario.getSelectionModel().getSelectedItem()== null) {
			exibiDialogoERRO("Não há usuário SELECIONADO");

    	} else {
    		
    		if (exibiDialogoConfirmacao("Confirmar a exclusão do USUÁRIO selecionado?")) {
    	  
    			try{
					dao.deletar(tabelaUsuario.getSelectionModel().getSelectedItem().getId_usuario());;
					exibiDialogoConfirmacao("USUÁRIO deletado com sucesso.");
					txtUsuarioConsultar.clear();
					btnUsuarioConsultar();
    				}catch (Exception e) {
    			     exibiDialogoERRO("Falha ao deletar USUÁRIO.");
    				}
    			}
    
    	}
    }

    ///ATUALIZAR USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnUsuarioSalvarAtt() {
    	if (txtNomeAt.getText().equals("") || txtFuncaoAt.getText().equals("") || 
    			txtUsuarioAt.getText().equals("") || txtSenhaAt.getText().equals("") ) {
    		exibiDialogoERRO("ERRO! Por favor, insira os DADOS corretamente.");
    	}else {
	    	if (txtSenhaAt.getText().equals(txtConfirmarSenhaAt.getText())) {
				usuarioSelecionado = tabelaUsuario.getSelectionModel().getSelectedItem();
				
				usuarioSelecionado.setNome(txtNomeAt.getText());
				usuarioSelecionado.setFuncao(txtFuncaoAt.getText());
				usuarioSelecionado.setUsuario(txtUsuarioAt.getText());
				usuarioSelecionado.setSenha(txtSenhaAt.getText());
			    try {
					dao.atualizar(usuarioSelecionado);
					exibiDialogoINFO("Usuario ATUALIZADO com sucesso!");
					abas.getSelectionModel().select(consultar);
					btnUsuarioConsultar();
					atualizarUsuario.setDisable(true);
				} catch (Exception e) { 			
					exibiDialogoERRO("ERRO! Falha ao ATUALIZAR.");
				}
	    	}else {
	    		exibiDialogoINFO("Por favor, digite a SENHA corretamente nos dois campos");
	    	}
    	}
    }
    
    ///LIMPAR CAMPOS ATUALIZAÇÃO USUARIO////////////////////////////////////////////////////////////////
    @FXML
    void btnUsuarioLimparAtt() {
    	if (exibiDialogoConfirmacao("Todos os campos serao LIMPOS. Confirmar?")) {
			txtNomeAt.clear();
			txtFuncaoAt.clear();
			txtUsuarioAt.clear();
			txtSenhaAt.clear();
			txtConfirmarSenhaAt.clear();
    	}
    }
    
    
	
	@FXML
    void gerenciarAbas() {
    	if(consultar.isSelected()) {
    		atualizarUsuario.setDisable(true);
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
     	
     	if(opcao.get() == ButtonType.OK)
     		return true;
     	return false;

     }
	

}
