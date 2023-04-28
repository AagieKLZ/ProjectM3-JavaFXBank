/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.Account.Card;
import com.mycompany.projectm3.Account.CurrentAccount;
import com.mycompany.projectm3.User.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class CreateCardController implements Initializable {

    @FXML
    TextField pinField;

    @FXML
    TextField cardField;

    @FXML
    TextField cvvField;

    @FXML
    TextField expDate;

    @FXML
    Button backBtn;

    @FXML
    Button actBtn;

    @FXML
    Label errLabel;

    @FXML
    ChoiceBox<?> accSelect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User("", "", 1);
        CurrentAccount acc = new CurrentAccount(12, 50, user);
        Card card = new Card(0, acc);
        cardField.setText(formatCardNumber(card.getCardNumber()));
        cvvField.setText(Integer.toString(card.getSecurityNumber()));
        expDate.setText(card.getExpirationDate().toString());
    }

    private String formatCardNumber(long cardNumber){
        String cardNumberStr = Long.toString(cardNumber);
        return cardNumberStr.substring(0, 4) + " " + cardNumberStr.substring(4, 8) + " " + cardNumberStr.substring(8, 12) + " " + cardNumberStr.substring(12, 16);
    }

    public void submit(){

    }

    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }
    
}
