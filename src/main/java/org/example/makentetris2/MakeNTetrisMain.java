package org.example.makentetris2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.makentetris2.ControllerMappe.GameController;
import org.example.makentetris2.Manager.GameManager;
import org.example.makentetris2.Manager.KeyInputManager;
import org.example.makentetris2.Manager.SoundManager;

import java.io.IOException;

public class MakeNTetrisMain extends Application {
    private static FXMLLoader fxmlLoader;
    public final static SoundManager soundManager = new SoundManager();

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(MakeNTetrisMain.class.getResource("HauptBildschirm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        soundManager.playBackgroundMusic("/sounds/start2.mp3");

        stage.setResizable(false);
        stage.setTitle("MakeNTetris - Hauptbildschirm");
        stage.setScene(scene);
        stage.show();


        //KeyInputManager keyInputManager = new KeyInputManager();
        //keyInputManager.addKeyHandler(scene);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void szeneWechseln(int szene) throws IOException {
        switch (szene) {
            case 1:
                FXMLLoader loader = new FXMLLoader(MakeNTetrisMain.class.getResource("MakeNTetris.fxml"));
                Parent root = loader.load();

                GameController controller = loader.getController();
                GridPane spielFeld = controller.getSpielFeld();
                GameManager gameManager = new GameManager(spielFeld);
                soundManager.playBackgroundMusic("/sounds/game.wav");

                Scene s = new Scene(root);
                KeyInputManager keyInputManager = new KeyInputManager(gameManager);
                keyInputManager.addKeyHandler(s);

                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("MakeNTetris - Spiel");
                stage.setScene(s);
                stage.show();
                gameManager.init();
                break;
            case 2:
                Parent root2 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Einstellungen.fxml"));
                Stage stage2 = new Stage();
                stage2.setResizable(false);
                stage2.setTitle("MakeNTetris - Einstellungen");
                stage2.setScene(new Scene(root2));
                stage2.show();
                break;
            case 3:
                Parent root3 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Minigame.fxml"));

                soundManager.playBackgroundMusic("/sounds/casino.mp3");
                Stage stage3 = new Stage();
                stage3.setResizable(false);
                stage3.setTitle("MakeNTetris - Minigame");
                stage3.setScene(new Scene(root3));
                stage3.show();

                break;
            case 4:
                System.out.println("Szene 4");
                break;
            case 5:
                System.out.println("Szene 5");
                break;
        }
    }
}