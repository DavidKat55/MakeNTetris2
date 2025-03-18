package org.example.makentetris2.Blöcke;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class OBlock extends TetrisBlock {
    public OBlock(int startX, int startY) {
        super(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}, Color.YELLOW, startX, startY, 0);
        setDrehbar(false);
    }
    @Override
    public void init() {
        super.init();
        Image image = new Image(getClass().getResourceAsStream("/images/Bloecke/Minecraft/Erde.png"));
        ImagePattern pattern = new ImagePattern(image);
        for (Rectangle block : blocks) {
            block.setFill(pattern);
        }
    }

}
