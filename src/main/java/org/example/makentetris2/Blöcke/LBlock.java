package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class LBlock extends TetrisBlock {
    public LBlock(int startX, int startY) {
        super(new int[][]{{0,0}, {1,0}, {2,0}, {2,-1}}, Color.ORANGE, startX, startY, 2);
    }
    @Override
    public void init() {
        super.init();
        Image image = new Image(getClass().getResourceAsStream("/images/Bloecke/LBlock.png"));
        ImagePattern pattern = new ImagePattern(image);
        for (Rectangle block : blocks) {
            block.setFill(pattern);
        }
    }
}
