package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Manager.KeyInputManager;

import java.io.IOException;

public class GewonnenController {
    private GameController gameController;
    private KeyInputManager keyInputManager;

    @FXML
    private AnchorPane gPane;

    @FXML
    private Label gLabel;

    @FXML
    private Label gLabel1;

    @FXML
    private JFXButton bNext;

    private LevelManager levelManager;
    private int points = 0;

    public void initialize() {
        MakeNTetrisMain.setGewonnenController(this);

        levelManager = MakeNTetrisMain.getLevelManager();

        gameController = MakeNTetrisMain.getGameController();

        LevelController levelController = MakeNTetrisMain.getLevelController();
        int currentLevelIndex = MakeNTetrisMain.getLevelManager().getCurrentLevelIndex() + 1;

        KeyInputManager keyInputManager = MakeNTetrisMain.getKeyInputManager();
        points = keyInputManager.getGewonnenePunkte();

        gLabel.setText("Level " + currentLevelIndex + " geschafft !");
        gLabel1.setText("Punkte: " + points);

        bNext.setOnAction(event -> {
            try {
                if (levelManager.getCurrentLevelIndex() == levelManager.getNumberOfLevels() - 1) {
                    gLabel.setText("Alle Level geschafft!");
                } else {
                    levelManager.nextLevel();
                    MakeNTetrisMain.szeneWechseln(1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setPoints(int points) {}
}