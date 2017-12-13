package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
     * Javafx klasse for liste over kunder
     *
     */
    @FXML
    private Button btn_hentkundeliste;
    @FXML
    private Button btn_næsteSetListe;
    @FXML
    private ListView listview_kunder;
    @FXML
    private Label lbl_listeOverKunder1;
    @FXML
    private Label lbl_listeOverKunder2;
    @FXML
    private Label lbl_listeOverKunder3;
    @FXML
    private Label lbl_kunde_beløb;
    @FXML
    private Label lbl_kunde_renteindsats;
    @FXML
    private Label lbl_kunde_TO;
    @FXML
    private Button btn_kunder_lonkonto;
    @FXML
    private Button btn_kunder_opsparingskonto;


    /**
     * Javafx klasse for knap på opret database.
     */
    /*Opret test DB*/


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
    private TextField input_bruger_id;
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

    /*Login*/
    @FXML
    private Button btn_logIn;
    @FXML
    private TextField input_login_brugernavn;
    @FXML
    private TextField input_login_adgangskode;
    @FXML
    private Label lbl_login_velkommen;

    /**
     * @param Forskellige parametre der bruges i den følgende kode der beskriver hvad knapperne på GUI'en skal gøre.
     */
    public int tempCprFirst = 0, tempCprLast = 0;
    String tempFornavn, tempEfternavn, tempAdr;
    char symbol;
    int id_plusser = 0;


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
            System.out.println("Adresse : " + tempAdr);

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
            String kParser4 = input_opret_opsparOvertrak.getText();
            int opsOTP = Integer.parseInt(kParser4);

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
            //Parser String til double, for beløbet der skal overføres.
            String tempBelobParser = input_overfor_belob.getText();
            double tempOverforBelob = Double.parseDouble(tempBelobParser);

            //Parser String til int, for reg.nr input.
            //Skal ikke bruges da vi kører med p_id istedet for konto og regnr.
            /*String tempRegParser = input_overfor_regnr.getText();
            int tempRegNr = Integer.parseInt(tempRegParser);*/

            //Parser String til int, for konto.nr. input.
            String tempKontonrParser = input_overfor_kontonr.getText();
            int tempKontoNr = Integer.parseInt(tempKontonrParser);

            //Henter valg af at kontoen man vil sende fra.
            char tempKontoValg = input_overfor_valgkonto.getText().charAt(0);

            //Er brugerens/kundens eget id.
            int p_id = 1;

            //Bruger statement, der overføre beløbet.
            sqlStatement.overfor(p_id, tempKontoValg, tempOverforBelob, tempKontoNr);

        }

        /**
         * Kode til valg af henholdsvis lønkonto og opsparingskonto. Når den ene eller anden knap bliver trykket, så viser den kontoen svarende til knappen.
         */


        if (e.getSource() == btn_konto_lonkonto) {
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_konto_beløb.setText(sqlStatement.opsparingskontovaerdier(1, "lonkonto", "lonkonto"));
            lbl_konto_renteIndsats.setText(sqlStatement.opsparingskontovaerdier(1, "lonRente", "lonkonto"));
            lbl_konto_tilladtOvertræk.setText(sqlStatement.opsparingskontovaerdier(1, "lonOT", "lonkonto"));

        }

        if (e.getSource() == btn_konto_opsparingskonto) {

            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_konto_beløb.setText(sqlStatement.opsparingskontovaerdier(1, "opsparing", "opsparingskonto"));
            lbl_konto_renteIndsats.setText(sqlStatement.opsparingskontovaerdier(1, "opsRente", "opsparingskonto"));
            lbl_konto_tilladtOvertræk.setText(sqlStatement.opsparingskontovaerdier(1, "opsOT", "opsparingskonto"));
        }
        if (e.getSource() == btn_kunder_lonkonto) {
            //Henter P_id fra input
            int p_idInputKonto;
            String tempP_idParser = input_bruger_id.getText();
            p_idInputKonto = Integer.parseInt(tempP_idParser);
            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_kunde_beløb.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "lonkonto", "lonkonto"));
            lbl_kunde_renteindsats.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "lonRente", "lonkonto"));
            lbl_kunde_TO.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "lonOT", "lonkonto"));

        }
        if (e.getSource() == btn_kunder_opsparingskonto) {
            //Henter P_id fra input
            int p_idInputKonto;
            String tempP_idParser = input_bruger_id.getText();
            p_idInputKonto = Integer.parseInt(tempP_idParser);

            //Kontrollere at knappen er opsat korrekt og virker før der bliver indsat kode.
            lbl_kunde_beløb.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "opsparing", "opsparingskonto"));
            lbl_kunde_renteindsats.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "opsRente", "opsparingskonto"));
            lbl_kunde_TO.setText(sqlStatement.opsparingskontovaerdier(p_idInputKonto, "opsOT", "opsparingskonto"));

        }
        if(e.getSource() == btn_hentkundeliste) {
            id_plusser =0;
            lbl_listeOverKunder1.setText(sqlStatement.labels_kundeliste(1));
            lbl_listeOverKunder2.setText(sqlStatement.labels_kundeliste(2));
            lbl_listeOverKunder3.setText(sqlStatement.labels_kundeliste(3));
        }
        if(e.getSource() == btn_næsteSetListe) {
            id_plusser +=3;
            lbl_listeOverKunder1.setText(sqlStatement.labels_kundeliste((1 + id_plusser)));
            lbl_listeOverKunder2.setText(sqlStatement.labels_kundeliste((2 + id_plusser)));
            lbl_listeOverKunder3.setText(sqlStatement.labels_kundeliste((3 + id_plusser)));

        }
    }




    }


