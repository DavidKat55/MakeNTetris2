package org.example.makentetris2.Blöcke;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class TetrisBlock {
    protected ArrayList<Rectangle> blocks = new ArrayList<>();
    protected int[][] shape;
    protected int x, y;
    protected Color color;
    protected int rotationIndex;
    protected boolean drehbar;

    public TetrisBlock(int[][] shape, Color color, int startX, int startY, int rotationIndex) {
        this.shape = shape;
        this.color = color;
        this.x = startX;
        this.y = startY;
        this.rotationIndex = rotationIndex;
        drehbar = true;
        init();
    }

    public void init() {
        for (int i = 0; i < 4; i++) {
            Rectangle b = new Rectangle(37, 37, color);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(2);
            blocks.add(b);
        }
    }

    public void addToPane(GridPane pane) {
        pane.getChildren().removeAll(blocks);
        int index = 0;
        for (Rectangle block : blocks) {
            GridPane.setHalignment(block, HPos.CENTER);
            GridPane.setValignment(block, VPos.CENTER);
            pane.add(block, x + shape[index][0], y + shape[index][1]);
            index++;
        }
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public ArrayList<Rectangle> getBlocks() {
        return blocks;
    }

    public void rotate() {
        if (drehbar) {
            int centerX = shape[rotationIndex][0];
            int centerY = shape[rotationIndex][1];

            for (int i = 0; i < shape.length; i++) {
                int tX = shape[i][0] - centerX;
                int tY = shape[i][1] - centerY;

                shape[i][0] = centerX - tY;
                shape[i][1] = centerY + tX;
            }
        }
    }


    public int[][] getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDrehbar() {
        return drehbar;
    }

    public void setDrehbar(boolean drehbar) {
        this.drehbar = drehbar;
    }
}