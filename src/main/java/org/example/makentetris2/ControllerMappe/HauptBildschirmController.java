package org.example.makentetris2.ControllerMappe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class HauptBildschirmController {

    @FXML
    private Button bStart;
    @FXML
    private Button bEinstellungen;
    @FXML
    private Button bVerlassen;



    @FXML
    private void gameStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(1);
    }

    @FXML
    private void einstellungenStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(2);
    }

    @FXML
    private void minigameStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(3);
    }

    @FXML
    private void verlassen() {
        System.exit(0);
    }
}
