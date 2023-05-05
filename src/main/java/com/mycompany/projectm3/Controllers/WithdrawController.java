/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.App;
import com.mycompany.projectm3.Navigator;
import com.mycompany.projectm3.Operation.Operation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class WithdrawController implements Initializable {

    @FXML
    private ChoiceBox<Long> accSelect;
    @FXML
    private Label availableLabel;
    @FXML
    private Label errLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Button createAccBtn;

    @FXML
    Spinner<Integer> field10;

    @FXML
    Spinner<Integer> field20;

    @FXML
    Spinner<Integer> field50;

    @FXML
    Spinner<Integer> field100;

    @FXML
    Spinner<Integer> field200;

    @FXML
    Label balanceLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Account acc : App.atm.getUser().getAccounts()){
            accSelect.getItems().add(acc.getAccNumber());
        }

        SpinnerValueFactory<Integer> valueFactory10 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, App.atm.billManager.getBills(10), 0, 1);
        SpinnerValueFactory<Integer> valueFactory20 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, App.atm.billManager.getBills(20), 0, 1);
        SpinnerValueFactory<Integer> valueFactory50 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, App.atm.billManager.getBills(50), 0, 1);
        SpinnerValueFactory<Integer> valueFactory100 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, App.atm.billManager.getBills(100), 0, 1);
        SpinnerValueFactory<Integer> valueFactory200 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, App.atm.billManager.getBills(200), 0, 1);

        valueFactory10.valueProperty().addListener((observable, oldValue, newValue) -> updateBalance());
        valueFactory20.valueProperty().addListener((observable, oldValue, newValue) -> updateBalance());
        valueFactory50.valueProperty().addListener((observable, oldValue, newValue) -> updateBalance());
        valueFactory100.valueProperty().addListener((observable, oldValue, newValue) -> updateBalance());
        valueFactory200.valueProperty().addListener((observable, oldValue, newValue) -> updateBalance());

        field10.setValueFactory(valueFactory10);
        field20.setValueFactory(valueFactory20);
        field50.setValueFactory(valueFactory50);
        field100.setValueFactory(valueFactory100);
        field200.setValueFactory(valueFactory200);

        field10.getValueFactory().setValue(0);
        field20.getValueFactory().setValue(0);
        field50.getValueFactory().setValue(0);
        field100.getValueFactory().setValue(0);
        field200.getValueFactory().setValue(0);
    }

    /**
     * Goes to the home page
     * @throws IOException if the fxml file is not found
     */
    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }

    /**
     * Updates the balance label when the user changes the value of the spinners
     * @return the balance
     */
    private int updateBalance(){
        int balance = field10.getValue() * 10 + field20.getValue() * 20 + field50.getValue() * 50 + field100.getValue() * 100 + field200.getValue() * 200;
        balanceLabel.setText(String.valueOf(balance) + "€");
        return balance;
    }

    /**
     * Submits the withdraw
     * @throws IOException if the fxml file is not found
     */
    public void submit() throws IOException {
        if (balanceLabel.getText().equals("0€")){
            errLabel.setText("La cantidad no puede ser 0");
            return;
        } else if (accSelect.getValue() == null){
            errLabel.setText("Selecciona una cuenta");
            return;
        } else if (updateBalance() > App.atm.accManager.getAccountById(accSelect.getValue()).getBalance()){
            errLabel.setText("No tienes suficiente dinero");
            return;
        }
        Account acc = App.atm.accManager.getAccountById(accSelect.getValue());
        Operation opp = App.atm.oppManager.createOperation("withdraw", acc, null, updateBalance());
//        App.atm.accManager.getAccountById(accSelect.getValue()).addOperation(opp);
        App.atm.accManager.getAccountById(accSelect.getValue()).extractMoney(updateBalance());
        HashMap<Integer, Integer> bills = new HashMap<>();
        bills.put(10, field10.getValue());
        bills.put(20, field20.getValue());
        bills.put(50, field50.getValue());
        bills.put(100, field100.getValue());
        bills.put(200, field200.getValue());
        App.atm.billManager.extractBills(bills);
        Navigator.gotoPage("MainATM", backBtn);
    }

}
