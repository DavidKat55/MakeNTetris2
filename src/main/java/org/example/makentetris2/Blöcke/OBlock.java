package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den O-Block, der von TetrisBlock erbt
public class OBlock extends TetrisBlock {
    // Konstruktor für den O-Block
    public OBlock(int startX, int startY) {
        // Initialisiert den O-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, Color.YELLOW, startX, startY, 0, "OBlock.png");
        setDrehbar(false);
    }

}
