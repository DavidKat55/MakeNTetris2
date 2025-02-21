package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

public class ZBlock extends TetrisBlock {
    public ZBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 2}}, Color.GREEN, startX, startY,2);
    }
}
