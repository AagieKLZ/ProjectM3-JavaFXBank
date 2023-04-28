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
        accType.getItems().add("Savings");
        accType.getItems().add("Current");
        createAccBtn.setDisable(true);
        accType.setOnAction((event) -> {
            String acc = accType.getValue();
            if (acc.equals("Savings")) {
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

    public void gotoHome() throws IOException {
        App.setRoot("MainATM");
    }

    public void submit() {
        String accTypeValue = accType.getValue();
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
        System.out.println("Account type: " + accTypeValue);
        System.out.println("Interest: " + interestField.getText());
        System.out.println("Create card: " + createCard);
        System.out.println("PIN: " + pin);
        System.out.println("Starting money: " + money);
        System.out.println("Create account");
        try {
            gotoHome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
