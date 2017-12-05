package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
     //*   String urlString = new File("/Users/mathias/IdeaProjects/1.MiniProjektBANK69GUI/music/Bryan Adams - Summer of 69.mp3").toURI().toString();
     //   MediaPlayer player = new MediaPlayer(new Media(urlString));
       // player.play();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//Henter vores gui fra sample.fxml
        /**
         * Opretter og viser "vinduet", ved hjælp af javafx methoder.
         */
        primaryStage.setTitle("BANK OF SIXTY NINE");//Sætter overskrift for vores app.
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

