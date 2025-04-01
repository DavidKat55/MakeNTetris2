package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class IBlock extends TetrisBlock {
    public IBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, Color.CYAN, startX, startY,2, "IBlock.png");
    }
}