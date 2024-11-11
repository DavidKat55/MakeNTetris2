package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Rectangle block;

    private Bloecke bloecke;
    private Events events;
    private int x;
    private int y;

    @FXML
    public void initialize() {
        bloecke = new Bloecke(block);
        Events events = new Events();
        events.moveUp(block);
    }



    @FXML
    public void movement() {

    }
}