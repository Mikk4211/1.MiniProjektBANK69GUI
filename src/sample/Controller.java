package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.control.*;
/*
* I Sample.fxml, når man laver en ny button skal du hardcode onAction="#handleButtonAction" ind i, da intellij+scenebuilder er skrald.
* - Mads
* */



public class Controller {
//DB_Statements sqlStatement = new DB_Statements();


    @FXML
    private Button btn_nyKonto;
    @FXML
    private Button btn_nyKunde;
    @FXML
    private TextField input_nyFornavn;
    @FXML
    private TextField input_nyEfternavn;
    @FXML
    private TextField input_nyCprFirst;
    @FXML
    private TextField input_nyCprLast;
    @FXML
    private TextField input_nyAdr;
    @FXML
    private Label lbl;

    public int tempCprFirst = 0, tempCprLast = 0;
    String tempFornavn, tempEfternavn, tempAdr;
    char symbol;

    @FXML
    private void handleButtonAction(ActionEvent e) {
        //e tells what button was clicked
        if (e.getSource() == btn_nyKunde) {
            //giver fornavn værdien:
            tempFornavn = input_nyFornavn.getText();

            //Giver cprFirst en værdi:
            /*
            Man kan af en eller anden grund ikke gøre sådan:
            //tempCprFirst = Integer.parseInt( input_nyCprFirst.getText());
            //tempCprLast = Integer.parseInt(input_nyCprLast.getText());
            man skal først hente den til en variable og derefter parse den.
             */
            String tempCprFirstParser = input_nyCprFirst.getText();
            tempCprFirst = Integer.parseInt(tempCprFirstParser);



            //System.out.println(tempCprFirst + "-" + tempCprLast + "REEE!"+tempFornavn);
            System.out.println(tempCprFirst+tempFornavn);
            return;
        }


    }

}