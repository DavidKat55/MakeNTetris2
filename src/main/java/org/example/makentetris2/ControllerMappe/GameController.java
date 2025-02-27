package org.example.makentetris2.ControllerMappe;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import org.example.makentetris2.MakeNTetrisMain;
import org.example.makentetris2.Timer.Time;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private GridPane spielFeld;

    @FXML
    public void initialize() {
    }

    public GridPane getSpielFeld() {
        return spielFeld;
    }

    Time time = new Time(1, 0);

    @FXML
    private Text timer;

    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
}