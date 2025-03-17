package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level2 extends Level {
    @Override
    protected void initializeZielPositionen() {
        //zielPositionen.add(new Pair<>(15, 15));

        // O-Block
        zielPositionen.add(new Pair<>(1, 11));
        zielPositionen.add(new Pair<>(2, 11));
        zielPositionen.add(new Pair<>(1, 12));
        zielPositionen.add(new Pair<>(2, 12));

// I-Block
        zielPositionen.add(new Pair<>(0, 8));
        zielPositionen.add(new Pair<>(1, 8));
        zielPositionen.add(new Pair<>(2, 8));
        zielPositionen.add(new Pair<>(3, 8));

// T-Block
        zielPositionen.add(new Pair<>(4, 8));
        zielPositionen.add(new Pair<>(4, 9));
        zielPositionen.add(new Pair<>(5, 9));
        zielPositionen.add(new Pair<>(4, 10));

// L-Block (orange)
        zielPositionen.add(new Pair<>(2, 9));
        zielPositionen.add(new Pair<>(3, 9));
        zielPositionen.add(new Pair<>(3, 10));
        zielPositionen.add(new Pair<>(3, 11));

// L-Block (blue)
        zielPositionen.add(new Pair<>(0, 9));
        zielPositionen.add(new Pair<>(1, 9));
        zielPositionen.add(new Pair<>(0, 10));
        zielPositionen.add(new Pair<>(0, 11));

// Z-Block (green)
        zielPositionen.add(new Pair<>(2, 13));
        zielPositionen.add(new Pair<>(2, 14));
        zielPositionen.add(new Pair<>(3, 14));
        zielPositionen.add(new Pair<>(3, 15));

// Z-Block (red)
        zielPositionen.add(new Pair<>(0, 15));
        zielPositionen.add(new Pair<>(0, 14));
        zielPositionen.add(new Pair<>(1, 14));
        zielPositionen.add(new Pair<>(1, 13));
    }


}