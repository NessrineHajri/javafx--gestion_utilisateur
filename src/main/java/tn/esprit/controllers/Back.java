package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Back {
    @FXML
    private AnchorPane contentPane;

    @FXML
    private void handleUsersButtonClick() {
        try {
            AnchorPane showUserPane = FXMLLoader.load(getClass().getResource("/showUser.fxml"));
            contentPane.getChildren().setAll(showUserPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
