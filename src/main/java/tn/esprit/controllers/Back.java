package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Back {
    @FXML
    private AnchorPane contentPane;

    @FXML
    private HBox logout;
    @FXML
    private void initialize() {
        // Initialiser le gestionnaire d'événements pour l'élément HBox logout
        logout.setOnMouseClicked(event -> handleLogout());
    }
    @FXML
    private void handleUsersButtonClick() {
        try {
            AnchorPane showUserPane = FXMLLoader.load(getClass().getResource("/showUser.fxml"));
            contentPane.getChildren().setAll(showUserPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        Stage stage = (Stage) logout.getScene().getWindow(); // Obtenir la fenêtre actuelle
        stage.close(); // Fermer la fenêtre actuelle (Back.fxml)

        try {
            // Charger le fichier FXML login.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
            Scene scene = new Scene(root);

            // Créer une nouvelle fenêtre pour la scène de login
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setTitle("Login");

            // Afficher la fenêtre de login
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'exception si le chargement du fichier login.fxml échoue
        }
    }
}
