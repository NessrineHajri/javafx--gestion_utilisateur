package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tn.esprit.utils.MyDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signUp {

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private Pane loginPane;

    @FXML
    private VBox loginVBox;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private Button signupButton;

    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private TextField usernameField;

    private Connection cnx; // Assuming MyConnection.getInstance().getCnx() returns a Connection

    @FXML
    public void signUp() {
        cnx = MyDB.getInstance().getCon();
        String query = "INSERT INTO user (cin, user_name, numero, email, adresse, password)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            if (usernameField.getText().isEmpty()
                    || emailField.getText().isEmpty()
                    || passwordField.getText().isEmpty()
                    || confirmPasswordField.getText().isEmpty()
                    || roleComboBox.getSelectionModel().isEmpty()
                    || !termsCheckBox.isSelected()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Travel Me :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Enter all required fields!!");
                alert.showAndWait();
            } else if (confirmPasswordField.getText().length() < 8 || !confirmPasswordField.getText().equals(passwordField.getText())) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Travel Me :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password should be at least 8 characters long and match the confirmation!");
                alert.showAndWait();
            } else {
                if (ValidationEmail()) {
                    PreparedStatement smt = cnx.prepareStatement(query);

                    // Assuming these fields are defined elsewhere
                    // smt.setString(1, cin.getText());
                    // smt.setString(2, username.getText());
                    // smt.setString(3, numero.getText());
                    smt.setString(4, emailField.getText());
                    // smt.setString(5, adresse.getText());
                    smt.setString(6, passwordField.getText());
                    smt.executeUpdate();

                    System.out.println("Successfully added");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Travel Me :: Welcome");
                    alert.setHeaderText(null);
                    alert.setContentText("You are registered!");
                    alert.showAndWait();

                    loginPane.setVisible(true);
                    loginVBox.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Placeholder for ValidationEmail() method
    private boolean ValidationEmail() {
        // Your email validation logic here
        return true; // Placeholder return value
    }
}
