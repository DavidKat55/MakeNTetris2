package org.example.makentetris2.LevelManager;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Pair<Integer, Integer>> zielPositionen;

    public Level() {
        zielPositionen = new ArrayList<>();
        // Beispiel für Zielpositionen
        zielPositionen.add(new Pair<>(0, 0));
        zielPositionen.add(new Pair<>(1, 0));
        zielPositionen.add(new Pair<>(2, 0));
        zielPositionen.add(new Pair<>(1, 1));
    }

    public List<Pair<Integer, Integer>> getZielPositionen() {
        return zielPositionen;
    }
}