/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void gotoHome() throws IOException {
        Navigator.gotoPage("welcome", backBtn);
    }

    @FXML
    private void gotoLogin() throws IOException {
        Navigator.gotoPage("LogIn", loginBtn);
    }

}
