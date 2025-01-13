package org.example.makentetris2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class KeyInputManager {

    private Events events;
    private static Controller controller;
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
                    if (event.getCode().isDigitKey()) {
                        int index = Integer.parseInt(event.getText()) - 1;
                        if (index >= 0 && index < controller.getBlocks().size()) {
                            selectedBlockIndex = index;
                        }
                    }
                    break;
            }
        });
    }

    public static void setController(Controller _controller) {
        controller = _controller;
    }
}