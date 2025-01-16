package org.example.makentetris2;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private List<Group> blocks;
    @FXML
    private GridPane spielFeld;

    @FXML
    public void initialize() {
        blocks = new ArrayList<>();
        blocks.add((Group) spielFeld.lookup("#block1"));
        blocks.add((Group) spielFeld.lookup("#block2"));
        blocks.add((Group) spielFeld.lookup("#block3"));
        blocks.add((Group) spielFeld.lookup("#block4"));
        blocks.add((Group) spielFeld.lookup("#block5"));
        blocks.add((Group) spielFeld.lookup("#block6"));

        BlockHitbox blockHitbox = new BlockHitbox();
        for (Group block : blocks) {
            blockHitbox.addHitbox(block);
        }

        KeyInputManager.setController(this);
    }

    public GridPane getSpielFeld() {
        return spielFeld;
    }

    public Group getBlock(int index) {
        return blocks.get(index);
    }

    public List<Group> getBlocks() {
        return blocks;
    }
}