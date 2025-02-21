package org.example.makentetris2.Manager;

import com.jfoenix.controls.JFXSlider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;


public class SoundManager {
    private static MediaPlayer mediaPlayer;

    public static void playBackgroundMusic(String fileName) {
        stopMusic();
        URL path = SoundManager.class.getResource(fileName);
        System.out.println(path);
        assert path != null;
        Media media = new Media(path.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.setCycleCount (MediaPlayer.INDEFINITE) ;
        mediaPlayer.play();
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}

