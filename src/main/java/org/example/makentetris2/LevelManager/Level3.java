package org.example.makentetris2.LevelManager;
import javafx.util.Pair;

public class Level3 extends Level {
    @Override
    protected void initializeZielPositionen() {
        zielPositionen.add(new Pair<>(0, 15));
    }
}