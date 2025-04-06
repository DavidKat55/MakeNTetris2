package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den Z-Block, der von TetrisBlock erbt
public class ZBlock extends TetrisBlock {
    // Konstruktor für den Z-Block
    public ZBlock(int startX, int startY) {
        // Initialisiert den Z-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, Color.RED, startX, startY,2, "ZBlock.png");
    }
}
