package org.example.makentetris2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.makentetris2.ControllerMappe.*;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.Manager.GameManager;
import org.example.makentetris2.Manager.KeyInputManager;
import org.example.makentetris2.Manager.SoundManager;

import java.io.IOException;

public class MakeNTetrisMain extends Application {
    private static FXMLLoader fxmlLoader;
    public final static SoundManager soundManager = new SoundManager();
    private static LevelManager levelManager;
    private static Stage currentStage;
    private static LevelController levelController;
    private static MinigameController minigameController;
    private static GameController gameController;
    private static KeyInputManager keyInputManager;
    private static GewonnenController gewonnenController;
    private static ShopController shopController;

    // Initialisiert den Hauptbildschirm und die Szene
    @Override
    public void start(Stage stage) throws IOException {
        levelManager = new LevelManager();
        fxmlLoader = new FXMLLoader(MakeNTetrisMain.class.getResource("HauptBildschirm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        soundManager.playBackgroundMusic("/sounds/Start.mp3");

        initializeMinigameController();
        initializeLevelController();
        initializeKeyInputManager();
        initializeShopController();

        Image icon = new Image(getClass().getResourceAsStream("/images/Icons/Icon.png"));
        stage.getIcons().add(icon);

        stage.setResizable(false);
        stage.setTitle("MakeNTetris - Hauptbildschirm");
        stage.setScene(scene);
        stage.show();
    }

    // Startet das Spiel
    public static void main(String[] args) {
        launch();
    }

    // Wechselt die Szene
    public static void szeneWechseln(int szene) throws IOException {

        if (currentStage != null) {
            currentStage.close();
        }

        Stage newStage = new Stage();
        setCurrentStage(newStage);

        switch (szene) {
            case 1:
                FXMLLoader loader = new FXMLLoader(MakeNTetrisMain.class.getResource("MakeNTetris.fxml"));
                Parent root = loader.load();

                GameController controller = loader.getController();
                GridPane spielFeld = controller.getSpielFeld();
                GameManager gameManager = new GameManager(spielFeld);
                gameManager.setGameController(controller);
                soundManager.playBackgroundMusic("/sounds/game.wav");

                Scene s = new Scene(root);
                KeyInputManager keyInputManager = new KeyInputManager(gameManager);
                keyInputManager.initialize();
                keyInputManager.addKeyHandler(s);

                newStage.setFullScreen(false);
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Spiel");
                newStage.setScene(s);

                newStage.setOnCloseRequest(event -> {
                        getGameController().stopTimer();
                        soundManager.stopMusic();
                        soundManager.playBackgroundMusic("/sounds/Start.mp3");
                });

                newStage.show();
                gameManager.init();
                break;
            case 2:
                Parent root2 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Einstellungen.fxml"));
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Einstellungen");
                newStage.setScene(new Scene(root2));
                newStage.show();
                break;
            case 3:
                Parent root3 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Minigame.fxml"));
                soundManager.playBackgroundMusic("/sounds/MinigameStart.mp3");
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Minigame");
                newStage.setScene(new Scene(root3));
                newStage.show();
                newStage.setOnCloseRequest(event -> {
                    soundManager.stopMusic();
                    soundManager.playBackgroundMusic("/sounds/Start.mp3");
                });
                break;
            case 4:
                Parent root4 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Gewonnen.fxml"));
                soundManager.playSound("/sounds/gewonnen.mp3");
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Gewonnen");
                newStage.setScene(new Scene(root4));
                newStage.show();
                break;
            case 5:
                Parent root5 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Verloren.fxml"));
                soundManager.playSound("/sounds/verloren.mp3");
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Verloren");
                newStage.setScene(new Scene(root5));
                newStage.show();
                break;
            case 6:
                Parent root6 = FXMLLoader.load(MakeNTetrisMain.class.getResource("LevelAuswahl.fxml"));
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Level");
                newStage.setScene(new Scene(root6));
                newStage.show();
                break;
            case 7:
                soundManager.playBackgroundMusic("/sounds/MinigameStart.mp3");
                Parent root7 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Shop.fxml"));
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Shop");
                newStage.setScene(new Scene(root7));
                newStage.show();
                break;
            case 8:
                Parent root8 = FXMLLoader.load(MakeNTetrisMain.class.getResource("Tutorial.fxml"));
                newStage.setResizable(false);
                newStage.setTitle("MakeNTetris - Tutorial");
                newStage.setScene(new Scene(root8));
                newStage.show();
                break;
        }
    }

    // Initialisiert den MinigameController
    public static void initializeMinigameController() {
        try {
            FXMLLoader loader = new FXMLLoader(MakeNTetrisMain.class.getResource("Minigame.fxml"));
            loader.load();
            minigameController = loader.getController();
            minigameController.initialize();
            minigameController.loadBalance();
            minigameController.updateKontostand();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initialisiert den LevelController
    public static void initializeLevelController() {
        try {
            FXMLLoader loader = new FXMLLoader(MakeNTetrisMain.class.getResource("LevelAuswahl.fxml"));
            loader.load();
            levelController = loader.getController();
            levelController.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initialisiert den ShopController
    public static void initializeShopController() {
        try {
            FXMLLoader loader = new FXMLLoader(MakeNTetrisMain.class.getResource("Shop.fxml"));
            loader.load();
            shopController = loader.getController();
            shopController.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter und Setter für die Controller


    public static ShopController getShopController() {
        return shopController;
    }

    public static void setShopController (ShopController controller) {
        shopController = controller;
    }

    public void initializeKeyInputManager() {
        KeyInputManager keyInputManager = new KeyInputManager(new GameManager(new GridPane()));
        setKeyInputManager(keyInputManager);
    }

    public static GewonnenController getGewonnenController() {
        return gewonnenController;
    }

    public static void setGewonnenController(GewonnenController controller) {
        gewonnenController = controller;
    }

    public static LevelManager getLevelManager() {
        return levelManager;
    }

    public static void setCurrentStage(Stage stage) {
        currentStage = stage;
    }

    public static LevelController getLevelController() {
        return levelController;
    }

    public static void setLevelController(LevelController controller) {
        levelController = controller;
    }

    public static  MinigameController getMinigameController() {
        return minigameController;
    }

    public static void setMinigameController(MinigameController controller) {
        minigameController = controller;
    }

    public static KeyInputManager getKeyInputManager() {
        return keyInputManager;
    }

    public static void setKeyInputManager(KeyInputManager keyInputManager) {
        MakeNTetrisMain.keyInputManager = keyInputManager;
    }

    public static GameController getGameController() {
        return gameController;
    }

    public static void setGameController(GameController controller) {
        gameController = controller;
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }
}