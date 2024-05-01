package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tn.esprit.entities.User;
import tn.esprit.services.IServices;
import tn.esprit.services.ServiceUser;

import java.sql.SQLException;

public class profile {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private ComboBox<String> roleComboBox;

    private User currentUser;
    private IServices<User> userService;

    public profile() {
        userService = new ServiceUser();
    }

    public void initData(User user) {
        currentUser = user;
        displayUserData();
    }

    private void displayUserData() {
        if (currentUser != null) {
            usernameField.setText(currentUser.getUsername());
            emailField.setText(currentUser.getEmail());
            roleComboBox.setValue(currentUser.getRoles());
        }
    }

    @FXML
    private void handleModify() {
        // Logique pour la modification des informations utilisateur
    }

    @FXML
    private void deleteAccount() {
        // Logique pour la suppression du compte utilisateur
    }

    @FXML
    private void changeProfilePicture() {
        // Logique pour changer la photo de profil
    }
}
