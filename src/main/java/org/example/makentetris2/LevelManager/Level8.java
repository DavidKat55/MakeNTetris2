package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level8 extends Level {
    @Override
    protected void initializeZielPositionen() {
        // Z-Block (grün)
        zielPositionen.add(new Pair<>(1, 2));
        zielPositionen.add(new Pair<>(2, 2));
        zielPositionen.add(new Pair<>(2, 1));
        zielPositionen.add(new Pair<>(3, 1));

// Z-Block (rot)
        zielPositionen.add(new Pair<>(14, 2));
        zielPositionen.add(new Pair<>(13, 2));
        zielPositionen.add(new Pair<>(13, 1));
        zielPositionen.add(new Pair<>(12, 1));

// L-Block (blau)
        zielPositionen.add(new Pair<>(1, 13));
        zielPositionen.add(new Pair<>(1, 14));
        zielPositionen.add(new Pair<>(2, 14));
        zielPositionen.add(new Pair<>(3, 14));

// L-Block (orange)
        zielPositionen.add(new Pair<>(12, 14));
        zielPositionen.add(new Pair<>(13, 14));
        zielPositionen.add(new Pair<>(14, 14));
        zielPositionen.add(new Pair<>(14, 13));

// O-Block (gelb)
        zielPositionen.add(new Pair<>(7, 7));
        zielPositionen.add(new Pair<>(8, 7));
        zielPositionen.add(new Pair<>(7, 8));
        zielPositionen.add(new Pair<>(8, 8));

// T-Block (lila)
        zielPositionen.add(new Pair<>(9, 8));
        zielPositionen.add(new Pair<>(10, 8));
        zielPositionen.add(new Pair<>(11, 8));
        zielPositionen.add(new Pair<>(10, 9));

// I-Block (cyan)
        zielPositionen.add(new Pair<>(6, 7));
        zielPositionen.add(new Pair<>(6, 6));
        zielPositionen.add(new Pair<>(6, 5));
        zielPositionen.add(new Pair<>(6, 4));
    }

    @Override
    protected void setLevelZeit() {
        levelZeit = 1;
    }
}