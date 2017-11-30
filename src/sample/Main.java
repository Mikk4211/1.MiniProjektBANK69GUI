package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main.
 * Kører hele programmet/applikationen.
 *
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 */


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setResizable(false);

        /**
         * Opretter og viser "vinduet", ved hjælp af javafx methoder.
         */
        primaryStage.setTitle("BANK OF SIXTY NINE");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    /**
     * @param args Commando linjens argumenter.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

