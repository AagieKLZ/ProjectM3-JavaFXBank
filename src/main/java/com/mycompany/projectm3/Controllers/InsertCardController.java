/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.projectm3.Cards.Card;
import com.mycompany.projectm3.App;
import com.mycompany.projectm3.Navigator;
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
public class InsertCardController implements Initializable {

    @FXML
    private Button backBtn;
    
    @FXML
    private TextField cardNumber;
    
    @FXML
    private TextField cardPIN;

    @FXML
    private Label errLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Try to log in with the given card number and PIN
     * @throws IOException if the page cannot be loaded
     */
    @FXML
    private void logIn() throws IOException {
        long cardNumber;
        try {
            cardNumber = Long.parseLong(this.cardNumber.getText());
        } catch (NumberFormatException e) {
            errLabel.setText("Número de tarjeta no válido");
            return;
        }
        Card card = App.atm.cardManager.findCard(cardNumber);
        if (card == null){
            errLabel.setText("Tarjeta no encontrada");
            return;
        }
        if (card.getPIN() != Integer.parseInt(cardPIN.getText())){
            errLabel.setText("PIN incorrecto");
            return;
        }
        User user = card.getAccount().getOwner();
        if (user.isLocked()){
            errLabel.setText("Usuario bloqueado");
            return;
        }
        App.atm.setUser(user);
        Navigator.gotoPage("MainATM", backBtn);
    }

    /**
     * Go back to the welcome page
     * @throws IOException if the page cannot be loaded
     */
    @FXML
    protected void gotoHome() throws IOException{
        Navigator.gotoPage("welcome", backBtn);
    }
    
}
