/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    AnchorPane rootPane;

    @FXML
    Label welcomeLabel;

    @FXML
    Button logoutBtn;

    @FXML
    Button profileBtn;

    ArrayList<String> keys = new ArrayList<>();

    /**
     * Initializes the controller class. Defines the controls to open the secret menu
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        welcomeLabel.setText("Welcome, " + App.atm.getUser().getName());
        rootPane.setOnKeyPressed(e -> {
            ArrayList<String> keysArray = new ArrayList<>();
            keysArray.add("UP");
            keysArray.add("LEFT");
            keysArray.add("DOWN");
            keysArray.add("RIGHT");
            keys.add(e.getCode().toString());
            if (keys.size() > 4) {
                keys.remove(0);
                if (keysArray.equals(keys)){
                    System.out.println("You have unlocked the secret menu");
                    try {
                        Navigator.gotoPage("SecretMenu", rootPane);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    /**
     * Goes to the movements page
     * @throws IOException if the fxml file is not found
     */
    public void gotoMovements() throws IOException {
        Navigator.gotoPage("Movements", checkMovements);
    }

    /**
     * Goes to the create account page
     * @throws IOException if the fxml file is not found
     */
    public void gotoCreateAccount() throws IOException {
        Navigator.gotoPage("NewAccount", createAcc);
    }

    /**
     * Goes to the accounts page
     * @throws IOException if the fxml file is not found
     */
    public void gotoAccounts() throws IOException{
        Navigator.gotoPage("Accounts", checkAccs);
    }

    /**
     * Goes to the create card page
     * @throws IOException if the fxml file is not found
     */
    public void gotoCreateCard() throws IOException {
        Navigator.gotoPage("CreateCard", createCard);
    }

    /**
     * Goes to the withdraw page
     * @throws IOException if the fxml file is not found
     */
    public void gotoWithdraw() throws IOException {
        Navigator.gotoPage("Withdraw", withdrawBtn);
    }

    /**
     * Goes to the insert page
     * @throws IOException if the fxml file is not found
     */
    public void gotoInsert() throws IOException {
        Navigator.gotoPage("Insert", insertBtn);
    }

    /**
     * Goes to the transfer page
     * @throws IOException if the fxml file is not found
     */
    public void gotoTransfer() throws IOException {
        Navigator.gotoPage("Transfer", insertBtn);
    }

    /**
     * Signs out the user and returns to the welcome page
     * @throws IOException if the fxml file is not found
     */
    public void signOut() throws IOException{
        App.atm.setUser(null);
        Navigator.gotoPage("welcome", logoutBtn);
    }

    /**
     * Goes to the profile page
     * @throws IOException if the fxml file is not found
     */
    public void gotoProfile() throws IOException{
        Navigator.gotoPage("Profile", profileBtn);
    }
    
}
