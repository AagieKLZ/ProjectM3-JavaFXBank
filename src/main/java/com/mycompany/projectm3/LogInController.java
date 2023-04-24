/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class LogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField username;
    
    @FXML
    TextField password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void logIn(){
        System.out.println("Log in");
        System.out.println("Username: " + username.getText());
        System.out.println("Password: " + password.getText());
    }
    
}
