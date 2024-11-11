package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Events {

    @FXML
    private Rectangle block;
    @FXML
    private GridPane spielFeld;

    public void moveUp(Rectangle block, int x, int y) {
        System.out.println("Move Up");
        block.setOnKeyPressed(event -> {
            System.out.println("Key Pressed");
            if (event.getCode() == KeyCode.W) {
                System.out.println("W Pressed");
                spielFeld.setConstraints(block, x, y );
            }
        });
    }
}
