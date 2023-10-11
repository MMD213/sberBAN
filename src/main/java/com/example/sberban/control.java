package com.example.sberban;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class control {

    @FXML
    private Button Enter;

    @FXML
    private Button Exit;

    @FXML
    private TextField Login;

    @FXML
    private TextField Password;

    @FXML
    void Lenter(ActionEvent event) {
        
    }

    @FXML
    void Lexit(ActionEvent event) {
System.exit(0);
    }

}
