package org.example.makentetris2.Manager;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.*;
import java.util.Objects;

public class SoundManager {
    private static MediaPlayer mediaPlayer;
    private static final String VOLUME_FILE = "volume.txt";

    public void playBackgroundMusic(String fileName) {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media media = new Media(Objects.requireNonNull(getClass().getResource(fileName)).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(loadVolume());
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

    // Methode zum Speichern der Lautstärke in einer Datei
    public static void saveVolume(double volume) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(VOLUME_FILE))) {
            writer.write(String.valueOf(volume));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode zum Laden der Lautstärke aus der Datei
    public static double loadVolume() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(VOLUME_FILE));
            String volumeString = reader.readLine();
            return volumeString != null ? Double.parseDouble(volumeString) : 0.5; // Standardwert 0.5
        } catch (IOException e) {
            e.printStackTrace();
            return 0.5; // Standardwert bei Fehler
        }
    }

}

