package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

public class LBlock extends TetrisBlock {
    public LBlock(int startX, int startY) {
        super(new int[][]{{0,0}, {1,0}, {2,0}, {2,-1}}, Color.ORANGE, startX, startY, 2);
    }
}
