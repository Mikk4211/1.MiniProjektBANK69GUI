package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
DB_Statements sqlStatement = new DB_Statements();


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
    int tempCprFirst, tempCprLast;
    String tempFornavn = null, tempEfternavn, tempAdr;
    char symbol;

    @FXML
    private void handleButtonAction(ActionEvent e) {
        int num1, num2, answer = 0;
        char symbol = '+';
        //e tells what button was clicked
        if (e.getSource() == btn_nyKunde) {
            // toString(input_nyFornavn.getText(tempFornavn));
            tempCprFirst = Integer.parseInt(input_nyCprFirst.getText());
            tempCprLast = Integer.parseInt(input_nyCprLast.getText());

            System.out.println(tempCprFirst + "-" + tempCprLast);


        }
    }

}