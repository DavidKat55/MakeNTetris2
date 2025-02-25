package org.example.makentetris2.Manager;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import org.example.makentetris2.Blöcke.*;
import org.example.makentetris2.LevelManager.Level;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private GridPane gridPane;
    public static ArrayList<TetrisBlock> activeBlocks;
    private Random rand = new Random();
    private int selectedBlockIndex = 0;
    private boolean[][] grid;
    private static final int GRID_WIDTH = 15;
    private static final int GRID_HEIGHT = 15;
    private Level level;
    private List<Pair<Integer, Integer>> aktuellePositionen;


    public GameManager(GridPane gridPane) {
        this.gridPane = gridPane;
        this.activeBlocks = new ArrayList<>();
        this.grid = new boolean[GRID_WIDTH][GRID_HEIGHT];
        this.level = new Level(); // Initialisiere das Level
        this.aktuellePositionen = new ArrayList<>();
    }

    public void init() {
        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            TBlock tB = new TBlock(randomX, randomY);
            spawnBlock(tB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            LBlock lB = new LBlock(randomX, randomY);
            spawnBlock(lB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            IBlock iB = new IBlock(randomX, randomY);
            spawnBlock(iB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            OBlock oB = new OBlock(randomX, randomY);
            spawnBlock(oB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            ZBlock zB = new ZBlock(randomX, randomY);
            spawnBlock(zB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            JBlock jB = new JBlock(randomX, randomY);
            spawnBlock(jB);
        }

        for(int i = 0; i < 1; i++) {
            int randomX = rand.nextInt(12);
            int randomY = rand.nextInt(12);

            SBlock sB= new SBlock(randomX, randomY);
            spawnBlock(sB);
        }
        changeStrokeColor(Color.WHITE, 2);
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
        changeStrokeColor(Color.WHITE, 2);
    }

    public void changeStrokeColor(Color color, double strokeWidth) {
        for (TetrisBlock block : activeBlocks) {
            for (Rectangle r : block.getBlocks()) {
                r.setStroke(Color.BLACK);
                r.setStrokeWidth(2);
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
                System.out.println("Collision am Spielfeldrand");
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
        aktuellePositionen.clear(); // Leere die Liste der aktuellen Positionen

        for (TetrisBlock block : activeBlocks) {
            for (Rectangle rect : block.getBlocks()) {
                int col = GridPane.getColumnIndex(rect);
                int row = GridPane.getRowIndex(rect);
                aktuellePositionen.add(new Pair<>(col, row)); // Füge die Position zur Liste hinzu
            }
        }
    }

    public boolean checkWinCondition() {
        // Überprüfe, ob alle Zielpositionen in den aktuellen Positionen enthalten sind
        return aktuellePositionen.containsAll(level.getZielPositionen());
    }

    public void onEnterPressed() throws IOException {
        updateAktuellePositionen(); // Aktualisiere die aktuellen Positionen

        if (checkWinCondition()) {
            MakeNTetrisMain.szeneWechseln(4);
            System.out.println("Gewonnen!");
            // Hier kannst du weitere Aktionen ausführen, z.B. eine Gewinnmeldung anzeigen
        } else {
            System.out.println("Puzzle noch nicht gelöst.");
        }
    }
}
