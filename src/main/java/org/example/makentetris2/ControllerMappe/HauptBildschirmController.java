package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Manager.GameManager;

import java.io.IOException;

public class HauptBildschirmController {
    GameManager gameManager;

    @FXML
    private Button bStart;
    @FXML
    private Button bEinstellungen;
    @FXML
    private Button bVerlassen;
    @FXML
    private JFXButton bShop;
    @FXML
    private JFXButton backButton;

    // Wechselt die Szene
    @FXML
    private void gameStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(6);
    }

    // Wechselt die Szene
    @FXML
    private void einstellungenStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(2);
    }

    // Wechselt die Szene
    @FXML
    private void minigameStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(3);
    }

    // Wechselt die Szene
    @FXML
    private void shopStarten() throws IOException {
        MakeNTetrisMain.szeneWechseln(7);
    }

    // Wechselt die Szene
    @FXML
    private void verlassen() {
        System.exit(0);
    }

    // Wechselt die Szene
    @FXML
    private void tutorial() throws  IOException {
        MakeNTetrisMain.szeneWechseln(8);
    }

    // Geht zurück zur vorherigen Szene
    @FXML
    private void zurueckButton() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
