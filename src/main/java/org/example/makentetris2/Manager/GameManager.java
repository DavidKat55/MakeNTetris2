package org.example.makentetris2.Manager;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import org.example.makentetris2.Blöcke.*;
import org.example.makentetris2.ControllerMappe.GameController;
import org.example.makentetris2.ControllerMappe.LevelController;
import org.example.makentetris2.ControllerMappe.MinigameController;
import org.example.makentetris2.LevelManager.*;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class GameManager {
    private static GridPane gridPane;
    public static ArrayList<TetrisBlock> activeBlocks;
    private Random rand = new Random();
    private int selectedBlockIndex = 0;
    private boolean[][] grid;
    private static final int GRID_WIDTH = 12;
    private static final int GRID_HEIGHT = 12;
    private Level level;
    private List<Pair<Integer, Integer>> aktuellePositionen;
    private GameController gameController;
    private static String currentSkin = "Classic";
    private static final Set<String> purchasedSkins = new HashSet<>();

    public static String getCurrentSkin() {
        return currentSkin;
    }

    public static void setCurrentSkin(String skin) {
        currentSkin = skin;
    }

    public static boolean isSkinPurchased(String skin) {
        return purchasedSkins.contains(skin);
    }

    public static void addPurchasedSkin(String skin) {
        purchasedSkins.add(skin);
    }

    public static void updateGameSkin() {
        if (activeBlocks == null) {
            System.out.println("Fehler: activeBlocks ist null!");
            return;
        }
        for (TetrisBlock block : activeBlocks) {
            block.applySkin(); // Alle aktiven Blöcke aktualisieren
        }
    }


    public GameManager(GridPane gridPane) {
        GameManager.gridPane = gridPane;
        this.activeBlocks = new ArrayList<>();
        this.grid = new boolean[GRID_WIDTH][GRID_HEIGHT];
        this.aktuellePositionen = new ArrayList<>();
        level = MakeNTetrisMain.getLevelManager().getCurrentLevel();
    }

    public boolean isPositionFree(TetrisBlock block) {
        for (int[] shapePart : block.getShape()) {
            int blockX = block.getX() + shapePart[0];
            int blockY = block.getY() + shapePart[1];
            if (blockX < 0 || blockX >= GRID_WIDTH || blockY < 0 || blockY >= GRID_HEIGHT) {
                return false;
            }
            for (TetrisBlock otherBlock : activeBlocks) {
                for (int[] otherShapePart : otherBlock.getShape()) {
                    int otherBlockX = otherBlock.getX() + otherShapePart[0];
                    int otherBlockY = otherBlock.getY() + otherShapePart[1];
                    if (blockX == otherBlockX && blockY == otherBlockY) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void init() {
        spawnBlockAtRandomPosition(() -> new TBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new LBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new IBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new OBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new ZBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new JBlock(0, 0));
        spawnBlockAtRandomPosition(() -> new SBlock(0, 0));
        changeStrokeColor(Color.WHITE, 1);
        applyBackgroundSkin();

    }

    private void spawnBlockAtRandomPosition(Supplier<TetrisBlock> blockSupplier) {
        int randomX, randomY;
        TetrisBlock block;
        do {
            randomX = rand.nextInt(GRID_WIDTH);
            randomY = rand.nextInt(GRID_HEIGHT);
            block = blockSupplier.get();
            block.setPosition(randomX, randomY);
        } while (!isPositionFree(block));
        spawnBlock(block);
    }

    public void spawnBlock(TetrisBlock block) {
        activeBlocks.add(block);
        block.addToPane(gridPane);
    }

    public void moveBlockUp(TetrisBlock block) {
        if (!checkCollision(block, 0, -1)) {
            block.move(0, -1);
            updatePane();
        }
    }

    public void moveBlockDown(TetrisBlock block) {
        if (!checkCollision(block, 0, 1)) {
            block.move(0, 1);
            updatePane();
        }
    }

    public void moveBlockLeft(TetrisBlock block) {
        if (!checkCollision(block, -1, 0)) {
            block.move(-1, 0);
            updatePane();
        }
    }

    public void moveBlockRight(TetrisBlock block) {
        if (!checkCollision(block, 1, 0)) {
            block.move(1, 0);
            updatePane();
        }
    }

    public void updatePane() {
        gridPane.getChildren().removeIf(n -> n instanceof Rectangle);

        for (TetrisBlock block :  activeBlocks) {
            block.addToPane(gridPane);
        }
    }

    public TetrisBlock getSelectedBlock() {
        return activeBlocks.get(selectedBlockIndex);
    }

    public void changeSelectedBlock() {
        selectedBlockIndex = (selectedBlockIndex + 1) % activeBlocks.size();
        changeStrokeColor(Color.WHITE, 1);
    }

    public void changeStrokeColor(Color color, double strokeWidth) {
        for (TetrisBlock block : activeBlocks) {
            for (Rectangle r : block.getBlocks()) {
                r.setStroke(Color.BLACK);
                r.setStrokeWidth(1);
            }
        }

        TetrisBlock selectedBlock = getSelectedBlock();
        for (Rectangle r : selectedBlock.getBlocks()) {
            r.setStroke(color);
            r.setStrokeWidth(strokeWidth);
        }
    }

    public boolean checkCollision(TetrisBlock block, int dx, int dy) {

        // Überprüfen, ob der Block innerhalb der Spielfeldgrenzen bleibt
        for (Rectangle rect : block.getBlocks()) {
            double newX = rect.getBoundsInParent().getMinX() + dx * 10;
            double newY = rect.getBoundsInParent().getMinY() + dy * 10;

            if (newX < 0 || newX + rect.getWidth() > gridPane.getWidth() ||
                    newY < 0 || newY + rect.getHeight() > gridPane.getHeight()) {
//                System.out.println("Collision am Spielfeldrand");
                return true;
            }
        }

        // Überprüfen auf Kollision mit anderen Blöcken
        for (TetrisBlock otherBlock : activeBlocks) {
            if (otherBlock == block) continue;

            for (Rectangle rect1 : block.getBlocks()) {
                double newX = rect1.getBoundsInParent().getMinX() + dx * 10;
                double newY = rect1.getBoundsInParent().getMinY() + dy * 10;

                for (Rectangle rect2 : otherBlock.getBlocks()) {
                    if (rect2.getBoundsInParent().intersects(newX, newY, rect1.getWidth(), rect1.getHeight())) {
                        System.out.println("Collision mit einem Block");
                        return true;
                    }
                }
            }
        }
        return false; // Keine Kollision
    }

    public void updateAktuellePositionen() {
        aktuellePositionen.clear(); // Leert die Liste der aktuellen Positionen

        for (TetrisBlock block : activeBlocks) {
            for (Rectangle rect : block.getBlocks()) {
                int col = GridPane.getColumnIndex(rect);
                int row = GridPane.getRowIndex(rect);
                aktuellePositionen.add(new Pair<>(col, row)); // Fügt die Position zur Liste hinzu
            }
        }
    }

    public boolean checkWinCondition() {
        // Überprüft ob aktuellePositionen mit den ZielPositionen übereinstimmen
        return aktuellePositionen.containsAll(level.getZielPositionen());
    }

    public void onEnterPressed() throws IOException {
        updateAktuellePositionen(); // Aktualisiere die aktuellen Positionen

        if (checkWinCondition()) {
            if (gameController != null) {
                gameController.stopTimer(); // Timer stoppen
            }
            MakeNTetrisMain.szeneWechseln(4);
            System.out.println("Gewonnen!");
            LevelController levelController = MakeNTetrisMain.getLevelController();
            int currentLevelIndex = MakeNTetrisMain.getLevelManager().getCurrentLevelIndex();
            System.out.println("Current Level Index: " + currentLevelIndex);
            levelController.enableLevelButtons(currentLevelIndex + 1);

            KeyInputManager keyInputManager = MakeNTetrisMain.getKeyInputManager();

            MinigameController minigameController = MakeNTetrisMain.getMinigameController();

            if (minigameController != null) {
                minigameController.aktualisiereKontostand(minigameController.getStartKontostand() + keyInputManager.getGewonnenePunkte());
                System.out.println("Kontostand aktualisiert neuer Kontostand: " + minigameController.getStartKontostand());
            } else {
                System.out.println("MinigameController is null");
            }

        } else {
            System.out.println("Noch nicht gelöst.");
        }
    }

    public ArrayList<TetrisBlock> getActiveBlocks() {
        return activeBlocks;
    }

    public void setGameController(GameController controller) {
        this.gameController = controller;
    }

    public void applyBackgroundSkin() {
        String skin = GameManager.getCurrentSkin(); // Aktuellen Skin holen
        String path = "/images/Hintergrund/" + skin + "background.png"; // Dynamischer Bildpfad

        // Hintergrundbild dynamisch mit CSS anwenden
        gridPane.setStyle("-fx-background-image: url('" + getClass().getResource(path).toExternalForm() + "'); " +
                "-fx-background-size: 100% 100%; " +
                "-fx-background-position: center; " +
                "-fx-background-repeat: no-repeat;");
    }



}
