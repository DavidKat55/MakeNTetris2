package org.example.makentetris2;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import org.example.makentetris2.ControllerMappe.GameController;

public class KeyInputManager {

    private Events events;
    private static GameController controller;
    private int selectedBlockIndex = 0;

    public KeyInputManager() {
        events = new Events();
    }

    public void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    events.moveBlockUp(controller.getBlock(selectedBlockIndex), controller.getSpielFeld());
                    break;
                case DOWN:
                    events.moveBlockDown(controller.getBlock(selectedBlockIndex), controller.getSpielFeld());
                    break;
                case LEFT:
                    events.moveBlockLeft(controller.getBlock(selectedBlockIndex), controller.getSpielFeld());
                    break;
                case RIGHT:
                    events.moveBlockRight(controller.getBlock(selectedBlockIndex), controller.getSpielFeld());
                    break;
                case SPACE:
                    events.rotateBlock(controller.getBlock(selectedBlockIndex), controller.getSpielFeld());
                    break;
                default:
                    if (event.getCode() == KeyCode.SHIFT) {
                        int index = (selectedBlockIndex + 1) % controller.getBlocks().size();
                        events.changeBlockStrokeColor(controller.getBlock(selectedBlockIndex), Color.BLACK);
                        selectedBlockIndex = index;
                        events.changeBlockStrokeColor(controller.getBlock(selectedBlockIndex), Color.YELLOW);
                    }
                    break;
            }
        });
    }

    public static void setController(GameController _controller) {
        controller = _controller;
    }
}