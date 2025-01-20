package org.example.makentetris2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    private boolean checkCollision(Group block, GridPane spielFeld, int newColumn, int newRow) {
        for (Node node : spielFeld.getChildren()) {
            if (node instanceof Group && node != block) {
                Group otherBlock = (Group) node;
                Integer otherColumn = GridPane.getColumnIndex(otherBlock);
                Integer otherRow = GridPane.getRowIndex(otherBlock);
                if (otherColumn != null && otherRow != null && otherColumn == newColumn && otherRow == newRow) {
                    return true;
                }
            }
        }
        return false;
    }
    public void moveBlockDown(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newRow = position[1] + 1;
        if (!checkCollision(block, spielFeld, position[0], newRow)) {
            setBlockPosition(position[0], newRow, block, spielFeld);
        }
    }

    public void moveBlockLeft(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newColumn = position[0] - 1;
        if (!checkCollision(block, spielFeld, newColumn, position[1])) {
            setBlockPosition(newColumn, position[1], block, spielFeld);
        }
    }

    public void moveBlockRight(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newColumn = position[0] + 1;
        if (!checkCollision(block, spielFeld, newColumn, position[1])) {
            setBlockPosition(newColumn, position[1], block, spielFeld);
        }
    }

    public void moveBlockUp(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newRow = position[1] - 1;
        if (!checkCollision(block, spielFeld, position[0], newRow)) {
            setBlockPosition(position[0], newRow, block, spielFeld);
        }
    }

    public void rotateBlock(Group block, GridPane spielFeld) {
        if (block.getId() != null && block.getId().equals("block5")) {
            return; // Do not rotate block5
        }
        block.setRotate(block.getRotate() + 90);
    }

    public void changeBlockStrokeColor(Group block, Color color) {
        for (Node node : block.getChildren()) {
            if (node instanceof Rectangle) {
                ((Rectangle) node).setStroke(color);
            }
        }
    }
}
