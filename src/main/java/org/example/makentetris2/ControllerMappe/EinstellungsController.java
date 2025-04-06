package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Manager.SoundManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EinstellungsController implements Initializable, ChangeListener<Number> {

    public AnchorPane einstellungHintergrund;
    @FXML
    private JFXSlider regulierer;
    @FXML
    private JFXButton zEinstellungen;
    @FXML
    private TextField tPassword;

    LevelController levelController = MakeNTetrisMain.getLevelController();
    ShopController shopController = MakeNTetrisMain.getShopController();

    SoundManager soundManager = new SoundManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regulierer.valueProperty().addListener(this);

        // Setze die Lautstärke beim Start des Spiels
        regulierer.setValue(soundManager.loadVolume() * 100);  // Lade die Lautstärke und setze den Slider
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        double volume = regulierer.getValue() / 100.0;
        soundManager.getMediaPlayer().setVolume(volume);
        soundManager.saveVolume(volume);  // Speichere die neue Lautstärke
    }

    public void back() throws IOException {
        // Hier wird die Szene gewechselt, wenn der Shop geschlossen wird
        Stage stage = (Stage) zEinstellungen.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void resetLevels() {
        levelController.resetLevels();
    }

    @FXML
    private void resetSkins() {
        shopController.resetSkins();
    }

    @FXML
    public void unlockLevels() {
        String input = tPassword.getText();

        if (input.equals("unlock")) {
            levelController.unlockLevel();
            tPassword.setText("Levels freigeschaltet");
        } else {
            tPassword.setText("Falsches Passwort");
        }
    }
}
