package org.example.makentetris2.ControllerMappe;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane spielFeld;

    @FXML
    public void initialize() {
    }

    public GridPane getSpielFeld() {
        return spielFeld;
    }
}