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

    public static void bloeckeBewegen(int x, int y) {
        spielFeld.setConstraints(block, (int) (block.getLayoutX()- block.getLayoutX()), (int) (block.getLayoutY() - block.getLayoutY() -1));
    }

    public void setBlock(Rectangle block) {
        this.block = block;
    }
    public Rectangle getBlock() {
        return block;
    }

}
