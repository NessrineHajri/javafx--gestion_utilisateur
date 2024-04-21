package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tn.esprit.services.ServiceUser;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;
import java.sql.SQLException;

public class login {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Pane loginPane;

    private ServiceUser userService;


    public login() {
        userService = new ServiceUser(); // Initialise ServiceUser
    }

    @FXML
    public void loginButton2() {
        try {
            String email = emailField.getText().trim();
            String password = passwordField.getText();

            boolean userExists = userService.authenticateUser(email, password);

            if (userExists) {
                redirectToBackInterface();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid credentials. Please try again.");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to authenticate user: " + e.getMessage());
        }
    }

    private void redirectToBackInterface() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SSMain.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) loginPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load Back interface: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private void handleRegisterClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/signUp.fxml"));
        Parent root = loader.load();

        // Access the controller of the loaded FXML (if needed)
        signUp signUpController = loader.getController();

        // Replace the current content with the loaded FXML content
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
/*
    @FXML
    private void logoutClick() {
        try {
            // Charger le fichier FXML de la page de connexion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Obtenir la fenêtre actuelle à partir de l'événement MouseEvent
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Réinitialiser la session ou les données de l'utilisateur s'il y en a
            // Exemple : currentUser = null; (si currentUser est votre objet de session)

            // Changer la scène pour afficher la page de connexion
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Échec du chargement de l'interface de connexion : " + e.getMessage());
        }
    }

*/

}
