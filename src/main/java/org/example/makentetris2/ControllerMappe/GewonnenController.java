package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class GewonnenController {
    private GameController gameController;

    @FXML
    private AnchorPane gPane;

    @FXML
    private Label gLabel;

    @FXML
    private JFXButton bNext;

    private LevelManager levelManager;

    public void initialize() {
        levelManager = MakeNTetrisMain.getLevelManager();

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
}