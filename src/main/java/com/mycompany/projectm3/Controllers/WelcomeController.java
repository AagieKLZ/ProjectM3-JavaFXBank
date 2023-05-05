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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class WelcomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Loads the fxml file and sets the scene
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Goes to the login page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    protected void gotoLogin() throws IOException{
        Navigator.gotoPage("LogIn", loginLink);
    }

    /**
     * Goes to the signup page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    protected void gotoSignup() throws IOException{
        Navigator.gotoPage("SignUp", signupLink);
    }

    /**
     * Goes to the login with card page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    protected void gotoCard() throws IOException{
        Navigator.gotoPage("InsertCard", cardLink);
    }

    @FXML
    Button loginLink;
    
    @FXML
    Button signupLink;
    
    @FXML
    Button cardLink;
    
}
