package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ZBlock extends TetrisBlock {
    public ZBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, Color.RED, startX, startY,2, "ZBlock.png");
    }
}
