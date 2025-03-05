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
        // Weitere Level hier hinzufügen
    }

    public Level getCurrentLevel() {
        return availableLevels.get(currentLevelIndex);
    }

    public void nextLevel() {
        if (currentLevelIndex < availableLevels.size() - 1) {
            currentLevelIndex++;
        }
    }

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
}
