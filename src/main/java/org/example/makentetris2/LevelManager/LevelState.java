package org.example.makentetris2.LevelManager;

public class LevelState {
    private static LevelState instance;
    private boolean level2Unlocked = false;
    private boolean level3Unlocked = false;

    private LevelState() {}

    public static LevelState getInstance() {
        if (instance == null) {
            instance = new LevelState();
        }
        return instance;
    }

    public boolean isLevel2Unlocked() {
        return level2Unlocked;
    }

    public void setLevel2Unlocked(boolean level2Unlocked) {
        this.level2Unlocked = level2Unlocked;
    }

    public boolean isLevel3Unlocked() {
        return level3Unlocked;
    }

    public void setLevel3Unlocked(boolean level3Unlocked) {
        this.level3Unlocked = level3Unlocked;
    }
}
