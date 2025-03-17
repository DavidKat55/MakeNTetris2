package org.example.makentetris2.ControllerMappe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.makentetris2.LevelManager.LevelManager;
import org.example.makentetris2.LevelManager.LevelState;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class LevelController {

    @FXML
    private Button bLevel1;
    @FXML
    private Button bLevel2;
    @FXML
    private Button bLevel3;

    private LevelManager levelManager;
    private LevelState levelState;

    public void initialize() {
        MakeNTetrisMain.setLevelController(this);

        levelState = LevelState.getInstance();

        bLevel2.setDisable(!levelState.isLevel2Unlocked());
        bLevel3.setDisable(!levelState.isLevel3Unlocked());

        levelManager = MakeNTetrisMain.getLevelManager();

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
    }

    public void enableLevelButtons(int levelIndex) {
        switch (levelIndex) {
            case 1:
                bLevel2.setDisable(false);
                levelState.setLevel2Unlocked(true);
                break;
            case 2:
                bLevel3.setDisable(false);
                levelState.setLevel3Unlocked(true);
                break;
        }
    }

    public void zurueckButton() throws IOException {
        Stage stage = (Stage) bLevel1.getScene().getWindow();
        stage.close();
    }
}

//CODE FÜR DEN ENDGÜLTIGEN RELEASE HIERMIT WERDEN GESCHAFFTE LEVEL KONSTANT FREIGESCHALTET UND NICHT BEI JEDEM NEUSTART DES PROGRAMMS GELÖSCHT SOMIT KANN AUCH DIE LEVELSTATE KLASSSE GELÖSCHT WERDEN

//import java.util.prefs.Preferences;
//
//public class LevelController {
//
//    @FXML
//    private Button bLevel1;
//    @FXML
//    private Button bLevel2;
//    @FXML
//    private Button bLevel3;
//
//    private LevelManager levelManager;
//    private Preferences prefs;
//
//    public void initialize() {
//        MakeNTetrisMain.setLevelController(this);
//
//        prefs = Preferences.userNodeForPackage(LevelController.class);
//
//        bLevel2.setDisable(!prefs.getBoolean("level2Unlocked", false));
//        bLevel3.setDisable(!prefs.getBoolean("level3Unlocked", false));
//
//        levelManager = MakeNTetrisMain.getLevelManager();
//
//        bLevel1.setOnAction(e -> {
//            try {
//                levelManager.setCurrentLevelIndex(0);
//                MakeNTetrisMain.szeneWechseln(1);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//        bLevel2.setOnAction(e -> {
//            try {
//                levelManager.selectLevel(1);
//                MakeNTetrisMain.szeneWechseln(1);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//        bLevel3.setOnAction(e -> {
//            try {
//                levelManager.selectLevel(2);
//                MakeNTetrisMain.szeneWechseln(1);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
//    }
//
//    public void enableLevelButtons(int levelIndex) {
//        System.out.println("Enabling level buttons for level index: " + levelIndex);
//        switch (levelIndex) {
//            case 1:
//                bLevel2.setDisable(false);
//                prefs.putBoolean("level2Unlocked", true);
//                break;
//            case 2:
//                bLevel3.setDisable(false);
//                prefs.putBoolean("level3Unlocked", true);
//                break;
//            default:
//                System.out.println("Invalid level index: " + levelIndex);
//        }
//    }
//}