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
    private ChoiceBox<?> accSelect;
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
        // TODO
    }
    
    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }

    public void submit(){};
    
}
