package sample;

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert;


import java.io.File;


/**
 * Main.
 * Kører hele programmet/applikationen.
 *
 * @author Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).
 */


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String urlString = new File("OtherFiles/intro.mp3").toURI().toString();//Finder music filen med Relativ path(så alle kan bruge den).
        MediaPlayer player = new MediaPlayer(new Media(urlString));//Laver filen om til en Mediaplayer
        player.play();//Tillader den at afspille
        player.setAutoPlay(true);//Afspiller den på startup.
        player.setCycleCount(69);//Hvor mange gange sangen skal køre
        String urlString2 = new File("OtherFiles/icon.png").toURI().toString();//Henter icon filensplacering og laver den om til et "uri".
        primaryStage.getIcons().add(new Image(urlString2));//Sætter Icon på programmet til at være det, der ligger på OtherFiles/icon.png.

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//Henter vores gui fra sample.fxml
        /**
         * Opretter og viser "vinduet", ved hjælp af javafx methoder.
         */
        primaryStage.setTitle("BANK OF 'SIXTY NINE");//Sætter overskrift for vores app.
        primaryStage.setScene(new Scene(root, 600, 400));//Bestemmer auto vinduestørrelse.
        primaryStage.setResizable(false);//Gør at man ikke ændre vindue størrelse.
        primaryStage.show();//"Viser" vinduet.

    }

    /**
     * @param args Commando linjens argumenter.
     */
    public static void main(String[] args) {

        launch(args);
    }
}
