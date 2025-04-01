package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class JBlock extends TetrisBlock{
    public JBlock(int startX, int startY) {
        super(new int[][]{{0,0}, {1,0}, {2,0}, {0,-1}}, Color.DARKBLUE, startX, startY, 1, "JBlock.png");
    }
}
