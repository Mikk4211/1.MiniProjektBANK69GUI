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
DB_Statements sqlStatement = new DB_Statements();


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
    @FXML
    private Button btn_opretDBTing;


    public int tempCprFirst = 0, tempCprLast = 0;
    String tempFornavn, tempEfternavn, tempAdr;
    char symbol;

    @FXML
    private void handleButtonAction(ActionEvent e) {
        sqlStatement.useDB();

        /*NY KUNDE*/
        //Hvis knap Ny kunde bliver klikket, indsætter vi data
        /*linje ned*/
        if (e.getSource() == btn_nyKunde) {
            //Henter fornavn, efternavn og adresse:
            tempFornavn = input_nyFornavn.getText();
            tempEfternavn = input_nyEfternavn.getText();
            tempAdr = input_nyAdr.getText();

            //Giver cprFirst en værdi:
            String tempCprFirstParser = input_nyCprFirst.getText(); // Virker såfremt det er for sig selv.
            tempCprFirst = Integer.parseInt(tempCprFirstParser);
            String tempCprLastParser = input_nyCprLast.getText();
            tempCprLast = Integer.parseInt(tempCprLastParser);



            /* Lader til man ikke bare kan Parse begge 2. OBS!!
            String tempCprLastParser = input_nyCprLast.getText();
            tempCprLast = Integer.parseInt(tempCprLastParser);
            */

            /*  Den virker såfremt der skrives noget i cpr first. Men der kan ikke skrives noget i fornavn, uden der skrives i cpr first, så melder den fejl, da den forventer der er noget.
                Virker også fint med Fornavn, efternavn; såfremt der skrives noget i cpr first. Men virker stadig ikke hvis man laver ny parse til cpr last.
                Fornavn, efternavn, adr + cprFirst virker.
                Alle kombinationer virker såfremt cprLast ikke med. Vi skal finde en ny Parse måde da den melder fejl med 2.
                Fik det til at virke med first og last. Der var en ID fejl zzzzzzzzzzzzzzz.
             */


            System.out.println(tempFornavn + " " + tempEfternavn);
            System.out.println(tempCprFirst + "-" + tempCprLast);
            System.out.println(tempAdr);


            /*
            System.out.println(tempCprFirst + "-" + tempCprLast);

            */
            sqlStatement.insertNyKunde(tempFornavn,tempEfternavn,tempCprFirst,tempCprLast,tempAdr);

        }
        /*Knap der opretter db og table */
        if (e.getSource() == btn_opretDBTing) {
            sqlStatement.createDB();
            sqlStatement.createKundeTable();
            sqlStatement.insertTestKunder();
        }
        if (e.getSource() == btn_nyKonto){
            System.out.println("Button nykunde virker");
        }



        }

}