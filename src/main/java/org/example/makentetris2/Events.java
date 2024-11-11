package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Events {

    private Rectangle block;

    private int x;
    private int y;

    public void moveUp(Rectangle block, int x, int y) {
        System.out.println("Move up");
    }
    public void moveDown(Rectangle block, int x, int y) {
        System.out.println("Move down");
    }
    public void moveLeft(Rectangle block, int x, int y) {
        System.out.println("Move left");
    }
    public void moveRight(Rectangle block, int x, int y) {
        System.out.println("Move right");
    }

    public void moveBlock(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                moveUp(block, x, y);
                break;
            case DOWN:
                moveDown(block, x, y);
                break;
            case LEFT:
                moveLeft(block, x, y);
                break;
            case RIGHT:
                moveRight(block, x, y);
                break;
        }
    }
}
