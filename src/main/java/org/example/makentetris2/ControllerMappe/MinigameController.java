package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.*;
import java.util.Random;

import static org.example.makentetris2.MakeNTetrisMain.soundManager;

public class MinigameController {
    Random rand = new Random();

    @FXML
    private JFXButton zMinigame;
    @FXML
    private JFXButton rollButton;
    @FXML
    private ImageView würfel;
    @FXML
    private Label kontostand;
    @FXML
    private JFXButton bSchwarz;
    @FXML
    private JFXButton bRot;
    @FXML
    private TextField einsatz;

    private int startKontostand = 0;
    private static final String BALANCE_FILE = "balance.txt";

    Glow glowEffect = new Glow();

    boolean wette;
    boolean test = false;

    // Initialisiert den MinigameController und setzt die Szene
    public void initialize() {
        MakeNTetrisMain.setMinigameController(this);
        loadBalance();
        updateKontostand();
    }

    // Update der Punktestand-Anzeige
    public void updateKontostand() {
        Platform.runLater(() -> {
            kontostand.setText("Punktestand: " + startKontostand);
        });
    }

    // Rollen des Würfels
    @FXML
    void roll(ActionEvent event) {
        if (!test || startKontostand <= 0 || startKontostand < Integer.parseInt(einsatz.getText()) || Integer.parseInt(einsatz.getText()) <= 0) {
        } else {
            rollButton.setDisable(true);
            soundManager.playSound("/sounds/MinigameWin.mp3");
            Thread thread = new Thread() {
                public void run() {
                    try {
                        for (int i = 0; i < 15; i++) {
                            String imagePath = "/images/Würfel/dice" + (rand.nextInt(7)) + ".png";
                            würfel.setImage(new Image(getClass().getResource(imagePath).toString()));
                            Thread.sleep(93);
                        }
                        checkWinOrLose(wette);
                        rollButton.setDisable(false);
                        soundManager.playBackgroundMusic("/sounds/MinigameStart.mp3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

    // Setzt die Wette auf Rot oder Schwarz
    @FXML
    void setzeRot(ActionEvent event) {
        wette = true;
        test = true;
        rollButton.setStyle("-fx-background-color: red");
        glowEffect.setLevel(0.7);
        rollButton.setEffect(glowEffect);
    }

    // Setzt die Wette auf Schwarz
    @FXML
    void setzeSchwarz(ActionEvent event) {
        wette = false;
        test = true;
        rollButton.setStyle("-fx-background-color: black");
        glowEffect.setLevel(0.7);
        rollButton.setEffect(glowEffect);
    }

    // Gibt den geworfenen Wert zurück
    private int getRolledValue(String imageUrl) {
        for (int i = 0; i <= 6; i++) {  // Jetzt auch dice0.png
            if (imageUrl.contains("dice" + i + ".png")) return i;
        }
        return -1;
    }

    // Überprüft, ob gewonnen oder verloren wurde
    private void checkWinOrLose(boolean wette) {
        Image currentImage = würfel.getImage();
        if (currentImage != null) {
            String imageUrl = currentImage.getUrl();
            int rolledValue = getRolledValue(imageUrl);

            boolean resultColor = (rolledValue % 2 != 0);
            int neuEinsatz = Integer.parseInt(einsatz.getText());
            if (rolledValue == 0) {
                // Bei dice0 immer verlieren
                startKontostand -= neuEinsatz; // Verlust
            } else {
                if (wette == resultColor) {
                    startKontostand += (neuEinsatz); // Gewinn
                } else {
                    startKontostand -= neuEinsatz; // Verlust
                }
            }
            aktualisiereKontostand(startKontostand);
        }
    }

    // Aktualisiert den Kontostand
    public void aktualisiereKontostand(int neuerKontostand) {
        this.startKontostand = neuerKontostand;
        saveBalance();
        Platform.runLater(() -> {
            kontostand.setText("Punktestand: " + startKontostand);
        });
    }

    // Gibt den Kontostand zurück
    public int getStartKontostand() {
        return startKontostand;
    }

    // Speichert den Kontostand in die Datei
    private void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BALANCE_FILE))) {
            writer.write(String.valueOf(startKontostand));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lädt den Kontostand aus der Datei
    public void loadBalance() {
        File file = new File(BALANCE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                startKontostand = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    // Geht zurück zur Startseite
    public void back1() throws IOException {
        soundManager.stopMusic();
        soundManager.playBackgroundMusic("/sounds/Start.mp3");
        // Hier wird die Szene gewechselt, wenn der Shop geschlossen wird
        Stage stage = (Stage) zMinigame.getScene().getWindow();
        stage.close();
    }
}