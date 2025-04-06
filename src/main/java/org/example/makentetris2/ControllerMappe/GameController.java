package org.example.makentetris2.ControllerMappe;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import org.example.makentetris2.LevelManager.*;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Manager.KeyInputManager;
import org.example.makentetris2.Timer.Time;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.makentetris2.MakeNTetrisMain.soundManager;

public class GameController implements Initializable {
    private KeyInputManager keyInputManager = MakeNTetrisMain.getKeyInputManager();
    @FXML
    private GridPane spielFeld;
    @FXML
    private ImageView levelView;

    private LevelManager levelManager;

    public GridPane getSpielFeld() {
        return spielFeld;
    }

    Time time = new Time(10, 10);

    @FXML
    private Text timer;

    @FXML
    private Text punkte;
    private int points = keyInputManager.getGewonnenePunkte();

    private Timeline timeline;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MakeNTetrisMain.setGameController(this);

        levelManager = MakeNTetrisMain.getLevelManager();
        updateLevelImage();

        punkte.setText(String.valueOf(points));

        setLevelTime();

        timer.setText(time.getCurrentTime());

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    if (time.isTimeUp()) {
                        System.out.println("Verloren!");
                        try {
                            MakeNTetrisMain.szeneWechseln(5);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        timeline.stop();
                    } else {
                        time.oneSecondPassed();
                        timer.setText(time.getCurrentTime());
                    }
                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        javafx.application.Platform.runLater(() -> {
            Button bZurueck1 = (Button) spielFeld.getScene().lookup("#bZurueck1");
            if (bZurueck1 != null) {
                bZurueck1.setFocusTraversable(false);
            }

            // Optional: Das Spielfeld fokussieren
            spielFeld.requestFocus();
        });
    }

    public void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setLevelTime() {
        int levelZeit = levelManager.getCurrentLevel().getLevelZeit();
        setTime(new Time(levelZeit / 60, levelZeit % 60));
    }

    public void updateLevelImage() {
        int currentLevel = levelManager.getCurrentLevelIndex() + 1;
        String imagePath = "/images/Level/Level" + currentLevel + ".png";
        InputStream imageStream = getClass().getResourceAsStream(imagePath);

        if (imageStream == null) {
            System.err.println("Image not found: " + imagePath);
            return;
        }

        Image image = new Image(imageStream);
        levelView.setImage(image);
    }

    public void zurueckButton() throws IOException {
        soundManager.stopMusic();
        soundManager.playBackgroundMusic("/sounds/Start.mp3");
        MakeNTetrisMain.szeneWechseln(6);
    }

    public void setPoints(int points) {
        this.points = points;
        punkte.setText(String.valueOf(points));
    }

    public int getPoints() {
        return points;
    }
}