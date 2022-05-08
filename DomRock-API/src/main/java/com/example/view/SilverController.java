package com.example.view;

import java.io.IOException;

import DTO.ValidadorDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
