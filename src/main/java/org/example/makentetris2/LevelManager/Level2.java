package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level2 extends Level {
    @Override
    protected void initializeZielPositionen() {
        zielPositionen.add(new Pair<>(15, 15));
    }
}