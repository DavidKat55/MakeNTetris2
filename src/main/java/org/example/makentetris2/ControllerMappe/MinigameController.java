package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.makentetris2.Manager.SoundManager;
import javafx.scene.effect.Glow;

import java.io.File;
import java.util.Random;

public class MinigameController {
    Random rand = new Random();

    @FXML
    JFXButton rollButton;
    @FXML
    ImageView würfel;
    @FXML
    Label kontostand;
    @FXML
    JFXButton bSchwarz;
    @FXML
    JFXButton bRot;
    @FXML
    TextField einsatz;
    @FXML
    AnchorPane tippfarbe;

    private int startKontostand = 1000;

    Glow glowEffect = new Glow();

    boolean wette;
    boolean test = false;

    public void updateKontostand(int startkontostand) {
        Platform.runLater(() -> {
            kontostand.setText("Punktestand: " + startkontostand);
        });
    }

    @FXML
    void roll(ActionEvent event) {
     if(test != true || startKontostand <= 0 || startKontostand < Integer.parseInt(einsatz.getText()) || 0 >= Integer.parseInt(einsatz.getText())) {
         System.out.println("Fehler bei der Wette");
     } else {
         rollButton.setDisable(true);
         SoundManager.playSound("/sounds/gamble.mp3");
         Thread thread = new Thread() {
             public void run() {
                 System.out.println("Thread Running");
                 try {
                     for (int i = 0; i < 15; i++) {
                         File file = new File("src/main/resources/images/Würfel/dice" + (rand.nextInt(6) + 1) + ".png");
                         würfel.setImage(new Image(file.toURI().toString()));
                         Thread.sleep(93);
                     }

                     checkWinOrLose(wette);
                     rollButton.setDisable(false);
                     Thread.sleep(900);
                     SoundManager.playBackgroundMusic("/sounds/casino.mp3");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         };
         thread.start();
     }
    }

    @FXML
    void setzeRot(ActionEvent event) {
        wette = true;
        test = true;
        tippfarbe.setStyle("-fx-background-color: red");
        glowEffect.setLevel(0.8);
        tippfarbe.setEffect(glowEffect);

    }

    @FXML
    void setzeSchwarz(ActionEvent event) {
        wette = false;
        test = true;
        tippfarbe.setStyle("-fx-background-color: black");
        glowEffect.setLevel(0.8);
        tippfarbe.setEffect(glowEffect);

    }

    private int getRolledValue(String imageUrl) {
        if (imageUrl.contains("dice1.png")) return 1;
        if (imageUrl.contains("dice2.png")) return 2;
        if (imageUrl.contains("dice3.png")) return 3;
        if (imageUrl.contains("dice4.png")) return 4;
        if (imageUrl.contains("dice5.png")) return 5;
        if (imageUrl.contains("dice6.png")) return 6;
        return 0;
            }

    private void checkWinOrLose(boolean wette) {
        Image currentImage = würfel.getImage();
        if (currentImage != null) {
            String imageUrl = currentImage.getUrl();
            int rolledValue = getRolledValue(imageUrl);

            boolean resultColor = (rolledValue % 2 != 0);

            if (wette == resultColor) {
                int neuEinsatz = Integer.parseInt(einsatz.getText());
                startKontostand += neuEinsatz; // Gewinn
                updateKontostand(startKontostand);
                System.out.println("Gewonnen! Neuer Kontostand: " + startKontostand);
            } else {
                int neuEinsatz = Integer.parseInt(einsatz.getText());
                startKontostand -= neuEinsatz; // Verlust
                updateKontostand(startKontostand);
                System.out.println("Verloren! Neuer Kontostand: " + startKontostand);
            }
        }
    }
}
