package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level6 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // O-Block
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(9, 8));
        zielPositionen.add(new Pair<>(8, 7));
        zielPositionen.add(new Pair<>(9, 7));

        // I-Block
        zielPositionen.add(new Pair<>(3, 6));
        zielPositionen.add(new Pair<>(4, 6));
        zielPositionen.add(new Pair<>(5, 6));
        zielPositionen.add(new Pair<>(6, 6));

        // T-Block
        zielPositionen.add(new Pair<>(4, 4));
        zielPositionen.add(new Pair<>(5, 4));
        zielPositionen.add(new Pair<>(6, 4));
        zielPositionen.add(new Pair<>(5, 5));

        // L-Block (orange)
        zielPositionen.add(new Pair<>(8, 9));
        zielPositionen.add(new Pair<>(9, 9));
        zielPositionen.add(new Pair<>(9, 10));
        zielPositionen.add(new Pair<>(9, 11));

        // L-Block (blue)
        zielPositionen.add(new Pair<>(8, 5));
        zielPositionen.add(new Pair<>(9, 5));
        zielPositionen.add(new Pair<>(9, 4));
        zielPositionen.add(new Pair<>(9, 3));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(11, 5));
        zielPositionen.add(new Pair<>(10, 5));
        zielPositionen.add(new Pair<>(10, 6));
        zielPositionen.add(new Pair<>(9, 6));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(6, 5));
        zielPositionen.add(new Pair<>(7, 5));
        zielPositionen.add(new Pair<>(7, 6));
        zielPositionen.add(new Pair<>(8, 6));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 110;
    }
}