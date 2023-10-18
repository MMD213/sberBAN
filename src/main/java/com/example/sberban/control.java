package com.example.sberban;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class control {
    double scetAlfa=8000;
    String pols;
    ArrayList<String> log = new ArrayList<>();
    ArrayList<String> passw = new ArrayList<>();
    ArrayList<String> hystory = new ArrayList<>();
    HSSFWorkbook workbook= Dannie.readWorkbook("C:\\Users\\mihai\\IdeaProjects\\untitled1\\src\\main\\resources\\dadad.xls");


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
void initialize(){

    }
    int Poisk(String name,int i){
    int d = 0;
        HSSFWorkbook workbook= Dannie.readWorkbook("C:\\Users\\mihai\\IdeaProjects\\untitled1\\src\\main\\resources\\dadad.xls");
        HSSFSheet sheet= workbook.getSheet("Лист1");
        Iterator<Row> rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter.next();
            HSSFCell cell = row.getCell(i);
            String str = cell.getRichStringCellValue().getString();
            cell.setCellValue(new HSSFRichTextString(str));

                if (str.equals(name)) {
                    d = row.getRowNum();
                }

        }
        return d;
    }
    int PoiskcART(double carta){
        int d = 0;
        int i=0;
        HSSFWorkbook workbook= Dannie.readWorkbook("C:\\Users\\mihai\\IdeaProjects\\untitled1\\src\\main\\resources\\dadad.xls");
        HSSFSheet sheet= workbook.getSheet("Лист1");
        Iterator<Row> rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter.next();
            HSSFCell cell = row.getCell(0);
            if(i!=0) {
            double ad = cell.getNumericCellValue();
            cell.setCellValue(ad);

                if (ad == carta) {
                    d = row.getRowNum();
                }
            }
            i++;

        }
        return d;
    }

    @FXML
    void Lenter(ActionEvent event) {
        String adm="";
        String pasw="";
        HSSFWorkbook workbook= Dannie.readWorkbook("C:\\Users\\mihai\\IdeaProjects\\untitled1\\src\\main\\resources\\dadad.xls");

        HSSFSheet sheet= workbook.getSheet("Лист1");
        Iterator<Row> rowIter = sheet.rowIterator();
        while (rowIter.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter.next();
            HSSFCell cell = row.getCell(3);
            String str = cell.getRichStringCellValue().getString();
            cell.setCellValue(new HSSFRichTextString(str));
            log.add(str);
        }
        Iterator<Row> rowIter2 = sheet.rowIterator();
        while (rowIter2.hasNext()) {
            HSSFRow row = (HSSFRow) rowIter2.next();
            HSSFCell cell = row.getCell(4);
            String str = cell.getRichStringCellValue().getString();
            cell.setCellValue(new HSSFRichTextString(str));
            passw.add(str);
        }
        for(int i =0;i<log.size();i++){
            adm=log.get(i);
            pasw=passw.get(i);
            if(Login.getText().equals(adm)){
            if(Password.getText().equals(pasw)){
                pols=adm;
                Form1.setVisible(false);
                Form2.setVisible(true);
                String a= String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(2).getNumericCellValue());

                Scet.setText(a+" рублей");
            }
            }
        }
        log.clear();
        passw.clear();
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
String a= String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(2).getNumericCellValue());

    Scet.setText(a+" рублей");
    }
    @FXML
    void  ActPerevod(ActionEvent event){
        if(Double.parseDouble(NumCard.getText())==((workbook.getSheetAt(0).getRow(PoiskcART(Double.parseDouble(NumCard.getText()))).getCell(0).getNumericCellValue()))){
            if(!Summ.getText().equals("")){
                double scet= workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(2).getNumericCellValue();
                scet=scet-Double.parseDouble(Summ.getText());
                if(scet>0){
                    Date date=new Date();
                    Scet.setText(String.valueOf(scet)+" рублей");
                    workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(2).setCellValue(scet);
                    double tor=workbook.getSheetAt(0).getRow(PoiskcART(Double.parseDouble(NumCard.getText()))).getCell(2).getNumericCellValue()+ Double.parseDouble(Summ.getText());
                    workbook.getSheetAt(0).getRow(PoiskcART(Double.parseDouble(NumCard.getText()))).getCell(2).setCellValue(tor);
                    Dannie.writeWorkbook(workbook,"C:\\Users\\mihai\\IdeaProjects\\untitled1\\src\\main\\resources\\dadad.xls");
                    hystory.add(String.valueOf(date)+" перевод "+Summ.getText()+" рублей на карту "+NumCard.getText());

                }
                else {
                    Summ.setText("У Вас недостаточно средств");
                }

            }
        }
        else {
            System.out.println("Лох");
        }
    }
    @FXML
    void ActProfil(ActionEvent event) {
Zagalovok.setText("Профиль");
Enable();
Pole1.setText("ФИО: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(1).getStringCellValue()));
Pole2.setText("Дата рождения: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(5).getDateCellValue()));
Pole3.setText("Пол: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(6).getStringCellValue()));
Pole4.setText("Паспорт РФ: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(7).getNumericCellValue()));
Pole5.setText("ИНН: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(8).getNumericCellValue()));
Pole6.setText("Номер телефона: +"+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(9).getNumericCellValue()));
Pole7.setText("Email: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(10).getStringCellValue()));
Pole8.setText("Адрес: "+String.valueOf(workbook.getSheetAt(0).getRow(Poisk(pols,3)).getCell(11).getStringCellValue()));
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
