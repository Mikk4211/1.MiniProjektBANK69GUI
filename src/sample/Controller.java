package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.sql.SQLException;


/**
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 *
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
    @FXML
    private TextField input_opret_lonBelob;
    @FXML
    private TextField input_opret_lonRente;
    @FXML
    private TextField input_opret_lonOvertrak;
    @FXML
    private TextField input_opret_opsparBelob;
    @FXML
    private TextField input_opret_opsparRente;
    @FXML
    private TextField input_opret_opsparOvertrak;


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
    private Label lbl_konto_beløb;
    @FXML
    private Label lbl_konto_renteIndsats;
    @FXML
    private Label lbl_konto_tilladtOvertræk;

    /**
     * @param Forskellige parametre der bruges i den følgende kode der beskriver hvad knapperne på GUI'en skal gøre.
     */
    public int tempCprFirst = 0, tempCprLast = 0;
    String tempFornavn, tempEfternavn, tempAdr;
    char symbol;


    /**
     * Metode der afhænger af ActionEvent e, og der afgører hvad der sker når man trykker på knapperne i GUI'en.
     */
    @FXML
    private void handleButtonAction(ActionEvent e) throws SQLException {
        sqlStatement.useDB();

/**
 * NY kunde knappen.
 * Når der trykkes på den knap, bliver følgende kode kørt. Der indsætter data, og opretter en ny kunde, samt kundes bank værdier.
 */

        if (e.getSource() == btn_nyKunde) {
            //Henter fornavn, efternavn og adresse:
            tempFornavn = input_nyFornavn.getText();
            tempEfternavn = input_nyEfternavn.getText();
            tempAdr = input_nyAdr.getText();

            //Giver cprFirst en værdi:
            String tempCprFirstParser = input_nyCprFirst.getText(); // Virker såfremt det er for sig selv.
            tempCprFirst = Integer.parseInt(tempCprFirstParser);
            //Giver cprLast en værdi;
            String tempCprLastParser = input_nyCprLast.getText();
            tempCprLast = Integer.parseInt(tempCprLastParser);

            //En sout der lige printer værdierne
            System.out.println("Ny kunde oprettet\n------------------- ");
            System.out.println(" Navn :" + tempFornavn + " " + tempEfternavn);
            System.out.println("CPR : " + tempCprFirst + "-" + tempCprLast);
            System.out.println("Adresse : "+tempAdr);

            /*kunde bankværdier parserer. De ændre værdierne fra string til int/double*/
            //parser for lønkonto beløbet
            String kParser1 = input_opret_lonBelob.getText();
            double lonBelobP = Double.parseDouble(kParser1);

            //Parser for opsparingsBeløbet
            String kParser2 = input_opret_opsparBelob.getText();
            double opsBelobP = Double.parseDouble(kParser2);

            //Parser for tilladt overtræk på lønkontoen
            String kParser3 = input_opret_lonOvertrak.getText();
            int lonOTP = Integer.parseInt(kParser3);

            //Parser for tilladt overtræk på opsparing
            String kParser4 = input_opret_opsparBelob.getText();
            int opsOTP = Integer.parseInt(kParser3);

            //Parser for renterne
            String kParser5 = input_opret_lonRente.getText();
            String kParser6 = input_opret_opsparRente.getText();
            double lonRenteP = Double.parseDouble(kParser5);
            double opsRenteP = Double.parseDouble(kParser6);

            //Statementsne der indsætter det i table.
            sqlStatement.insertNyKunde(tempFornavn, tempEfternavn, tempCprFirst, tempCprLast, tempAdr);
            sqlStatement.insertNyKundeBankVardier(lonBelobP, opsBelobP, lonRenteP, opsRenteP, lonOTP, opsOTP);
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
        if (e.getSource() == btn_nyKonto) {
            System.out.println("Button nykunde virker");
        }
/**
 * Når knappen overfør bliver trykket på, så bliver det valgte beløb overført til den valgte konto.
 */
        /*Knap der overfører*/
        if (e.getSource() == btn_overfor) {
            //
            String tempBelobParser = input_overfor_belob.getText();
            double tempOverforBelob = Double.parseDouble(tempBelobParser);

            //
            /*String tempRegParser = input_overfor_regnr.getText();//Skal ikke bruges da vi kører med p_id istedet for konto og regnr.
            int tempRegNr = Integer.parseInt(tempRegParser);*/

            //
            String tempKontonrParser = input_overfor_kontonr.getText();
            int tempKontoNr = Integer.parseInt(tempKontonrParser);

            //
            char tempKontoValg = input_overfor_valgkonto.getText().charAt(0);

            //
            int p_id =1;


            sqlStatement.overfor(p_id, tempKontoValg, tempOverforBelob, tempKontoNr);
        }

        /**
         * Kode til valg af henholdsvis lønkonto og opsparingskonto. Når den ene eller anden knap bliver trykket, så viser den kontoen svarende til knappen.
         */


        if (e.getSource() == btn_konto_lonkonto) {
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_konto_beløb.setText(sqlStatement.opsparingskontovaerdier(1,"lonkonto", "lonkonto"));
            lbl_konto_renteIndsats.setText(sqlStatement.opsparingskontovaerdier(1,"lonRente", "lonkonto"));
            lbl_konto_tilladtOvertræk.setText(sqlStatement.opsparingskontovaerdier(1,"lonOT", "lonkonto"));

        }

        if (e.getSource() == btn_konto_opsparingskonto) {
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_konto_beløb.setText(sqlStatement.opsparingskontovaerdier(1,"opsparing", "opsparingskonto"));
            lbl_konto_renteIndsats.setText(sqlStatement.opsparingskontovaerdier(1,"opsRente", "opsparingskonto"));
            lbl_konto_tilladtOvertræk.setText(sqlStatement.opsparingskontovaerdier(1,"opsOT", "opsparingskonto"));

        }



    }
}

