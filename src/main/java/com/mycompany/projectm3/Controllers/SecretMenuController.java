package com.mycompany.projectm3.Controllers;

import com.mycompany.projectm3.App;
import com.mycompany.projectm3.Navigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SecretMenuController implements Initializable {

    @FXML
    Button backBtn;

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

    @FXML
    Button saveBtn;

    /**
     * Initializes the controller class.
     * @param url url
     * @param rb resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactory10 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0, 1);
        SpinnerValueFactory<Integer> valueFactory20 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        SpinnerValueFactory<Integer> valueFactory50 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        SpinnerValueFactory<Integer> valueFactory100 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        SpinnerValueFactory<Integer> valueFactory200 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);

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

        HashMap<Integer, Integer> bills = App.atm.billManager.getBills();
        field10.getValueFactory().setValue(bills.get(10));
        field20.getValueFactory().setValue(bills.get(20));
        field50.getValueFactory().setValue(bills.get(50));
        field100.getValueFactory().setValue(bills.get(100));
        field200.getValueFactory().setValue(bills.get(200));
    }

    /**
     * Updates the balance label when a spinner value changes.
     */
    private void updateBalance(){
        int balance = field10.getValue() * 10 + field20.getValue() * 20 + field50.getValue() * 50 + field100.getValue() * 100 + field200.getValue() * 200;
        balanceLabel.setText(String.valueOf(balance) + "€");
    }

    /**
     * Goes to the home page
     * @throws IOException if the fxml file is not found
     */
    public void gotoHome() throws Exception{
        Navigator.gotoPage("MainATM", backBtn);
    }

    /**
     * Saves the bills
     * @throws IOException if the fxml file is not found
     */
    public void save() throws IOException {
        HashMap<Integer, Integer> bills = new HashMap<>();
        bills.put(10, field10.getValue());
        bills.put(20, field20.getValue());
        bills.put(50, field50.getValue());
        bills.put(100, field100.getValue());
        bills.put(200, field200.getValue());
        App.atm.billManager.setBills(bills);
        App.atm.billManager.saveBills();
    }
}
