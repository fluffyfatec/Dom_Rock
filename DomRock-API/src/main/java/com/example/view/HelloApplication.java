package com.example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Introducao.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 1200, 650);
        stage.setTitle("Sistema de Gerenciamento de Clientes - Dom Rock");
        stage.setScene(scene);
        stage.setResizable(true);
        scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Dom_Rock/main/DomRock-API/src/main/java/com/example/view/style.css");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}