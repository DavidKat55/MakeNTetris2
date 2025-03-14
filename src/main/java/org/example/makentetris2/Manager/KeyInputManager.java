package org.example.makentetris2.Manager;

import javafx.scene.Scene;

import java.io.IOException;

public class KeyInputManager {

    private final GameManager gameManager;

    public KeyInputManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    gameManager.moveBlockUp(gameManager.getSelectedBlock());
//                    System.out.println("Up");
                    break;
                case DOWN:
                    gameManager.moveBlockDown(gameManager.getSelectedBlock());
//                    System.out.println("Down");
                    break;
                case LEFT:
                    gameManager.moveBlockLeft(gameManager.getSelectedBlock());
//                    System.out.println("Left");
                    break;
                case RIGHT:
                    gameManager.moveBlockRight(gameManager.getSelectedBlock());
//                    System.out.println("Right");
                    break;
                case SPACE:
                    gameManager.getSelectedBlock().rotate();
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
                        case ESCAPE:

                default:
                    break;
            }
        });
    }
}