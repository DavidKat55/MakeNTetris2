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

    private Bloecke bloecke;
    private int x;
    private int y;

    public void moveUp(Rectangle block) {
        block.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                spielFeld.setConstraints(block, x, y - 1);
            }
        });
    }
}
