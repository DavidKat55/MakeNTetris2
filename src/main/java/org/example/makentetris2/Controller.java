package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private Group block;
    @FXML
    private GridPane spielFeld;

    @FXML
    public void initialize() {
        KeyInputManager.setController(this);
    }

    public GridPane getSpielFeld() {
        return spielFeld;
    }

    public Group getBlock() {
        return block;
    }
}