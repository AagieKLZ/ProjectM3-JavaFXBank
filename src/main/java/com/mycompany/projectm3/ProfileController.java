package com.mycompany.projectm3;

import com.mycompany.projectm3.User.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    TextField nameField;

    @FXML
    TextField emailField;

    @FXML
    PasswordField pwField;

    @FXML
    PasswordField newpwField;

    @FXML
    PasswordField rppwField;

    @FXML
    CheckBox changePw;

    @FXML
    Label errLabel;

    @FXML
    Button actBtn;

    @FXML
    Button delBtn;

    @FXML
    Button backBtn;

    @FXML
    HBox newRow;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        User user = App.atm.getUser();
        nameField.setText(user.getName());
        emailField.setText(user.getEmail());
        newRow.setVisible(false);

        changePw.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                newRow.setVisible(true);
            } else {
                newRow.setVisible(false);
            }
        });
    }

    public void submit(){
        User user = App.atm.getUser();
        if (changePw.isSelected()){
            if (pwField.getText().equals(user.getPassword())){
                if (newpwField.getText().equals(rppwField.getText())){
                    user.setPassword(newpwField.getText());
                } else {
                    errLabel.setText("Las contraseñas no coinciden");
                    return;
                }
            } else {
                errLabel.setText("Contraseña incorrecta");
                return;
            }
        } else {
            if (!pwField.getText().equals(user.getPassword())){
                errLabel.setText("Contraseña incorrecta");
                return;
            }
        }
        user.setName(nameField.getText());
        user.setEmail(emailField.getText());
        errLabel.setText("Cambios guardados");
        App.atm.userManager.saveUsers();
    }

    public void delete(){
        User user = App.atm.getUser();
        if (pwField.getText().equals(user.getPassword())){
            App.atm.userManager.deleteUser(user);
            try {
                Navigator.gotoPage("welcome", backBtn);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errLabel.setText("Contraseña incorrecta");
        }
    }


    public void gotoHome() throws IOException {
        Navigator.gotoPage("MainATM", backBtn);
    }
}
