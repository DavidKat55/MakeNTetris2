package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Controller {

    private Rectangle block;
    private Bloecke bloecke = new Bloecke(block);
    private Events events;
    private int x = 0;
    private int y = 0;

    @FXML
    public void initialize() {
        block = bloecke.getBlooock();
        events = new Events();
        events.moveBlock();
    }

}