package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

// Klasse für den I-Block, der von TetrisBlock erbt
public class IBlock extends TetrisBlock {
    // Konstruktor für den I-Block
    public IBlock(int startX, int startY) {
        // Initialisiert den I-Block mit einer spezifischen Form, Farbe, Startposition und Bild
        super(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}, Color.CYAN, startX, startY, 2, "IBlock.png");
    }
}