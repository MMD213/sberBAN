package com.example.sberban;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class control {
    double scetAlfa=8000;
    String log[] = new String[1000];
    String passw[] = new String[1000];
    ArrayList<String> hystory = new ArrayList<>();


    @FXML
    private Label Zagalovok;
    @FXML
    private Label Pole1;
    @FXML
    private Label Pole2;
    @FXML
    private Label Pole3;
    @FXML
    private Label Pole4;
    @FXML
    private Label Pole5;
    @FXML
    private Label Pole6;
    @FXML
    private Label Pole7;
    @FXML
    private Label Pole8;
    @FXML
    private Button Enter;

    @FXML
    private Button Exit;
    @FXML
    private Button History;
    @FXML
    private Button FullExit;
    @FXML
    private Button Profil;
    @FXML
    private Button Perevod;
    @FXML
    private TextField NumCard;
    @FXML
    private TextField Scet;
    @FXML
    private TextArea Hyst;
    @FXML

    private Button Rebut;
    @FXML
    private TextField Login;
    @FXML
    private TextField Summ;

    @FXML
    private TextField Password;
    @FXML
    private AnchorPane Form1;

    @FXML
    private AnchorPane Form2;



    @FXML
    void Lenter(ActionEvent event) {
        Stage stage = null;
        log[0]="Admin";
        passw[0]="123";
        for(int i =0;i<log.length;i++){
            if(Login.getText().equals(log[i])){
            if(Password.getText().equals(passw[i])){
                Form1.setVisible(false);
                Form2.setVisible(true);
                Scet.setText(scetAlfa+" рублей");
            }
            }
        }
    }
    @FXML
    void redbull(ActionEvent event) {
    Zagalovok.setText("Главная");
    Enable();
    Pole1.setText("Номер карты");
    Scet.setVisible(true);
    Pole3.setText("Сумма перевода");
    Perevod.setVisible(true);
    Pole5.setText("Счёт");
    NumCard.setVisible(true);
    Summ.setVisible(true);
    Scet.setText(scetAlfa+" рублей");
    }
    @FXML
    void  ActPerevod(ActionEvent event){
        if(!NumCard.getText().equals("")){
            if(!Summ.getText().equals("")){
                double scet= scetAlfa;
                scet=scet-Double.parseDouble(Summ.getText());
                if(scet>0){
                    Date date=new Date();
                    Scet.setText(String.valueOf(scet)+" рублей");
                    scetAlfa=scet;
                    hystory.add(String.valueOf(date)+" перевод "+Summ.getText()+" рублей на карту "+NumCard.getText());
                }
                else {
                    Summ.setText("У Вас недостаточно средств");
                }

            }
        }
    }
    @FXML
    void ActProfil(ActionEvent event) {
Zagalovok.setText("Профиль");
Enable();
Pole1.setText("ФИО: ММД");
Pole2.setText("Дата рождения: 20.01.2005");
Pole3.setText("Пол: кафельный");
Pole4.setText("Паспорт РФ: 1111 222226");
Pole5.setText("ИНН: 13568135789");
Pole6.setText("Номер телефона: +7980566213");
Pole7.setText("Email: dadadada@mail.ru");
Pole8.setText("Адрес: ул.Пушкина д. Калатушкино");
    }
    @FXML
    void ActHistory(ActionEvent event) {
        Enable();
        Hyst.setVisible(true);
Zagalovok.setText("История транзакций");
for (int i=0;i<hystory.size();i++){
    Hyst.appendText("\n"+hystory.get(i));
}
    }
    @FXML
    void ActFullExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Lexit(ActionEvent event) {
System.exit(0);
    }
void Enable(){
Pole1.setText("");
Pole2.setText("");
    Pole3.setText("");
    Pole4.setText("");
    Pole5.setText("");
    Pole6.setText("");
    Pole7.setText("");
    Pole8.setText("");
    Scet.setVisible(false);
    Perevod.setVisible(false);
    NumCard.setVisible(false);
    Summ.setVisible(false);
    Hyst.setVisible(false);

}
}
