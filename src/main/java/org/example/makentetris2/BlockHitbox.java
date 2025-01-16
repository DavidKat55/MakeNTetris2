package org.example.makentetris2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BlockHitbox {

    private List<Rectangle> hitboxes = new ArrayList<>();

    public void addHitbox(Group block) {
        List<Rectangle> rectangles = new ArrayList<>();
        for (Node node : block.getChildren()) {
            if (node instanceof Rectangle) {
                rectangles.add((Rectangle) node);
            }
        }
        for (Rectangle rectangle : rectangles) {
            Rectangle hitbox = new Rectangle();
            hitbox.setX(rectangle.getLayoutX());
            hitbox.setY(rectangle.getLayoutY());
            hitbox.setWidth(rectangle.getWidth());
            hitbox.setHeight(rectangle.getHeight());
            hitbox.setFill(null); // Transparent fill
            hitbox.setStroke(javafx.scene.paint.Color.RED); // Visible border for debugging
            block.getChildren().add(hitbox);
            hitboxes.add(hitbox);
        }
    }
}