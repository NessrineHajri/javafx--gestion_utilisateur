package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tn.esprit.API.EmailAPI;

public class ForgotPassword {
/*
    @FXML
    private TextField emailField;

    public void generateVerificationCode() {
        // Get the email address from the text field
        String emailAddress = emailField.getText();

        // Send the email with the OTP code
        EmailAPI.sendEmailVerification(emailAddress);

        // Display a message to indicate that the email is sent
        System.out.println("Email sent to " + emailAddress);
    }
*/

        @FXML
        private TextField emailField;

        public void generateVerificationCode() {
            // Get the email address from the text field
            String emailAddress = emailField.getText();

            // Send the email with the OTP code
            String otp = EmailAPI.generateRandomCode(6); // Utilisation de la méthode de génération de code OTP
            EmailAPI.sendEmailWithOTP(emailAddress, otp);

            // Display a message to indicate that the email is sent
            System.out.println("Email sent to " + emailAddress + " with OTP code: " + otp);
        }



}
