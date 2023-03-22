module com.mycompany.projectm3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projectm3 to javafx.fxml;
    exports com.mycompany.projectm3;
}
