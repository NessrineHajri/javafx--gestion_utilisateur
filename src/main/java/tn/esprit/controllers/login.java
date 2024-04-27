package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.services.ServiceUser;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;
import java.io.InputStream;
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


    @FXML
    private void handleForgotPasswordClick(ActionEvent event) {
        try {
            // Load the FXML file using getResourceAsStream
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ForgotPassword.fxml"));
            Parent root = loader.load();

            // Access the controller of the loaded FXML (if needed)
            ForgotPassword forgotPassword = loader.getController();

            // Create a new stage for the ForgotPassword window
            Stage forgotPasswordStage = new Stage();
            forgotPasswordStage.setScene(new Scene(root));
            forgotPasswordStage.setTitle("Forgot Password");

            // Set modality to APPLICATION_MODAL to make the window modal
            forgotPasswordStage.initModality(Modality.APPLICATION_MODAL);

            // Show the ForgotPassword window and wait for it to be closed
            forgotPasswordStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error dialog)
        }
    }

}
