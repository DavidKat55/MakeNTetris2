package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

public class IBlock extends TetrisBlock {
    public IBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, Color.CYAN, startX, startY,2);
    }
}