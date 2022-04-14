package com.example.view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class Alerts {

        public static void display(String title, String message) {
            final Stage window = new Stage();

            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(400);
            window.setHeight(150);

            Label label = new Label();
            label.setText(message);
            label.setAlignment(Pos.CENTER);
            label.setStyle("-fx-font-size: 18px ; -fx-background-color: transparent ; -fx-text-fill: white; ");

            Button closeButtom = new Button("OK");
            closeButtom.setOnAction(e -> window.close());
            closeButtom.setMinWidth(50);
            closeButtom.setMaxHeight(100);
            closeButtom.setStyle("-fx-font-size: 16px ; -fx-background-color: black ; -fx-border-radius: 5px ;" +
                                 "-fx-border-color: white ; -fx-border-width: 0.5px ; -fx-text-fill: white ;");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButtom);
            layout.setAlignment(Pos.CENTER);
            layout.setStyle("-fx-background-color: #2d343a ;");

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();

        }

}
