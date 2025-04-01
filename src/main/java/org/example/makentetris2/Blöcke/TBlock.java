package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class TBlock extends TetrisBlock {
    public TBlock(int startX, int startY) {
        super(new int[][]{{0,0}, {1,0}, {2,0}, {1,-1}}, Color.PURPLE, startX, startY, 1, "TBlock.png");
    }

}
