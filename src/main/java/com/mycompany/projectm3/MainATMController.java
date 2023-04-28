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

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class MainATMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button checkMovements;
    
    @FXML
    Button checkAccs;
    
    @FXML
    Button createAcc;
    
    @FXML
    Button withdrawBtn;
    
    @FXML
    Button insertBtn;
    
    @FXML
    Button createCard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void gotoMovements() throws IOException {
        Navigator.gotoPage("Movements", checkMovements);
    }
    
    public void gotoCreateAccount() throws IOException {
        Navigator.gotoPage("NewAccount", createAcc);
    }
    
    public void gotoAccounts() throws IOException{
        Navigator.gotoPage("Accounts", checkAccs);
    }
    
    public void gotoCreateCard() throws IOException {
        Navigator.gotoPage("CreateCard", createCard);
    }
    
    public void gotoWithdraw() throws IOException {
        Navigator.gotoPage("Withdraw", withdrawBtn);
    }
    
    public void gotoInsert() throws IOException {
        Navigator.gotoPage("Insert", insertBtn);
    }

    public void gotoTransfer() throws IOException {
        Navigator.gotoPage("Transfer", insertBtn);
    }
    
}
