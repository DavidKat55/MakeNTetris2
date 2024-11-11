package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Bloecke {

    @FXML
    private static Rectangle block;
    @FXML
    private static GridPane spielFeld;

    public Bloecke(Rectangle block) {
        this.block = block;
    }

    public void setBlock(Rectangle block) {
        this.block = block;
    }
    public Rectangle getBlock() {
        return block;
    }

}
