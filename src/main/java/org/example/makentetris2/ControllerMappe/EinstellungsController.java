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

/**
 * EinstellungsController ist verantwortlich für die Verwaltung der Einstellungen im Spiel.
 * Er ermöglicht es dem Benutzer, die Lautstärke anzupassen und verschiedene Spieloptionen zurückzusetzen.
 */
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


    /**
     * Diese Methode wird aufgerufen, wenn die Szene initialisiert wird.
     * Hier wird der Lautstärkeregler mit dem aktuellen Lautstärkepegel geladen.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        regulierer.valueProperty().addListener(this);

        // Setze die Lautstärke beim Start des Spiels
        regulierer.setValue(soundManager.loadVolume() * 100);  // Lade die Lautstärke und setze den Slider
    }

    /**
     * Diese Methode wird aufgerufen, wenn sich der Wert des Lautstärkereglers ändert.
     * Hier wird die Lautstärke des SoundManagers aktualisiert.
     */
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        double volume = regulierer.getValue() / 100.0;
        soundManager.getMediaPlayer().setVolume(volume);
        soundManager.saveVolume(volume);  // Speichere die neue Lautstärke
    }

    /**
     * Diese Methode wird aufgerufen, wenn der Benutzer auf den "Zurück"-Button klickt.
     * Hier wird die aktuelle Szene geschlossen und die vorherige Szene angezeigt.
     */
    public void back() throws IOException {
        // Hier wird die Szene gewechselt, wenn der Shop geschlossen wird
        Stage stage = (Stage) zEinstellungen.getScene().getWindow();
        stage.close();
    }

    // Hier werden die Level zurückgesetzt
    @FXML
    public void resetLevels() {
        levelController.resetLevels();
    }

    // Hier werden die Skins zurückgesetzt
    @FXML
    private void resetSkins() {
        shopController.resetSkins();
    }

    // Hier wird der Shop zurückgesetzt
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
