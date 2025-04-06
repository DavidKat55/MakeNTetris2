package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level9 extends Level {
    @Override
    protected void initializeZielPositionen() {

        // O-Block richtig
        zielPositionen.add(new Pair<>(3, 1));
        zielPositionen.add(new Pair<>(4, 1));
        zielPositionen.add(new Pair<>(3, 2));
        zielPositionen.add(new Pair<>(4, 2));

        // I-Block richtig
        zielPositionen.add(new Pair<>(8, 11));
        zielPositionen.add(new Pair<>(8, 10));
        zielPositionen.add(new Pair<>(8, 9));
        zielPositionen.add(new Pair<>(8, 8));

        // T-Block richtig
        zielPositionen.add(new Pair<>(7, 15));
        zielPositionen.add(new Pair<>(8, 15));
        zielPositionen.add(new Pair<>(9, 15));
        zielPositionen.add(new Pair<>(8, 14));

        // L-Block (orange) richtig
        zielPositionen.add(new Pair<>(14, 3));
        zielPositionen.add(new Pair<>(14, 4));
        zielPositionen.add(new Pair<>(13, 4));
        zielPositionen.add(new Pair<>(12, 4));

        // L-Block (blue)
        zielPositionen.add(new Pair<>(1, 4));
        zielPositionen.add(new Pair<>(1, 5));
        zielPositionen.add(new Pair<>(2, 5));
        zielPositionen.add(new Pair<>(3, 5));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(6, 6));
        zielPositionen.add(new Pair<>(7, 6));
        zielPositionen.add(new Pair<>(7, 5));
        zielPositionen.add(new Pair<>(8, 5));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(7, 1));
        zielPositionen.add(new Pair<>(8, 1));
        zielPositionen.add(new Pair<>(8, 2));
        zielPositionen.add(new Pair<>(9, 2));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 40;
    }
}
