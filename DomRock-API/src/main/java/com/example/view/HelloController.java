package com.example.view;

import DTO.ClienteDTO;
import DTO.EntregavelDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Tab geral;

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

    @FXML
    private void btnCadastrar(ActionEvent event) {
        String nomeCliente = this.txtNome.getText();
        String cnpjCliente = this.txtCnpj.getText();
        String objCliente = this.txtObjNegocio.getText();
        String eMinimos = this.txtePossiveis.getText();
        String ePossiveis = this.txtePossiveis.getText();

// Metodos acessores do clienteDTO
        ClienteDTO objclienteDTO = new ClienteDTO();
        objclienteDTO.setCnpj(cnpjCliente);
        objclienteDTO.setNomeCliente(nomeCliente);
        objclienteDTO.setEntregaMin(eMinimos);
        objclienteDTO.setEntregaPossivel(ePossiveis);
        objclienteDTO.setObjetivoNegocio(objCliente);


// Metodos acessores do entregavelDTO
        EntregavelDTO objentregavelDTO = new EntregavelDTO();
        objentregavelDTO.setEntregaMin(eMinimos);
        objentregavelDTO.setEntregaPossivel(ePossiveis);
        objentregavelDTO.setObjetivoNegocio(objCliente);


    }


}
