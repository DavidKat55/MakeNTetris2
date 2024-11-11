package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Rectangle block;
    @FXML
    private GridPane spielFeld;
    private Events events;

    @FXML
    public void initialize() {
        events = new Events();
        events.setBlockPosition(5, 0, block, spielFeld);
    }
}