module com.example.sberban {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;


    opens com.example.sberban to javafx.fxml;
    exports com.example.sberban;
}