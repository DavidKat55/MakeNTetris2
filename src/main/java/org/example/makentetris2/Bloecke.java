package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class Bloecke {

    @FXML
    private Rectangle blooock;

    public Bloecke() {
        blooock = new Rectangle();
    }

    public Bloecke(Rectangle block) {
        this.blooock = block;
    }

    public void setBlooock(Rectangle blooock) {
        this.blooock = blooock;
    }
    public Rectangle getBlooock() {
        return blooock;
    }

}
