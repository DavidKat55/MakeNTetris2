package org.example.makentetris2.LevelManager;

import javafx.util.Pair;
import org.example.makentetris2.ControllerMappe.GameController;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected List<Pair<Integer, Integer>> zielPositionen;
    protected int levelZeit;

    public Level() {
        zielPositionen = new ArrayList<>();
        initializeZielPositionen();
        setLevelZeit();
    }

    // Diese Methode muss von Unterklassen implementiert werden
    protected abstract void initializeZielPositionen();
    protected abstract void setLevelZeit();

    public List<Pair<Integer, Integer>> getZielPositionen() {
        return zielPositionen;
    }
    public int getLevelZeit() {
        return levelZeit;
    }


}
