package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.EventListener;

public class Events {

    public int[] getBlockPosition(Group block, GridPane spielFeld) {
        Integer column = GridPane.getColumnIndex(block);
        Integer row = GridPane.getRowIndex(block);
        return new int[]{column != null ? column : -1, row != null ? row : -1};
    }

    public void setBlockPosition(int column, int row, Group block, GridPane spielFeld) {
        spielFeld.setColumnIndex(block, column);
        spielFeld.setRowIndex(block, row);
    }

    public void moveBlockDown(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        setBlockPosition(position[0], position[1] + 1, block, spielFeld);
    }

    public void moveBlockLeft(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        setBlockPosition(position[0] - 1, position[1], block, spielFeld);
    }

    public void moveBlockRight(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        setBlockPosition(position[0] + 1, position[1], block, spielFeld);
    }

    public void moveBlockUp(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        setBlockPosition(position[0], position[1] - 1, block, spielFeld);
    }

    public void rotateBlock(Group block, GridPane spielFeld) {
        block.setRotate(block.getRotate() + 90);
        adjustBlockPosition(block, spielFeld);
    }

    private void adjustBlockPosition(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        double rotate = block.getRotate() % 360;

        switch ((int) rotate) {
            case 90:
                block.setTranslateX(21);
                block.setTranslateY(-21);
                break;
            case 180:
                block.setTranslateX(42);
                block.setTranslateY(0);
                break;
            case 270:
                block.setTranslateX(21);
                block.setTranslateY(21);
                break;
            default:
                block.setTranslateX(0);
                block.setTranslateY(0);
                break;
        }

        setBlockPosition(position[0], position[1], block, spielFeld);
    }
}
