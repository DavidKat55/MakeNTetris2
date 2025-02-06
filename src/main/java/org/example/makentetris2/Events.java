package org.example.makentetris2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Events {

    public int[] getBlockPosition(Group block, GridPane spielFeld) {
        Integer column = GridPane.getColumnIndex(block);
        Integer row = GridPane.getRowIndex(block);
        return new int[]{column != null ? column : -1, row != null ? row : -1};
    }

    public void setBlockPosition(int column, int row, Group block, GridPane spielFeld) {
        GridPane.setColumnIndex(block, column);
        GridPane.setRowIndex(block, row);
    }

    public void moveBlockDown(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newRow = position[1] + 1;
        if (!checkCollision(spielFeld, position[0], newRow)) {
            setBlockPosition(position[0], newRow, block, spielFeld);
        }
    }

    public void moveBlockLeft(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newColumn = position[0] - 1;
        if (!checkCollision(spielFeld, newColumn, position[1])) {
            setBlockPosition(newColumn, position[1], block, spielFeld);
        }
    }

    public void moveBlockRight(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newColumn = position[0] + 1;
        if (!checkCollision(spielFeld, newColumn, position[1])) {
            setBlockPosition(newColumn, position[1], block, spielFeld);
        }
    }

    public void moveBlockUp(Group block, GridPane spielFeld) {
        int[] position = getBlockPosition(block, spielFeld);
        int newRow = position[1] - 1;
        if (!checkCollision(spielFeld, position[0], newRow)) {
            setBlockPosition(position[0], newRow, block, spielFeld);
        }
    }

    public void rotateBlock(Group block, GridPane spielFeld) {
        if (block.getId() != null && block.getId().equals("block5")) {
            return; // Do not rotate block5
        }
        block.setRotate(block.getRotate() + 90);
    }

    public void changeBlockStrokeColor(Group block, javafx.scene.paint.Color color) {
        for (Node node : block.getChildren()) {
            if (node instanceof Rectangle) {
                ((Rectangle) node).setStroke(color);
            }
        }
    }

    public boolean checkCollision(GridPane spielFeld, int column, int row) {
        for (Node node : spielFeld.getChildren()) {
            Integer nodeColumn = GridPane.getColumnIndex(node);
            Integer nodeRow = GridPane.getRowIndex(node);
            if (nodeColumn != null && nodeRow != null && nodeColumn == column && nodeRow == row && node instanceof Group) {
                Group group = (Group) node;
                for (Node child : group.getChildren()) {
                    if (child instanceof Rectangle) {
                        System.out.println("Collision detected");
                        return true; // Collision detected
                    }
                }
            }
        }
        System.out.println("Collision not detected");
        return false; // No collision
    }
}