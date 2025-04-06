package org.example.makentetris2.Blöcke;

import javafx.scene.paint.Color;

// Klasse für den J-Block, der von TetrisBlock erbt
public class JBlock extends TetrisBlock{
    // Konstruktor für den J-Block
    public JBlock(int startX, int startY) {
        // Initialisiert den J-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0,0}, {1,0}, {2,0}, {0,-1}}, Color.DARKBLUE, startX, startY, 1, "JBlock.png");
    }
}
