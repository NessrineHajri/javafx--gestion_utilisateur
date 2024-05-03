package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
    private Label Username;

    @FXML
    private TextField Role_field;


    @FXML
    private ComboBox<String> roleComboBox;

    private User currentUser;
    private IServices<User> userService;

    public profile() {
        userService = new ServiceUser();
    }

    @FXML
    void initialize() {

        User x = SessionManager.getCurrentUser();
       /*
        if (x != null) {
            Username.setText("Connected as: " + x.getUsername());}

         */
        displayUserData();

    }


    private void displayUserData() {
        User x = SessionManager.getCurrentUser();
        if (x != null) {
            System.out.println(x.getRoles());
            usernameField.setText(x.getUsername());
            emailField.setText(x.getEmail());
            Role_field.setText(x.getRoles());
        }
    }


}
