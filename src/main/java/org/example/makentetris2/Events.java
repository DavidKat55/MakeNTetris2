package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Events {

    public int[] getBlockPosition(Rectangle block, GridPane spielFeld) {
        Integer column = GridPane.getColumnIndex(block);
        Integer row = GridPane.getRowIndex(block);
        return new int[]{column != null ? column : -1, row != null ? row : -1};
    }

    public void setBlockPosition(int column, int row, Rectangle block, GridPane spielFeld) {
        spielFeld.setColumnIndex(block, column);
        spielFeld.setRowIndex(block, row);
    }
}
