module com.example.sberban {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sberban to javafx.fxml;
    exports com.example.sberban;
}