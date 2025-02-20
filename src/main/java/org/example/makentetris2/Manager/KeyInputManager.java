package org.example.makentetris2.Manager;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import org.example.makentetris2.Blöcke.TetrisBlock;
import org.example.makentetris2.ControllerMappe.GameController;

public class KeyInputManager {

    private static GameController controller;
    private int selectedBlockIndex = 0;
    private final GameManager gameManager;

    public KeyInputManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    gameManager.moveBlockUp(gameManager.getSelectedBlock());
                    System.out.println("Up");
                    break;
                case DOWN:
                    gameManager.moveBlockDown(gameManager.getSelectedBlock());
                    break;
                case LEFT:
                    gameManager.moveBlockLeft(gameManager.getSelectedBlock());
                    break;
                case RIGHT:
                    gameManager.moveBlockRight(gameManager.getSelectedBlock());
                    break;
                case SPACE:
                    gameManager.getSelectedBlock().rotate();
                    gameManager.updatePane();
                    break;
                case SHIFT:
                    gameManager.changeSelectedBlock();
                    break;
                default:
                    break;
            }
        });
    }
}