package org.example.makentetris2.Manager;

import javafx.scene.Scene;
import org.example.makentetris2.ControllerMappe.GewonnenController;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class KeyInputManager {

    private final GameManager gameManager;


    private int gewonnenePunkte = 250;

    public KeyInputManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void initialize() {
        MakeNTetrisMain.setKeyInputManager(this);
    }

    public void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W, UP:
                    gameManager.moveBlockUp(gameManager.getSelectedBlock());
                    gewonnenePunkte--;
//                    System.out.println("Up");
                    break;
                case S, DOWN:
                    gameManager.moveBlockDown(gameManager.getSelectedBlock());
                    gewonnenePunkte--;
//                    System.out.println("Down");
                    break;
                case A, LEFT:
                    gameManager.moveBlockLeft(gameManager.getSelectedBlock());
                    gewonnenePunkte--;
//                    System.out.println("Left");
                    break;
                case D, RIGHT:
                    gameManager.moveBlockRight(gameManager.getSelectedBlock());
                    gewonnenePunkte--;
//                    System.out.println("Right");
                    break;
                case SPACE:
                    gameManager.getSelectedBlock().rotate();
                    gewonnenePunkte--;
//                    System.out.println("Rotate");
                    gameManager.updatePane();
                    break;
                case SHIFT:
                    gameManager.changeSelectedBlock();
//                    System.out.println("Change SelectedBlock");
                    break;
                case ENTER:
                        try {
                            gameManager.onEnterPressed();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        gewonnenePunkte = gewonnenePunkte - 10;
                        break;
                default:
                    break;
            }
        });
    }

    public int getGewonnenePunkte() {
        return gewonnenePunkte;
    }

    public void setGewonnenePunkte(int gewonnenePunkte) {
        this.gewonnenePunkte = gewonnenePunkte;
    }
}