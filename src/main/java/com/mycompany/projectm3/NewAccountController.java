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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class NewAccountController implements Initializable {


    @FXML
    private ChoiceBox<String> accType;
    @FXML
    private TextField interestField;
    @FXML
    private CheckBox addStartingCard;
    @FXML
    private CheckBox addStartingMoney;
    @FXML
    private Button backBtn;
    @FXML
    private Button createAccBtn;

    @FXML
    private TextField moneyField;

    @FXML
    private TextField pinField;

    @FXML
    private Pane PINInput;

    @FXML
    private Pane moneyInput;

    @FXML
    private Label PINErr;

    @FXML
    private Label moneyErr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accType.getItems().add("Ahorro");
        accType.getItems().add("Corriente");
        createAccBtn.setDisable(true);
        accType.setOnAction((event) -> {
            String acc = accType.getValue();
            if (acc.equals("Ahorro")) {
                interestField.setText("5%");
                addStartingCard.setDisable(true);
                addStartingCard.setSelected(false);
                PINInput.setVisible(false);
            } else {
                interestField.setText("0%");
                addStartingCard.setDisable(false);

            }
            createAccBtn.setDisable(false);
        });

        addStartingCard.setOnAction((event) -> {
            PINInput.setVisible(addStartingCard.isSelected());
        });

        addStartingMoney.setOnAction((event) -> {
            moneyInput.setVisible(addStartingMoney.isSelected());
        });
        moneyInput.setVisible(false);
        PINInput.setVisible(false);
    }

    /**
     * Goes to the home page
     * @throws IOException if the fxml file is not found
     */
    public void gotoHome() throws IOException {
        App.setRoot("MainATM");
    }

    /**
     * Creates a new account
     */
    public void submit() {
        String accTypeValue = accType.getValue();
        if (accTypeValue == null) {
            PINErr.setText("Selecciona un tipo de cuenta");
            return;
        }
        int pin = 0;
        double money = 0;
        boolean createCard = false;
        if (addStartingCard.isSelected()) {
            createCard = true;
            if (pinField.getText().length() != 4) {
                PINErr.setText("El PIN debe tener 4 dígitos");
                return;
            } else {
                try {
                    pin = Integer.parseInt(pinField.getText());
                    PINErr.setText("");
                } catch (NumberFormatException e) {
                    PINErr.setText("El PIN debe ser un número");
                    return;
                }
            }
        }
        if (addStartingMoney.isSelected()) {
            try {
                money = Double.parseDouble(moneyField.getText());
                if (money <= 0){
                    moneyErr.setText("La cantidad inicial debe ser positiva");
                    return;
                }
                moneyErr.setText("");
            } catch (NumberFormatException e) {
                moneyErr.setText("La cantidad inicial debe ser un número");
                return;
            }
        }
        Account acc = App.atm.accManager.createAccount(accTypeValue == "Ahorro" ? "Savings" : "Current", App.atm.getUser());
        if (createCard && acc instanceof CurrentAccount) {
            Card card = App.atm.cardManager.createCard(pin, (CurrentAccount) acc);
            card.setAccount((CurrentAccount) acc);
            App.atm.cardManager.addCard(card);
            App.atm.cardManager.saveCards();
        }
        if (addStartingMoney.isSelected()) {
            acc.addMoney((float) money);
        }
        App.atm.accManager.assign(acc, App.atm.getUser());
        try {
            gotoHome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
