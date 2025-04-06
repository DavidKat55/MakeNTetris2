package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level10 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // O-Block
        zielPositionen.add(new Pair<>(7, 5));
        zielPositionen.add(new Pair<>(7, 6));
        zielPositionen.add(new Pair<>(8, 6));
        zielPositionen.add(new Pair<>(8, 5));

        // I-Block
        zielPositionen.add(new Pair<>(6, 5));
        zielPositionen.add(new Pair<>(6, 6));
        zielPositionen.add(new Pair<>(6, 7));
        zielPositionen.add(new Pair<>(6, 8));

        // T-Block
        zielPositionen.add(new Pair<>(1, 7));
        zielPositionen.add(new Pair<>(1, 8));
        zielPositionen.add(new Pair<>(1, 9));
        zielPositionen.add(new Pair<>(2, 8));

        // L-Block (orange)
        zielPositionen.add(new Pair<>(4, 4));
        zielPositionen.add(new Pair<>(5, 4));
        zielPositionen.add(new Pair<>(6, 4));
        zielPositionen.add(new Pair<>(6, 3));

        // J-Block (blue)
        zielPositionen.add(new Pair<>(6, 3));
        zielPositionen.add(new Pair<>(4, 4));
        zielPositionen.add(new Pair<>(5, 4));
        zielPositionen.add(new Pair<>(6, 4));

        // Z-Block (green)
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(9, 8));
        zielPositionen.add(new Pair<>(7, 9));
        zielPositionen.add(new Pair<>(8, 9));

        // Z-Block (red)
        zielPositionen.add(new Pair<>(3, 8));
        zielPositionen.add(new Pair<>(4, 8));
        zielPositionen.add(new Pair<>(4, 9));
        zielPositionen.add(new Pair<>(5, 9));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 35;
    }
}
