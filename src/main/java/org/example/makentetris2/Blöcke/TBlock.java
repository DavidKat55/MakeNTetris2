package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

public class TBlock extends TetrisBlock {
    public TBlock(int startX, int startY) {
        super(new int[][]{{0,0}, {1,0}, {2,0}, {1,-1}}, Color.PURPLE, startX, startY, 1);
    }
}
