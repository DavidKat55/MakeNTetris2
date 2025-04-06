package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den S-Block, der von TetrisBlock erbt
public class SBlock extends TetrisBlock{
    // Konstruktor für den S-Block
    public SBlock(int startX, int startY) {
        // Initialisiert den S-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0, 1}, {1, 1}, {1, 0}, {2, 0}}, Color.GREEN, startX, startY,2, "SBlock.png");
    }
}
