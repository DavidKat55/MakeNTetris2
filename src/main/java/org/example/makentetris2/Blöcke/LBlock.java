package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den L-Block, der von TetrisBlock erbt
public class LBlock extends TetrisBlock {
    // Konstruktor für den L-Block
    public LBlock(int startX, int startY) {
        // Initialisierung des L-Blocks mit den entsprechenden Koordinaten, Farbe, Startposition und Bild
        super(new int[][]{{0,0}, {1,0}, {2,0}, {2,-1}}, Color.ORANGE, startX, startY, 2, "LBlock.png");
    }

}
