module com.mycompany.projectm3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projectm3 to javafx.fxml;
    exports com.mycompany.projectm3;
    exports com.mycompany.projectm3.FileReader;
    opens com.mycompany.projectm3.FileReader to javafx.fxml;
    exports com.mycompany.projectm3.Account;
    opens com.mycompany.projectm3.Account to javafx.fxml;
    exports com.mycompany.projectm3.User;
    opens com.mycompany.projectm3.User to javafx.fxml;
    exports com.mycompany.projectm3.lib;
    opens com.mycompany.projectm3.lib to javafx.fxml;
    exports com.mycompany.projectm3.Operation;
    opens com.mycompany.projectm3.Operation to javafx.fxml;
    exports com.mycompany.projectm3.Bills;
    opens com.mycompany.projectm3.Bills to javafx.fxml;
}
