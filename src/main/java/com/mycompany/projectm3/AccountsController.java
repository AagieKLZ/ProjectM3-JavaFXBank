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
import com.mycompany.projectm3.Account.SavingAccount;
import com.mycompany.projectm3.Operation.Operation;
import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.lib.RandomNumberGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class AccountsController implements Initializable {

    @FXML
    Label balanceLabel;

    @FXML
    VBox accPanel;

    @FXML
    HBox cardPanel;

    @FXML
    VBox operationPanel;

    @FXML
    Button backBtn;


    Account selectedAcc;

    float total = 0.0f;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.selectedAcc = null;

        balanceLabel.setText("14.52€");
        User user = new User("abc", "123", 5);
        SavingAccount acc = new SavingAccount(1, 12, user);
        CurrentAccount acc2 = new CurrentAccount(1, 12, user);
        ArrayList<Account> accList = App.atm.getUser().getAccounts();

        Label defaultCard = new Label("Selecciona una cuenta");
        cardPanel.getChildren().add(defaultCard);
        for (Account account : accList) {
            VBox accBox = createAccBox(account);
            accPanel.getChildren().add(accBox);
            balanceLabel.setText(String.valueOf(total += account.getBalance()) + "€");
        }
        String selectedColor="#decf00";
    }

    private VBox createAccBox(Account acc){
        String accType = acc instanceof SavingAccount ? "Ahorro" : "Corriente";
        long accNumber = acc.getAccNumber();
        VBox accBox = new VBox();
        accBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web(accType.equals("Ahorro") ? "#001370" : "#0223c7"), new CornerRadii(5), null)));
        accBox.setPrefWidth(200);
        accBox.setPrefHeight(100);
        accBox.setSpacing(40);
        accBox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        accBox.setId(String.valueOf(accNumber));
        Label accNumberLabel = new Label(formatAccNumber(String.valueOf(accNumber)));
        Label accTypeLabel = new Label(accType);
        accNumberLabel.setTextFill(Paint.valueOf("#ffffff"));
        accTypeLabel.setTextFill(Paint.valueOf("#ffffff"));
        accBox.getChildren().add(accNumberLabel);
        accBox.getChildren().add(accTypeLabel);

        accBox.setOnMouseClicked(e -> {

            if (selectedAcc != null) {
                VBox selectedBox = (VBox) accPanel.lookup("#" + selectedAcc.getAccNumber());
                selectedBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web(selectedAcc instanceof SavingAccount ? "#001370" : "#0223c7"), new CornerRadii(5), null)));
                for (Node child : selectedBox.getChildren()) {
                    ((Label) child).setTextFill(Paint.valueOf("#ffffff"));
                }
            }
            balanceLabel.setText(String.valueOf(acc.getBalance()) + "€");
            accBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#decf00"), new CornerRadii(5), null)));
            for (Node child : accBox.getChildren()) {
                ((Label) child).setTextFill(Paint.valueOf("black"));
            }
            selectedAcc = acc;
            cardPanel.getChildren().clear();
            if (acc instanceof SavingAccount){
                cardPanel.getChildren().add(new Label("Esta cuenta no admite tarjetas"));
            } else if (acc instanceof CurrentAccount) {
                CurrentAccount currentAcc = (CurrentAccount) acc;
                ArrayList<Card> cards = currentAcc.getCards();
                //cards.add(new Card(1234, currentAcc));
                for (Card card : cards) {
                    VBox cardBox = createCardBox(card);
                    cardPanel.getChildren().add(cardBox);
                }
            }
            ArrayList<Operation> operations = acc.getOperations();
            operationPanel.getChildren().clear();
            for (Operation opp : operations){
                HBox oppLine = createOppBox(opp);
                operationPanel.getChildren().add(oppLine);
            }
        });

        return accBox;
    }

    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }

    private VBox createCardBox(Card card){
        VBox cardBox = new VBox();
        cardBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#001370"), new CornerRadii(5), null)));
        String cardNumber = String.valueOf(card.getCardNumber());
        Label cardLabel = new Label("**** " + cardNumber.substring(cardNumber.length() - 4));
        cardLabel.setTextFill(Paint.valueOf("white"));
        cardBox.getChildren().add(cardLabel);
        cardBox.setPrefWidth(100);
        cardBox.setPrefHeight(35);
        cardBox.setAlignment(javafx.geometry.Pos.CENTER);
        return cardBox;
    }

    private HBox createOppBox(Operation opp){
        HBox oppLine = new HBox();
        Label oppType = new Label(opp.getOppType().equals("transfer") ? "Transferencia" : (opp.getOppType().equals("withdraw") ? "Extracción" : "Ingreso"));
        Label amount;
        if (opp.getSource() == null && opp.getTarget().equals(selectedAcc)){
            amount = new Label("+" + String.valueOf(opp.getAmount()) + "€");
        } else if (opp.getTarget() == null && opp.getSource().equals(selectedAcc) ){
            amount = new Label("-" + String.valueOf(opp.getAmount()) + "€");
        } else {
            amount = new Label((opp.getSource().equals(selectedAcc) ? "-" : "+") + String.valueOf(opp.getAmount()) + "€");
        }
        oppType.setPrefSize(150, 50);
        oppType.setAlignment(Pos.CENTER_LEFT);
        amount.setPrefSize(150, 50);
        amount.setAlignment(Pos.CENTER_RIGHT);
        oppLine.setSpacing(25);
        oppLine.setPrefHeight(50);
        oppLine.setPrefHeight(50);
        oppLine.getChildren().add(oppType);
        oppLine.getChildren().add(amount);
        oppLine.setPadding(new javafx.geometry.Insets(0, 10, 0, 10));
        oppLine.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0;");
        return oppLine;
    }

    private String formatAccNumber(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if ((i + 1) % 4 == 0 && i < input.length() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}


