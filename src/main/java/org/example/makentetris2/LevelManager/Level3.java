package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level3 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // O-Block
        zielPositionen.add(new Pair<>(8, 15));
        zielPositionen.add(new Pair<>(7, 15));
        zielPositionen.add(new Pair<>(8, 14));
        zielPositionen.add(new Pair<>(7, 14));

        // I-Block
        zielPositionen.add(new Pair<>(8, 13));
        zielPositionen.add(new Pair<>(7, 13));
        zielPositionen.add(new Pair<>(6, 13));
        zielPositionen.add(new Pair<>(9, 13));

        // T-Block
        zielPositionen.add(new Pair<>(7, 11));
        zielPositionen.add(new Pair<>(6, 11));
        zielPositionen.add(new Pair<>(8, 11));
        zielPositionen.add(new Pair<>(7, 10));

        // L-Block (orange)
        zielPositionen.add(new Pair<>(6, 15));
        zielPositionen.add(new Pair<>(5, 15));
        zielPositionen.add(new Pair<>(5, 14));
        zielPositionen.add(new Pair<>(5, 13));

        // L-Block (blue)
        zielPositionen.add(new Pair<>(9, 15));
        zielPositionen.add(new Pair<>(10, 15));
        zielPositionen.add(new Pair<>(10, 14));
        zielPositionen.add(new Pair<>(10, 13));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(2, 15));
        zielPositionen.add(new Pair<>(3, 15));
        zielPositionen.add(new Pair<>(3, 14));
        zielPositionen.add(new Pair<>(4, 14));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(13, 15));
        zielPositionen.add(new Pair<>(12, 15));
        zielPositionen.add(new Pair<>(12, 14));
        zielPositionen.add(new Pair<>(11, 14));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 240;
    }
}