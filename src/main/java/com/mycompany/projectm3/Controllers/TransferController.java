/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.App;
import com.mycompany.projectm3.Navigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author alumne
 */
public class TransferController implements Initializable {


    @FXML
    private ChoiceBox<Long> accSelect;
    @FXML
    private TextField targetAccNum;
    @FXML
    private TextField targetName;
    @FXML
    private TextField moneyField;
    @FXML
    private Label moneySq;
    @FXML
    private Label errLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Button actBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Account acc : App.atm.getUser().getAccounts()){
            if (acc.getAccType() == "Current") {
                accSelect.getItems().add(acc.getAccNumber());
            }
        }
    }

    /**
     * Goes to the home page
     * @throws IOException if the fxml file is not found
     */
    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }

    /**
     * Submits the form and executes the transfer
     * @throws IOException if the fxml file is not found
     */
    public void submit() throws IOException{
        Account target = null;
        try {
            target = App.atm.accManager.getAccountById(Long.parseLong(targetAccNum.getText()));
        } catch (Exception e){
            errLabel.setText("La cuenta no existe");
            return;
        }
        if (accSelect.getValue() == null){
            errLabel.setText("Selecciona una cuenta");
            return;
        }
        Account source = App.atm.accManager.getAccountById(accSelect.getValue());
        if (target == null){
            errLabel.setText("La cuenta no existe");
            return;
        }
        if (!target.getOwner().getName().equals(targetName.getText())){
            errLabel.setText("El nombre no coincide");
            return;
        }
        if (target.getAccNumber() == accSelect.getValue()){
            errLabel.setText("No puedes transferir a la misma cuenta");
            return;
        }
        if (Integer.parseInt(moneyField.getText()) > source.getBalance()){
            errLabel.setText("No tienes suficiente dinero");
            return;
        }
        if (Integer.parseInt(moneyField.getText()) <= 0){
            errLabel.setText("La cantidad debe ser positiva");
            return;
        }
        int money = 0;
        try {
            money = Integer.parseInt(moneyField.getText());
        } catch (Exception e){
            errLabel.setText("La cantidad debe ser un número");
            return;
        }
        if (!source.getAccType().equals("Current") || !target.getAccType().equals("Current")){
            errLabel.setText("Solo puedes transferir a cuentas corrientes");
            return;
        }
        source.extractMoney(Integer.parseInt(moneyField.getText()));
        target.addMoney(Integer.parseInt(moneyField.getText()));
        App.atm.oppManager.createOperation("transfer", source, target, Integer.parseInt(moneyField.getText()));
        Navigator.gotoPage("MainATM", actBtn);

    };
    
}
