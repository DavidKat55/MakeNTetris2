package org.example.makentetris2.ControllerMappe;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import org.example.makentetris2.LevelManager.*;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Timer.Time;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private GridPane spielFeld;
    @FXML
    private ImageView levelView;

    private LevelManager levelManager;

    public GridPane getSpielFeld() {
        return spielFeld;
    }

    Time time = new Time(1, 0);

    @FXML
    private Text timer;

    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        levelManager = MakeNTetrisMain.getLevelManager();
        updateLevelImage();

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
    }

    public void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
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
}