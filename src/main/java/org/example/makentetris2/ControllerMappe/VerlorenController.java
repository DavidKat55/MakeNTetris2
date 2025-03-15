package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class VerlorenController {

    @FXML
    private JFXButton vNeu;

    public void NeuStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(1);
    }


}