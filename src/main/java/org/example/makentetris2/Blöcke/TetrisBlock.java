package org.example.makentetris2.Blöcke;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.example.makentetris2.Manager.GameManager;

import java.util.ArrayList;

import static org.example.makentetris2.Manager.GameManager.activeBlocks;

// Klasse für die Tetris-Blöcke
public class TetrisBlock {
    protected ArrayList<Rectangle> blocks = new ArrayList<>();
    protected int[][] shape;
    protected int x, y;
    protected Color color;
    protected int rotationIndex;
    protected String blockType;
    protected boolean drehbar;
    protected GameManager gameManager;

    // Konstruktor für die Tetris-Blöcke
    public TetrisBlock(int[][] shape, Color color, int startX, int startY, int rotationIndex, String blockType) {
        this.shape = shape;
        this.color = color;
        this.x = startX;
        this.y = startY;
        this.rotationIndex = rotationIndex;
        this.blockType = blockType;
        drehbar = true;
        init();
    }

    // Initialisiert die Blöcke mit der angegebenen Farbe und dem Bild
    public void init() {
        for (int i = 0; i < 4; i++) {
            Rectangle b = new Rectangle(37, 37, color);
            b.setStroke(Color.BLACK);
            b.setStrokeWidth(2);
            blocks.add(b);
        }
        applySkin(); // Skin direkt setzen
    }

    // Wendet den Skin auf die Blöcke an
    public void applySkin() {
        String skin = GameManager.getCurrentSkin(); // Aktuellen Skin holen
        String path = "/images/Bloecke/" + skin + "/" + blockType; // Dynamischer Bildpfad

        try {
            Image image = new Image(getClass().getResourceAsStream(path));
            ImagePattern pattern = new ImagePattern(image);

            for (Rectangle block : blocks) {
                block.setFill(pattern); // Skin auf Block anwenden
            }
        } catch (Exception e) {
            System.out.println("Skin konnte nicht geladen werden, verwende Standardfarbe." + path);
        }
    }
    // Fügt die Blöcke dem GridPane hinzu
    public void addToPane(GridPane pane) {
        pane.getChildren().removeAll(blocks);
        int index = 0;
        for (Rectangle block : blocks) {
            GridPane.setHalignment(block, HPos.CENTER);
            GridPane.setValignment(block, VPos.CENTER);
            pane.add(block, x + shape[index][0], y + shape[index][1]);
            index++;
        }
    }

    // Entfernt die Blöcke aus dem GridPane
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    // Gibt die Blöcke zurück
    public ArrayList<Rectangle> getBlocks() {
        return blocks;
    }

    // Gibt die Form der Blöcke zurück
    public void rotate() {

        if (drehbar == false) {
            return;
        }

        // Drehen der Blöcke um 90 Grad
        if (istPositionDrehbar(this)) {
            int centerX = shape[rotationIndex][0];
            int centerY = shape[rotationIndex][1];

            for (int i = 0; i < shape.length; i++) {
                int tX = shape[i][0] - centerX;
                int tY = shape[i][1] - centerY;

                shape[i][0] = centerX - tY;
                shape[i][1] = centerY + tX;
            }
        }
    }

    // Gibt den Typ des Blocks zurück
    public int[][] getShape() {
        return shape;
    }

    // Gibt den Typ des Blocks zurück
    public int getX() {
        return x;
    }

    // Gibt den Typ des Blocks zurück
    public int getY() {
        return y;
    }

    // Gibt den Typ des Blocks zurück
    public boolean isDrehbar() {
        return drehbar;
    }

    // Gibt den Typ des Blocks zurück
    public void setDrehbar(boolean drehbar) {
        this.drehbar = drehbar;
    }

    // Gibt den Typ des Blocks zurück
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Gibt den Typ des Blocks zurück
    public void setShape(int[][] shape) {
        this.shape = shape;
    }

    // Gibt den Typ des Blocks zurück
    public boolean istPositionDrehbar(TetrisBlock block) {
        // Überprüfen, ob die Drehung des Blocks möglich ist
        int centerX = block.getShape()[block.rotationIndex][0];
        int centerY = block.getShape()[block.rotationIndex][1];

        // Berechnung der neuen Positionen nach der Drehung
        int[][] newShape = new int[block.getShape().length][2];
        for (int i = 0; i < block.getShape().length; i++) {
            int tX = block.getShape()[i][0] - centerX;
            int tY = block.getShape()[i][1] - centerY;

            newShape[i][0] = centerX - tY;
            newShape[i][1] = centerY + tX;
        }

        // Überprüfen, ob die neuen Positionen innerhalb der Grenzen liegen und keine Kollisionen mit anderen Blöcken auftreten
        for (int[] part : newShape) {
            int newX = block.getX() + part[0];
            int newY = block.getY() + part[1];

            if (newX < 0 || newX >= 16 || newY < 0 || newY >= 16) {
                return false; // Out of bounds
            }

            // Überprüfen auf Kollisionen mit anderen Blöcken
            for (TetrisBlock otherBlock : activeBlocks) {
                if (otherBlock == block) continue;

                for (int[] otherPart : otherBlock.getShape()) {
                    int otherX = otherBlock.getX() + otherPart[0];
                    int otherY = otherBlock.getY() + otherPart[1];

                    if (newX == otherX && newY == otherY) {
                        return false; // Collision detected
                    }
                }
            }
        }
        return true;
    }
}