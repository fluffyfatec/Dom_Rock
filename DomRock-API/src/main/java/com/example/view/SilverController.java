package com.example.view;

import DTO.ValidadorDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SilverController {
	
	   @FXML
	    private TextArea txtValidador;
	
    @FXML
    void btnLimparSilver(ActionEvent event) {

    }


   ValidadorDTO objValidadorDTO = new ValidadorDTO();

    @FXML
    void btnCadastrarsilver(ActionEvent event) {
        String validadorSilver = this.txtValidador.getText();


        objValidadorDTO.setValidadores(validadorSilver);
        System.out.println(objValidadorDTO.getValidadores());
        
        
    }
}
