package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level7 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // Level 3 – Horizontal-Chaos
        zielPositionen.add(new Pair<>(10, 6)); // O
        zielPositionen.add(new Pair<>(10, 7));
        zielPositionen.add(new Pair<>(11, 6));
        zielPositionen.add(new Pair<>(11, 7));

        zielPositionen.add(new Pair<>(12, 8)); // I
        zielPositionen.add(new Pair<>(11, 8));
        zielPositionen.add(new Pair<>(10, 8));
        zielPositionen.add(new Pair<>(9, 8));

        zielPositionen.add(new Pair<>(5, 7)); // T
        zielPositionen.add(new Pair<>(5, 8));
        zielPositionen.add(new Pair<>(5, 9));
        zielPositionen.add(new Pair<>(6, 8));

        zielPositionen.add(new Pair<>(12, 7)); // L
        zielPositionen.add(new Pair<>(12, 6));
        zielPositionen.add(new Pair<>(12, 5));
        zielPositionen.add(new Pair<>(11, 5));

        zielPositionen.add(new Pair<>(9, 7)); // J
        zielPositionen.add(new Pair<>(9, 6));
        zielPositionen.add(new Pair<>(9, 5));
        zielPositionen.add(new Pair<>(10, 5));

        zielPositionen.add(new Pair<>(14, 8)); // S
        zielPositionen.add(new Pair<>(13, 8));
        zielPositionen.add(new Pair<>(13, 9));
        zielPositionen.add(new Pair<>(12, 9));

        zielPositionen.add(new Pair<>(7, 8)); // Z
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(8, 9));
        zielPositionen.add(new Pair<>(9, 9));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 100;
    }
}