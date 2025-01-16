package org.example.makentetris2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MakeNTetrisMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MakeNTetrisMain.class.getResource("HauptBildschirm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("MakeNTetris - Hauptbildschirm");
        stage.setScene(scene);
        stage.show();

        KeyInputManager keyInputManager = new KeyInputManager();
        keyInputManager.addKeyHandler(scene);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void szeneWechseln(int szene) throws IOException {
        switch (szene) {
            case 1:
                Parent root = FXMLLoader.load(MakeNTetrisMain.class.getResource("MakeNTetris.fxml"));
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("MakeNTetris - Spiel");
                stage.setScene(new Scene(root));
                stage.show();

                KeyInputManager keyInputManager = new KeyInputManager();
                keyInputManager.addKeyHandler(stage.getScene());
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
                System.out.println("Szene 3");
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