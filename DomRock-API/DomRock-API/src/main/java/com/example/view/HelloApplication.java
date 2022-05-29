package com.example.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/Login.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 367,297);
        stage.setTitle("Login - Dom Rock");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.getIcons().add(new Image("https://raw.githubusercontent.com/fluffyfatec/Front-/main/domrock.png"));
        scene.getStylesheets().add("https://raw.githubusercontent.com/fluffyfatec/Front-/main/Styles.css");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}