package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tn.esprit.entities.User;
import tn.esprit.services.IServices;
import tn.esprit.services.ServiceUser;

import java.sql.SQLException;

public class editUser {
    @FXML
    private TextField usernameId;

    @FXML
    private TextField emailId;

    @FXML
    private TextField passwordId;

    @FXML
    private ComboBox<String> roleId;

    @FXML
    private CheckBox isVerifiedId;

    private User currentUser; // User to edit
    private IServices<User> userService; // Service for user operations

    public editUser() {
        userService = new ServiceUser(); // Initialize user service
    }

    public void initData(User user) {
        currentUser = user; // Set the user to edit
        // Display user data in the form fields
        usernameId.setText(user.getUsername());
        emailId.setText(user.getEmail());
        passwordId.setText(user.getPassword());
        roleId.setValue(user.getRoles());
        isVerifiedId.setSelected(user.getIs_verified()); // Assuming isVerified is a boolean in User class
    }

    @FXML
    public void updateUser() {
        try {
            // Update user data with form values
            currentUser.setUsername(usernameId.getText());
            currentUser.setEmail(emailId.getText());
            currentUser.setPassword(passwordId.getText());
            currentUser.setRoles(roleId.getValue());
            currentUser.setIs_verified(isVerifiedId.isSelected()); // Assuming setVerified is the correct method

            // Update user in the database
            userService.update(currentUser);

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "User updated successfully.");

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to update user: " + e.getMessage());
        }
    }

    public void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void setUser(User user) {
        this.currentUser = user; // Fixed the assignment to currentUser
        // Set the user data to the corresponding fields
        if (user != null) {
            usernameId.setText(user.getUsername());
            emailId.setText(user.getEmail());
            passwordId.setText(user.getPassword()); // Assuming password is also needed
            roleId.setValue(user.getRoles());
            isVerifiedId.setSelected(user.getIs_verified()); // Assuming isVerified is a boolean in User class
        }
    }
}
