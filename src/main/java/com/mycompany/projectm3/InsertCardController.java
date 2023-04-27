/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class InsertCardController implements Initializable {

    @FXML
    private Button backBtn;
    
    @FXML
    private TextField cardNumber;
    
    @FXML
    private TextField cardPIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logIn() {
        System.out.println("Card: " + cardNumber.getText() + "\nPIN: " + cardPIN.getText());
    }

    @FXML
    protected void gotoHome() throws IOException{
        Navigator.gotoPage("welcome", backBtn);
    }
    
}
