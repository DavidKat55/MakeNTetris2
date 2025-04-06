package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den T-Block, der von TetrisBlock erbt
public class TBlock extends TetrisBlock {
    // Konstruktor für den T-Block
    public TBlock(int startX, int startY) {
        // Initialisiert den T-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0,0}, {1,0}, {2,0}, {1,-1}}, Color.PURPLE, startX, startY, 1, "TBlock.png");
    }

}
