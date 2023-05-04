/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.User.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML
    Button backBtn;
    
    @FXML
    Button signupBtn;

    @FXML
    Label errLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Logs in the user
     * @throws IOException if the fxml file is not found
     */
    @FXML
    public void logIn() throws IOException{
        System.out.println("Log in");
        System.out.println("Username: " + username.getText());
        System.out.println("Password: " + password.getText());
        if (App.atm.userManager.getAttempts(username.getText()) <= 0){
            errLabel.setText("Usuario bloqueado");
            return;
        }
        if (username.getText().equals("") || username.getText().equals("")){
            errLabel.setText("Usuario o contraseña no válidos");
        } else {
            User user = App.atm.userManager.LogIn(username.getText(), password.getText());
            if (user == null){
                errLabel.setText("Usuario o contraseña no válidos");
                return;
            }
            if (user.isLocked()){
                errLabel.setText("Usuario bloqueado");
                return;
            }

            ArrayList<Account> accounts = App.atm.accManager.getAccountList();
            ArrayList<Account> userAccounts = new ArrayList<>();
            System.out.println("User ID: " + user.getId());
            for (Account account : accounts) {
                System.out.println("Account owner ID: " + account.getOwnerId());
                if (account.getOwnerId() == user.getId()){
                    userAccounts.add(account);
                }
            }
            user.setAccounts(userAccounts);
            App.atm.setUser(user);
            Navigator.gotoPage("MainATM", signupBtn);
        }
    }

    /**
     * Goes back to the welcome page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    protected void gotoHome() throws IOException{
        Navigator.gotoPage("welcome", backBtn);
    }

    /**
     * Goes to the sign up page
     * @throws IOException if the fxml file is not found
     */
    @FXML
    protected void gotoSignup() throws IOException{
        Navigator.gotoPage("SignUp", signupBtn);
    }
    
}
