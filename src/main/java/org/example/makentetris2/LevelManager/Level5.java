package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level5 extends Level {
    @Override
    protected void initializeZielPositionen() {

        // Funktioniert noch nicht keine Idee warum

        // O-Block
        zielPositionen.add(new Pair<>(9, 11));
        zielPositionen.add(new Pair<>(10, 11));
        zielPositionen.add(new Pair<>(9, 10));
        zielPositionen.add(new Pair<>(10, 10));

        // I-Block
        zielPositionen.add(new Pair<>(5, 11));
        zielPositionen.add(new Pair<>(6, 11));
        zielPositionen.add(new Pair<>(7, 11));
        zielPositionen.add(new Pair<>(8, 11));

        // T-Block
        zielPositionen.add(new Pair<>(6, 8));
        zielPositionen.add(new Pair<>(7, 8));
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(7, 7));

        // L-Block (orange)
        zielPositionen.add(new Pair<>(3, 5));
        zielPositionen.add(new Pair<>(4, 5));
        zielPositionen.add(new Pair<>(5, 5));
        zielPositionen.add(new Pair<>(5, 4));

        // L-Block (blue)
        zielPositionen.add(new Pair<>(11, 5));
        zielPositionen.add(new Pair<>(12, 5));
        zielPositionen.add(new Pair<>(13, 5));
        zielPositionen.add(new Pair<>(13, 4));

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
}
