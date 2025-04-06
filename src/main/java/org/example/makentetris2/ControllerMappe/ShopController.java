package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.makentetris2.Manager.GameManager;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.IOException;

public class ShopController {

    @FXML
    private JFXButton mKauf;

    @FXML
    private JFXButton lKauf;

    @FXML
    private JFXButton gKauf;

    @FXML
    private JFXRadioButton mClassicSkin;

    @FXML
    private JFXRadioButton mMinecraftSkin;

    @FXML
    private JFXRadioButton mLegoSkin;

    @FXML
    private JFXRadioButton mGameBoySkin;

    @FXML
    private ImageView mImage;

    @FXML
    private ImageView lImage;


    @FXML
    private JFXButton zShop;

    @FXML
    private Label kontostandLabel;

    private int kontostand;

    @FXML
    public void initialize() {
        // Standardmäßig den aktuellen Skin auswählen
        String currentSkin = GameManager.getCurrentSkin();
        if (currentSkin.equals("Classic")) {
            mClassicSkin.setSelected(true);
        } else if (currentSkin.equals("Minecraft")) {
            mMinecraftSkin.setSelected(true);
        } else if (currentSkin.equals("Lego")) {
            mLegoSkin.setSelected(true);
        } else if (currentSkin.equals("GameBoy")) {
            mGameBoySkin.setSelected(true);
        }
        // Event-Handler für die RadioButtons (damit Auswahl sofort angewendet wird)
        mClassicSkin.setOnAction(this::handleAuswahl);
        mMinecraftSkin.setOnAction(this::handleAuswahl);
        mLegoSkin.setOnAction(this::handleAuswahl);
        mGameBoySkin.setOnAction(this::handleAuswahl);

        // Event-Handler für Kauf-Button
        mKauf.setOnAction(this::KaufMinecraft);
        lKauf.setOnAction(this::KaufLego);
        gKauf.setOnAction(this::KaufGameBoy);

        // Kontostand laden
        loadBalance();
        updateKontostandLabel();
    }

    @FXML
    private void KaufMinecraft(ActionEvent event) {
        String skin = "Minecraft"; // Immer Minecraft-Skin kaufen

        if (!GameManager.isSkinPurchased(skin)) {
            if (kontostand >= 500) {
                kontostand -= 500;
                GameManager.addPurchasedSkin(skin);
                saveBalance();
                updateKontostandLabel();
                System.out.println("Skin gekauft: " + skin);
                mKauf.setText("Gekauft");
                mKauf.setDisable(true);
            } else {
                System.out.println("Nicht genug Punkte!");
            }
        } else {
            System.out.println("Skin bereits gekauft!");
        }
    }

    @FXML
    private void KaufLego(ActionEvent event) {
        String skin = "Lego";

        if (!GameManager.isSkinPurchased(skin)) {
            if (kontostand >= 500) {
                kontostand -= 500;
                GameManager.addPurchasedSkin(skin);
                saveBalance();
                updateKontostandLabel();
                System.out.println("Skin gekauft: " + skin);
                lKauf.setText("Gekauft");
                lKauf.setDisable(true);
            } else {
                System.out.println("Nicht genug Punkte!");
            }
        } else {
            System.out.println("Skin bereits gekauft!");
        }
    }

    @FXML
    public void KaufGameBoy(ActionEvent event) {
        String skin = "GameBoy";

        if (!GameManager.isSkinPurchased(skin)) {
            if (kontostand >= 500) {
                kontostand -= 500;
                GameManager.addPurchasedSkin(skin);
                saveBalance();
                updateKontostandLabel();
                System.out.println("Skin gekauft: " + skin);
                gKauf.setText("Gekauft");
                gKauf.setDisable(true);
            } else {
                System.out.println("Nicht genug Punkte!");
            }
        } else {
            System.out.println("Skin bereits gekauft!");
        }
    }

    @FXML
    private void handleAuswahl(ActionEvent event) {
        applySelectedSkin();
    }

    private void applySelectedSkin() {
        String selectedSkin = getSelectedSkin();
        String currentSkin = GameManager.getCurrentSkin();

        if (!GameManager.isSkinPurchased(selectedSkin) && !selectedSkin.equals("Classic")) {
            System.out.println("Skin nicht gekauft!");
            // Setze den RadioButton auf den aktuellen Skin zurück
            if (currentSkin.equals("Classic")) {
                mClassicSkin.setSelected(true);
            } else if (currentSkin.equals("Minecraft")) {
                mMinecraftSkin.setSelected(true);
            } else if (currentSkin.equals("Lego")) {
                mLegoSkin.setSelected(true);
            } else if (currentSkin.equals("GameBoy")) {
                mGameBoySkin.setSelected(true);
            }
            return;
        }

        GameManager.setCurrentSkin(selectedSkin);
        GameManager.updateGameSkin();
        System.out.println("Neuer Skin: " + selectedSkin);
    }

    private String getSelectedSkin() {
        if (mClassicSkin.isSelected()) {
            return "Classic";
        } else if (mMinecraftSkin.isSelected()) {
            return "Minecraft";
        } else if (mLegoSkin.isSelected()) {
            return "Lego";
        } else if (mGameBoySkin.isSelected()) {
            return "GameBoy";
        }
        return "Classic"; // Standardwert, falls nichts ausgewählt ist
    }

    private void loadBalance() {
        MinigameController minigameController = MakeNTetrisMain.getMinigameController();
        if (minigameController != null) {
            minigameController.loadBalance();
            kontostand = minigameController.getStartKontostand();
        }
    }

    private void saveBalance() {
        MinigameController minigameController = MakeNTetrisMain.getMinigameController();
        if (minigameController != null) {
            minigameController.aktualisiereKontostand(kontostand);
        }
    }

    private void updateKontostandLabel() {
        kontostandLabel.setText("Kontostand: " + kontostand);
    }

    public void back() throws IOException {
        // Hier wird die Szene gewechselt, wenn der Shop geschlossen wird
        Stage stage = (Stage) zShop.getScene().getWindow();
        stage.close();
    }


}