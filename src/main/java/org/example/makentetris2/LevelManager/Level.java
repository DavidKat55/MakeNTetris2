package org.example.makentetris2.LevelManager;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected List<Pair<Integer, Integer>> zielPositionen;

    public Level() {
        zielPositionen = new ArrayList<>();
        initializeZielPositionen();
    }

    // Diese Methode muss von Unterklassen implementiert werden
    protected abstract void initializeZielPositionen();

    public List<Pair<Integer, Integer>> getZielPositionen() {
        return zielPositionen;
    }
}
