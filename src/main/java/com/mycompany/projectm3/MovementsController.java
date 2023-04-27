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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User user = new User("c@c", "acb", 5);
        Account acc = new Account(1234, 50, user);
        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Operation op = new Operation("deposit", acc, null, 50);
            Operation op2 = new Operation("withdraw", acc, null, -50);
            Operation op3 = new Operation("transfer", acc, null, 100);
            acc.addOperation(op);
            acc.addOperation(op2);
            acc.addOperation(op3);
            operations.add(op);
            operations.add(op2);
            operations.add(op3);
        }
        //ArrayList<Operation> operations = acc.getOperations();
        VBox blocks = new VBox();
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(50), BorderWidths.DEFAULT));
        for (Operation opp : operations) {
            // Create a block
            Pane block = new Pane();
            block.setPrefSize(600, 100); // Set the size of the block
            block.setBorder(border);

            // Create a new HBox
            HBox row = new HBox();
            row.setPrefSize(600, 50);
            row.setAlignment(Pos.CENTER);
            row.setSpacing(10);

            float amount = opp.getAmount();
            String opptype = opp.getOppType();
            long timestamp = opp.getTimestamp();
            Image image;
            if (opptype.equals("withdraw")) {
                image = new Image("file:src/main/resources/assets/decrease.png");
            } else if (opptype.equals("deposit")) {
                image = new Image("file:src/main/resources/assets/increase.png");
            } else {
                image = new Image("file:src/main/resources/assets/double-arrow.png");
            }
                ImageView imageView = new ImageView(image);
                Label oppTypeLabel = new Label(opptype);
                Label amountLabel = new Label(String.valueOf(amount) + "€");
                Label timestampLabel = new Label(TimeHandler.timestampToString(timestamp));

                amountLabel.setPrefSize(150, 50);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                oppTypeLabel.setPrefSize(150, 50);
                timestampLabel.setPrefSize(150, 50);

                amountLabel.setAlignment(Pos.CENTER);
                oppTypeLabel.setAlignment(Pos.CENTER);
                timestampLabel.setAlignment(Pos.CENTER);

                row.getChildren().addAll(imageView, oppTypeLabel, amountLabel, timestampLabel);
                row.setPrefSize(600, 50);
                row.setAlignment(Pos.CENTER);
            block.getChildren().add(row);
            blocks.getChildren().add(block);
        }
        blocks.setSpacing(10);

        scrollPane.setContent(blocks);
    }
    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }
}
