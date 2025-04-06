package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level5 extends Level {
    @Override
    protected void initializeZielPositionen() {

        // Funktioniert noch nicht keine Idee warum

        // O-Block richtig
        zielPositionen.add(new Pair<>(9, 11));
        zielPositionen.add(new Pair<>(10, 11));
        zielPositionen.add(new Pair<>(9, 10));
        zielPositionen.add(new Pair<>(10, 10));

        // I-Block richtig
        zielPositionen.add(new Pair<>(5, 11));
        zielPositionen.add(new Pair<>(6, 11));
        zielPositionen.add(new Pair<>(7, 11));
        zielPositionen.add(new Pair<>(8, 11));

        // T-Block richtig
        zielPositionen.add(new Pair<>(6, 8));
        zielPositionen.add(new Pair<>(7, 8));
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(7, 7));

        // L-Block (orange) richtig
        zielPositionen.add(new Pair<>(3, 5));
        zielPositionen.add(new Pair<>(4, 5));
        zielPositionen.add(new Pair<>(5, 5));
        zielPositionen.add(new Pair<>(5, 4));

        // L-Block (blue) richtig
        zielPositionen.add(new Pair<>(11, 5));
        zielPositionen.add(new Pair<>(10, 5));
        zielPositionen.add(new Pair<>(9, 5));
        zielPositionen.add(new Pair<>(9, 4));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(2, 4));
        zielPositionen.add(new Pair<>(3, 4));
        zielPositionen.add(new Pair<>(3, 3));
        zielPositionen.add(new Pair<>(4, 3));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(12, 4));
        zielPositionen.add(new Pair<>(11, 4));
        zielPositionen.add(new Pair<>(11, 3));
        zielPositionen.add(new Pair<>(10, 3));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 120;
    }
}
