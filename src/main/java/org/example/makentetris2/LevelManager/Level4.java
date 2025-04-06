package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level4 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // O-Block
        zielPositionen.add(new Pair<>(4, 12));
        zielPositionen.add(new Pair<>(5, 12));
        zielPositionen.add(new Pair<>(4, 11));
        zielPositionen.add(new Pair<>(5, 11));

        // I-Block
        zielPositionen.add(new Pair<>(3, 9));
        zielPositionen.add(new Pair<>(4, 9));
        zielPositionen.add(new Pair<>(5, 9));
        zielPositionen.add(new Pair<>(6, 9));

        // T-Block
        zielPositionen.add(new Pair<>(8, 13));
        zielPositionen.add(new Pair<>(8, 12));
        zielPositionen.add(new Pair<>(8, 11));
        zielPositionen.add(new Pair<>(9, 12));

        // L-Block (orange)
        zielPositionen.add(new Pair<>(2, 13));
        zielPositionen.add(new Pair<>(3, 13));
        zielPositionen.add(new Pair<>(2, 12));
        zielPositionen.add(new Pair<>(2, 11));

        // L-Block (blue)
        zielPositionen.add(new Pair<>(3, 12));
        zielPositionen.add(new Pair<>(3, 11));
        zielPositionen.add(new Pair<>(3, 10));
        zielPositionen.add(new Pair<>(4, 10));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(5, 13));
        zielPositionen.add(new Pair<>(6, 13));
        zielPositionen.add(new Pair<>(6, 12));
        zielPositionen.add(new Pair<>(7, 12));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(5, 10));
        zielPositionen.add(new Pair<>(6, 10));
        zielPositionen.add(new Pair<>(6, 11));
        zielPositionen.add(new Pair<>(7, 11));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 130;
    }
}