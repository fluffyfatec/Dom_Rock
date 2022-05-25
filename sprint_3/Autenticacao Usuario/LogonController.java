package com.example.view;

import DAO.ConsultaId;
import DAO.ConsultaUsuario;
import DTO.CadastroUsuarioDTO;
import DTO.ClienteDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogonController {

	@FXML
    private TextField txtUsuario;
	
    @FXML
    private PasswordField txtSenha;

    @FXML
    void btnConectar(ActionEvent event) {
    	String usuario = txtUsuario.getText();
    	String senha = txtSenha.getText();
    	
    	ConsultaUsuario dao = new ConsultaUsuario();
        CadastroUsuarioDTO objusuarioDTO = dao.consultarusuario(usuario, senha);

        System.out.println(objusuarioDTO.getUsuario());
    }

}
