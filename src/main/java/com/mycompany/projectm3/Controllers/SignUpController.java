/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.projectm3.App;
import com.mycompany.projectm3.Navigator;
import com.mycompany.projectm3.User.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author alumne
 */
public class SignUpController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField emailInput;
    @FXML
    private PasswordField pwInput;
    @FXML
    private Button signupBtn;
    @FXML
    private Button loginBtn;

    @FXML
    Label errLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Goes to the home page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    private void gotoHome() throws IOException {
        Navigator.gotoPage("welcome", backBtn);
    }

    /**
     * Goes to the login page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    private void gotoLogin() throws IOException {
        Navigator.gotoPage("LogIn", loginBtn);
    }

    /**
     * Signs up the user
     * @throws IOException if the fxml file is not found
     */
    @FXML
    private void signUp() throws IOException{
        String name = nameInput.getText();
        String email = emailInput.getText();
        String pw = pwInput.getText();
        if (name.equals("") || email.equals("") || pw.equals("")){
            errLabel.setText("Todos los campos son obligatorios");
        } else {
            errLabel.setText("");
            if (App.atm.userManager.findUser(email)) {
                errLabel.setText("Ya existe un usuario con ese email");
                return;
            }
            User user = App.atm.userManager.createUser(email, name, pw);
            App.atm.setUser(user);
            Navigator.gotoPage("MainATM", signupBtn);
        }
    }

}
