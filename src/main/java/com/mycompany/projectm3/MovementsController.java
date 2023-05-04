/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projectm3;

import com.mycompany.projectm3.Account.Account;
import com.mycompany.projectm3.Operation.Operation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mycompany.projectm3.User.User;
import com.mycompany.projectm3.lib.TimeHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author alumne
 */
public class MovementsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ScrollPane scrollPane;

    @FXML
    Button backBtn;

    /**
     * Renders the movements of the user
     * @param url url
     * @param rb resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = App.atm.getUser();
        ArrayList<Operation> operations = new ArrayList<Operation>();
        for (Account acc : user.getAccounts()) {
            operations.addAll(acc.getOperations());
        }
        VBox blocks = new VBox();
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(50), BorderWidths.DEFAULT));
        for (Operation opp : operations) {

            // Create a new HBox
            HBox block = new HBox();
            block.setPrefSize(600, 75);
            block.setAlignment(Pos.CENTER);
            block.setSpacing(10);
            block.setBorder(border);

            float amount = opp.getAmount();
            String opptype = opp.getOppType();
            long timestamp = opp.getTimestamp();
            Image image;
            if (opptype.equals("withdraw")) {
                image = new Image("file:src/main/resources/assets/decrease.png");
            } else if (opptype.equals("insert")) {
                image = new Image("file:src/main/resources/assets/increase.png");
            } else {
                image = new Image("file:src/main/resources/assets/double-arrow.png");
            }
                ImageView imageView = new ImageView(image);
                Label oppTypeLabel = new Label(opptype.equals("withdraw") ? "Extracción" : opptype.equals("insert") ? "Ingreso" : "Transferencia");
                Label amountLabel = new Label(String.valueOf(amount) + "€");
                Label timestampLabel = new Label(TimeHandler.timestampToString(timestamp));

                amountLabel.setPrefSize(150, 75);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                oppTypeLabel.setPrefSize(150, 75);
                timestampLabel.setPrefSize(150, 75);

                amountLabel.setAlignment(Pos.CENTER);
                oppTypeLabel.setAlignment(Pos.CENTER);
                timestampLabel.setAlignment(Pos.CENTER);

                block.getChildren().addAll(imageView, oppTypeLabel, amountLabel, timestampLabel);
                block.setPrefSize(600, 75);
                block.setAlignment(Pos.CENTER);
            blocks.getChildren().add(block);
        }
        blocks.setSpacing(10);

        scrollPane.setContent(blocks);
    }

    /**
     * Goes back to the home page
     * @throws IOException if the page doesn't exist
     */
    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }
}
