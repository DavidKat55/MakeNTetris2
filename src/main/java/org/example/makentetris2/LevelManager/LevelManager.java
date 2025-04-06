package org.example.makentetris2.LevelManager;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private List<Level> availableLevels;
    private int currentLevelIndex = 0;

    public LevelManager() {
        availableLevels = new ArrayList<>();
        // Alle Level hinzufügen
        availableLevels.add(new Level1());
        availableLevels.add(new Level2());
        availableLevels.add(new Level3());
        availableLevels.add(new Level4());
        availableLevels.add(new Level5());
        availableLevels.add(new Level6());
        availableLevels.add(new Level7());
        availableLevels.add(new Level8());
        availableLevels.add(new Level9());
        availableLevels.add(new Level10());
        // Weitere Level hier hinzufügen
    }

    // Diese Methode gibt das aktuelle Level zurück
    public Level getCurrentLevel() {
        // Ensure the currentLevelIndex is within valid bounds
        if (currentLevelIndex < 0) {
            currentLevelIndex = 0;
        } else if (currentLevelIndex >= availableLevels.size()) {
            currentLevelIndex = availableLevels.size() - 1;
        }
        return availableLevels.get(currentLevelIndex);
    }

    // Diese Methode wird aufgerufen, wenn der Spieler das aktuelle Level abschließt
    public void nextLevel() {
        if (currentLevelIndex < availableLevels.size() - 1) {
            currentLevelIndex++;
        } else {

        }
    }

    // Diese Methode wird aufgerufen, wenn der Spieler ein Level auswählt
    public void selectLevel(int index) {
        if (index >= 0 && index < availableLevels.size()) {
            currentLevelIndex = index;
        }
    }

    public List<Level> getAllLevels() {
        return availableLevels;
    }

    public int getCurrentLevelIndex() {
        return currentLevelIndex;
    }

    public int getNumberOfLevels() {
        return availableLevels.size();
    }

    public void setCurrentLevelIndex(int currentLevelIndex) {
        this.currentLevelIndex = currentLevelIndex;
    }
}
