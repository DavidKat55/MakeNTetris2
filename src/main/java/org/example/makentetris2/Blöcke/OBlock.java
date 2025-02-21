package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

public class OBlock extends TetrisBlock {
    public OBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, Color.YELLOW, startX, startY, 0);
        setDrehbar(false);
    }
}
