package org.example.makentetris2.ControllerMappe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.MakeNTetrisMain;
import java.io.IOException;
import java.util.prefs.Preferences;

public class LevelController {

    @FXML
    private Button bLevel1, bLevel2, bLevel3, bLevel4, bLevel5, bLevel6, bLevel7, bLevel8, bLevel9, bLevel10;
    @FXML
    private Button bReset;
    @FXML
    private Button bUnlock;

    private LevelManager levelManager;
    private Preferences prefs;

    // Initialisiert den LevelController und die Buttons
    public void initialize() {
        MakeNTetrisMain.setLevelController(this);

        prefs = Preferences.userNodeForPackage(LevelController.class);

        // Setzen der Buttons
        bLevel2.setDisable(!prefs.getBoolean("level2Unlocked", false));
        bLevel3.setDisable(!prefs.getBoolean("level3Unlocked", false));
        bLevel4.setDisable(!prefs.getBoolean("level4Unlocked", false));
        bLevel5.setDisable(!prefs.getBoolean("level5Unlocked", false));
        bLevel6.setDisable(!prefs.getBoolean("level6Unlocked", false));
        bLevel7.setDisable(!prefs.getBoolean("level7Unlocked", false));
        bLevel8.setDisable(!prefs.getBoolean("level8Unlocked", false));
        bLevel9.setDisable(!prefs.getBoolean("level9Unlocked", false));
        bLevel10.setDisable(!prefs.getBoolean("level10Unlocked", false));

        levelManager = MakeNTetrisMain.getLevelManager();

        // Setzen der ActionListener für die Buttons
        bLevel1.setOnAction(e -> {
            try {
                levelManager.setCurrentLevelIndex(0);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        bLevel2.setOnAction(e -> {
            try {
                levelManager.selectLevel(1);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        bLevel3.setOnAction(e -> {
            try {
                levelManager.selectLevel(2);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        bLevel4.setOnAction(e -> {
            try {
                levelManager.selectLevel(3);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        bLevel5.setOnAction(e -> {
            try {
                levelManager.selectLevel(4);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        bLevel6.setOnAction(e -> {
            try {
                levelManager.selectLevel(5);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        bLevel7.setOnAction(e -> {
            try {
                levelManager.selectLevel(6);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        bLevel8.setOnAction(e -> {
            try {
                levelManager.selectLevel(7);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        bLevel9.setOnAction(e -> {
            try {
                levelManager.selectLevel(8);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        bLevel10.setOnAction(e -> {
            try {
                levelManager.selectLevel(9);
                MakeNTetrisMain.szeneWechseln(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    // enableLevelButtons() wird aufgerufen, wenn ein Level erfolgreich abgeschlossen wurde
    public void enableLevelButtons(int levelIndex) {
        System.out.println("Enabling level buttons for level index: " + levelIndex);
        switch (levelIndex) {
            case 1:
                bLevel2.setDisable(false);
                prefs.putBoolean("level2Unlocked", true);
                break;
            case 2:
                bLevel3.setDisable(false);
                prefs.putBoolean("level3Unlocked", true);
                break;
            case 3:
                bLevel4.setDisable(false);
                prefs.putBoolean("level4Unlocked", true);
                break;
            case 4:
                bLevel5.setDisable(false);
                prefs.putBoolean("level5Unlocked", true);
                break;
            case  5:
                bLevel6.setDisable(false);
                prefs.putBoolean("level6Unlocked", true);
                break;
            case 6:
                bLevel7.setDisable(false);
                prefs.putBoolean("level7Unlocked", true);
                break;
            case 7:
                bLevel8.setDisable(false);
                prefs.putBoolean("level8Unlocked", true);
                break;
            default:
                System.out.println("Invalid level index: " + levelIndex);
        }
    }

    // Reset der Level
    public void resetLevels() {
        bLevel2.setDisable(true);
        bLevel3.setDisable(true);
        bLevel4.setDisable(true);
        bLevel5.setDisable(true);
        bLevel6.setDisable(true);
        bLevel7.setDisable(true);
        bLevel8.setDisable(true);
        bLevel9.setDisable(true);
        bLevel10.setDisable(true);
        prefs.putBoolean("level2Unlocked", false);
        prefs.putBoolean("level3Unlocked", false);
        prefs.putBoolean("level4Unlocked", false);
        prefs.putBoolean("level5Unlocked", false);
        prefs.putBoolean("level6Unlocked", false);
        prefs.putBoolean("level7Unlocked", false);
        prefs.putBoolean("level8Unlocked", false);
        prefs.putBoolean("level9Unlocked", false);
        prefs.putBoolean("level10Unlocked", false);
    }

    // Unlockt alle Level
    public void unlockLevel() {
        bLevel2.setDisable(false);
        bLevel3.setDisable(false);
        bLevel4.setDisable(false);
        bLevel5.setDisable(false);
        bLevel6.setDisable(false);
        bLevel7.setDisable(false);
        bLevel8.setDisable(false);
        bLevel9.setDisable(false);
        bLevel10.setDisable(false);
        prefs.putBoolean("level2Unlocked", true);
        prefs.putBoolean("level3Unlocked", true);
        prefs.putBoolean("level4Unlocked", true);
        prefs.putBoolean("level5Unlocked", true);
        prefs.putBoolean("level6Unlocked", true);
        prefs.putBoolean("level7Unlocked", true);
        prefs.putBoolean("level8Unlocked", true);
        prefs.putBoolean("level9Unlocked", true);
        prefs.putBoolean("level10Unlocked", true);
    }

    // Schließt das Levelauswahlfenster
    public void zurueckButton() throws IOException {
        Stage stage = (Stage) bLevel1.getScene().getWindow();
        stage.close();
    }
}