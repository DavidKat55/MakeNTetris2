package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.ControllerMappe.GameController;

import java.io.IOException;

public class GewonnenController {
    private GameController gameController;

    @FXML
    private AnchorPane gPane;

    @FXML
    private Label gLabel;

    @FXML
    private JFXButton bLevel2;

    private LevelManager levelManager;

    public void initialize() {
        levelManager = MakeNTetrisMain.getLevelManager();

        bLevel2.setOnAction(event -> {
            try {
                levelManager.nextLevel();
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}