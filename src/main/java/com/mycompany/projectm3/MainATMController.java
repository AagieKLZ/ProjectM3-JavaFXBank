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

    ArrayList<String> keys = new ArrayList<>();
    
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
                /**
                if (keys.get(0) == "UP" && keys.get(1) == "LEFT" && keys.get(2) == "DOWN" && keys.get(3) == "RIGHT"){
                    System.out.println("You have unlocked the secret menu");
                }*/
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

    public void signOut() throws IOException{
        App.atm.setUser(null);
        Navigator.gotoPage("welcome", logoutBtn);
    }
    
}
