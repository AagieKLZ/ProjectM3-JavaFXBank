/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
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
    ChoiceBox<Long> accSelect;

    Card card;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = App.atm.getUser();
        ArrayList<Account> accounts = user.getAccounts();
        for (Account acc : accounts){
            if (acc instanceof CurrentAccount){
                accSelect.getItems().add(acc.getAccNumber());
            }
        }
        CurrentAccount acc = new CurrentAccount(0, 0, user);
        Card card = App.atm.cardManager.createCard(0, acc);
        this.card = card;
        cardField.setText(formatCardNumber(card.getCardNumber()));
        cvvField.setText(Integer.toString(card.getSecurityNumber()));
        expDate.setText(card.getExpirationDate().toString());
    }

    private String formatCardNumber(long cardNumber){
        String cardNumberStr = Long.toString(cardNumber);
        return cardNumberStr.substring(0, 4) + " " + cardNumberStr.substring(4, 8) + " " + cardNumberStr.substring(8, 12) + " " + cardNumberStr.substring(12, 16);
    }

    public void submit() throws IOException{
        if (pinField.getText().length() == 4 && accSelect.getValue() != null){
            this.card.setPIN(Integer.parseInt(pinField.getText()));
            this.card.setAccount((CurrentAccount) App.atm.accManager.getAccountById((Long.parseLong(accSelect.getValue().toString()))));
            ((CurrentAccount) App.atm.accManager.getAccountById((Long.parseLong(accSelect.getValue().toString())))).addCard(this.card);
            Navigator.gotoPage("MainATM", backBtn);
        }

    }

    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }
    
}
