package org.example.makentetris2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class KeyInputManager {

    private Events events;
    private static Controller controller;
    private GridPane spielFeld;
    private Group block;

    public KeyInputManager() {
        events = new Events();
    }

    public void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    events.moveBlockUp(controller.getBlock(), controller.getSpielFeld());
                    break;
                case DOWN:
                    events.moveBlockDown(controller.getBlock(), controller.getSpielFeld());
                    break;
                case LEFT:
                    events.moveBlockLeft(controller.getBlock(), controller.getSpielFeld());
                    break;
                case RIGHT:
                    events.moveBlockRight(controller.getBlock(), controller.getSpielFeld());
                    break;
                case SPACE:
                    events.rotateBlock(controller.getBlock(), controller.getSpielFeld());
                    break;
            }
        });
    }

    public static void setController(Controller _controller) {
        controller = _controller;
    }
}
