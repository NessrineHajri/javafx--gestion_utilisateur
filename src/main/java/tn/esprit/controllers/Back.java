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
            Stage mainStage = new Stage();
            mainStage.setScene(scene);
            mainStage.setTitle("Login");
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleProfile() {
        try {
            // Charger le fichier FXML editProfile.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/editProfile.fxml"));
            Scene scene = new Scene(root);

            // Créer une nouvelle fenêtre pour la scène d'édition de profil
            Stage editProfileStage = new Stage();
            editProfileStage.setScene(scene);
            editProfileStage.setTitle("Profile");

            // Afficher la fenêtre d'édition de profil
            editProfileStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'exception si le chargement du fichier editProfile.fxml échoue
        }
    }



}
