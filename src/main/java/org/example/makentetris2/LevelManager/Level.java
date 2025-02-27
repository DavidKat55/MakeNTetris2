package org.example.makentetris2.LevelManager;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Pair<Integer, Integer>> zielPositionen;

    public Level() {
        zielPositionen = new ArrayList<>();
        // Beispiel für Zielpositionen

        // O-Block
        zielPositionen.add(new Pair<>(9, 15));
        zielPositionen.add(new Pair<>(8, 15));
        zielPositionen.add(new Pair<>(9, 14));
        zielPositionen.add(new Pair<>(8, 14));

        //I-Block
        zielPositionen.add(new Pair<>(7, 15));
        zielPositionen.add(new Pair<>(7, 14));
        zielPositionen.add(new Pair<>(7, 13));
        zielPositionen.add(new Pair<>(7, 12));

        //T-Block
        zielPositionen.add(new Pair<>(7, 11));
        zielPositionen.add(new Pair<>(7, 10));
        zielPositionen.add(new Pair<>(6, 10));
        zielPositionen.add(new Pair<>(8, 10));

        //L-Block (orange)
        zielPositionen.add(new Pair<>(5, 10));
        zielPositionen.add(new Pair<>(5, 11));
        zielPositionen.add(new Pair<>(4, 11));
        zielPositionen.add(new Pair<>(3, 11));

        //L-Block (blau)
        zielPositionen.add(new Pair<>(9, 10));
        zielPositionen.add(new Pair<>(9, 11));
        zielPositionen.add(new Pair<>(10, 11));
        zielPositionen.add(new Pair<>(11, 11));

        //Z-Block (grün)
        zielPositionen.add(new Pair<>(5, 9));
        zielPositionen.add(new Pair<>(4, 9));
        zielPositionen.add(new Pair<>(5, 8));
        zielPositionen.add(new Pair<>(6, 8));
        //Z-Block (rot)
        zielPositionen.add(new Pair<>(9, 9));
        zielPositionen.add(new Pair<>(9, 8));
        zielPositionen.add(new Pair<>(8, 8));
        zielPositionen.add(new Pair<>(10, 9));




    }

    public List<Pair<Integer, Integer>> getZielPositionen() {
        return zielPositionen;
    }
}