package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

import static org.example.makentetris2.MakeNTetrisMain.soundManager;

public class VerlorenController {

    @FXML
    private JFXButton vNeu;

    @FXML
    private JFXButton bVerloren;

    public void NeuStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(1);
    }

    public void back() throws IOException {
        soundManager.stopMusic();
        soundManager.playBackgroundMusic("/sounds/Start.mp3");
        // Hier wird die Szene gewechselt, wenn der Shop geschlossen wird
        Stage stage = (Stage) bVerloren.getScene().getWindow();
        stage.close();
    }


}