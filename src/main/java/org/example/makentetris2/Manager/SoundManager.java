package org.example.makentetris2.Manager;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;
import java.util.Objects;

public class SoundManager {
    private static MediaPlayer mediaPlayer;

    public void playBackgroundMusic(String fileName) {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media media = new Media(Objects.requireNonNull(getClass().getResource(fileName)).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void playSound(String fileName) {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media media = new Media(Objects.requireNonNull(getClass().getResource(fileName)).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }



    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}

