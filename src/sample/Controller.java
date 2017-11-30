package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.control.*;
/**
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 *
 */


/*
* I Sample.fxml, når man laver en ny button skal du hardcode onAction="#handleButtonAction" ind i, da intellij+scenebuilder er skrald.
* - Maaads
*/


public class Controller {
DB_Statements sqlStatement = new DB_Statements();

    /**
     * Javafx klasse for knapper på ny konto siden.
     */
    @FXML
    private Button btn_nyKonto;
    /**
     * Javafx klasser for ny kunde siden, med textfields og knapper fra GUI'en.
     */
    /*Opret ny kunde siden*/
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
    /**
     * Javafx klasse for knap på opret database.
     */
    /*Opret test DB*/
    @FXML
    private Button btn_opretDBTing;
    /**
     * Javafx klasser for overfør siden på GUI'en, med labels, knapper og textfelter.
     */
    /*Overfør siden*/
    @FXML
    private Label lbl_overfor_success;
    @FXML
    private Button btn_overfor;
    @FXML
    private TextField input_overfor_belob;
    @FXML
    private TextField input_overfor_kontonr;
    @FXML
    private TextField input_overfor_regnr;
    @FXML
    private TextField input_overfor_valgkonto;
    /**
     * Javafx klasse for konto siden, med knapper og labels på GUI'en.
     */
    /*Konto*/
    @FXML
    private Button btn_konto_lonkonto;
    @FXML
    private Button btn_konto_opsparingskonto;
    @FXML
    private Label


    /**
     * @param Forskellige parametre der bruges i den følgende kode der beskriver hvad knapperne på GUI'en skal gøre.
     */
    public int tempCprFirst = 0, tempCprLast = 0;
    String tempFornavn, tempEfternavn, tempAdr;
    char symbol;


    /**
     * Metode der afhænger af ActionEvent e, og der afgører hvad der sker når man trykker på knapperne i GUI'en.
     *
     */
    @FXML
    private void handleButtonAction(ActionEvent e) {
        sqlStatement.useDB();

/**
 * NY kunde knappen.
 * Når der trykkes på den knap, bliver følgende kode kørt. Der indsætter data, og opretter en ny kunde.
 */

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




            System.out.println(tempFornavn + " " + tempEfternavn);
            System.out.println(tempCprFirst + "-" + tempCprLast);
            System.out.println(tempAdr);


            /*
            System.out.println(tempCprFirst + "-" + tempCprLast);

            */
            sqlStatement.insertNyKunde(tempFornavn,tempEfternavn,tempCprFirst,tempCprLast,tempAdr);

        }
        /**
         * Knap der opretter databasen og et table i databasen.
         */
        /*Knap der opretter db og table */
        if (e.getSource() == btn_opretDBTing) {
            sqlStatement.createDB();
            sqlStatement.dropTableKontoTable();
            sqlStatement.dropTableKundeTable();
            sqlStatement.createKundeTable();
            sqlStatement.createKontoTable();
            sqlStatement.insertTestKunder();
            sqlStatement.insertTestKonto();
        }
        if (e.getSource() == btn_nyKonto){
            System.out.println("Button nykunde virker");
        }
/**
 * Når knappen overfør bliver trykket på, så bliver det valgte beløb overført til den valgte konto.
 */
        /*Knap der overfører*/
        if (e.getSource()== btn_overfor){
            //
            String tempBelobParser = input_overfor_belob.getText();
            double tempOverforBelob = Double.parseDouble(tempBelobParser);

            //
            /*String tempRegParser = input_overfor_regnr.getText();
            int tempRegNr = Integer.parseInt(tempRegParser);*/

            //
            String tempKontonrParser = input_overfor_kontonr.getText();
            int tempKontoNr = Integer.parseInt(tempKontonrParser);

            //
            char tempKontoValg = input_overfor_valgkonto.getText().charAt(0);

            //
            int p_id = 1;


            sqlStatement.overfor(p_id,tempKontoValg,tempOverforBelob,tempKontoNr);
        }

        /**
         * Kode til valg af henholdsvis lønkonto og opsparingskonto. Når den ene eller anden knap bliver trykket, så viser den kontoen svarende til knappen.
         */
        if (e.getSource()==btn_konto_lonkonto){
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            System.out.println("lønkontoknap virker");



        }
        if (e.getSource()==btn_konto_opsparingskonto)
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode. 
            System.out.println("Opsparingskontoknap virker");

        }


}