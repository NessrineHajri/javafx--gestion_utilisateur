package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import tn.esprit.entities.User;
import tn.esprit.services.ServiceUser;

public class signUp {

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private Button signupButton;

    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private TextField usernameField;

    private ServiceUser userService; // Assuming you have a ServiceUser class for user operations

    @FXML
    public void initialize() {
        userService = new ServiceUser(); // Initialize the ServiceUser instance
    }

    @FXML
    public void validateInfo() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String selectedRole = roleComboBox.getValue();
/*
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || selectedRole == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter your username.");
            return;
        }
*/
        if (username.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter your username.");
            return;
        }


        if (email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter your email address.");
            return;
        } else if (!email.contains("@")) {
            showAlert(Alert.AlertType.ERROR, "Error", "Email address must contain '@'.");
            return;
        }

        if (password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter your password.");
            return;
        }

        if (password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please confirm your password.");
            return;
        }

        if (!termsCheckBox.isSelected()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please accept the terms and conditions.");
            return;
        }

        // Check if user with the provided email already exists
        try {
            if (userService.userExists(email)) {
                showAlert(Alert.AlertType.ERROR, "Error", "User with email " + email + " already exists.");
                return;
            }

            // Create a new User object and set its properties
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRoles(getRoleValue(selectedRole)); // Get the role value based on the selected role

            userService.add(user); // Add the user using the ServiceUser instance

            showAlert(Alert.AlertType.CONFIRMATION, "Success", "User registered successfully.");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to register user: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String getRoleValue(String selectedRole) {
        switch (selectedRole) {
            case "Administrateur":
                return "[\"ROLE_ADMIN\"]";
            case "Recruteur":
                return "[\"ROLE_RECRUTEUR\"]";
            case "Freelancer":
                return "[\"ROLE_FREELANCER\"]";
            default:
                return ""; // Handle other cases accordingly
        }
    }
}