package org.example.makentetris2.ControllerMappe;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.makentetris2.Manager.GameManager;
import org.example.makentetris2.MakeNTetrisMain;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import static org.example.makentetris2.MakeNTetrisMain.soundManager;

public class ShopController {

    @FXML private JFXButton mKauf, lKauf, gKauf, zShop;
    @FXML private JFXRadioButton mClassicSkin, mMinecraftSkin, mLegoSkin, mGameBoySkin;
    @FXML private ImageView mImage, lImage;
    @FXML private Label kontostandLabel;

    private int kontostand;
    private Set<String> gekaufteSkins = new HashSet<>();
    private String aktuellerSkin = "Classic";
    private static final String SKINS_FILE = "src/main/resources/texts/skins.txt";

    @FXML
    public void initialize() {

        MakeNTetrisMain.setShopController(this);

        ladeSkins();

        if (aktuellerSkin == null) {
            aktuellerSkin = "Classic";
        }

        // Standard Skin auswählen
        if (aktuellerSkin.equals("Classic")) mClassicSkin.setSelected(true);
        else if (aktuellerSkin.equals("Minecraft")) mMinecraftSkin.setSelected(true);
        else if (aktuellerSkin.equals("Lego")) mLegoSkin.setSelected(true);
        else if (aktuellerSkin.equals("GameBoy")) mGameBoySkin.setSelected(true);

        // RadioButtons -> Skinauswahl
        mClassicSkin.setOnAction(this::handleAuswahl);
        mMinecraftSkin.setOnAction(this::handleAuswahl);
        mLegoSkin.setOnAction(this::handleAuswahl);
        mGameBoySkin.setOnAction(this::handleAuswahl);

        // Kaufbuttons
        mKauf.setOnAction(this::KaufMinecraft);
        lKauf.setOnAction(this::KaufLego);
        gKauf.setOnAction(this::KaufGameBoy);

        // Buttons deaktivieren wenn bereits gekauft
        if (gekaufteSkins.contains("Minecraft")) {
            mKauf.setText("Gekauft");
            mKauf.setDisable(true);
        }
        if (gekaufteSkins.contains("Lego")) {
            lKauf.setText("Gekauft");
            lKauf.setDisable(true);
        }
        if (gekaufteSkins.contains("GameBoy")) {
            gKauf.setText("Gekauft");
            gKauf.setDisable(true);
        }

        loadBalance();
        updateKontostandLabel();
        applySelectedSkin(); // Skin anwenden
    }

    @FXML
    private void KaufMinecraft(ActionEvent event) {
        kaufSkin("Minecraft", mKauf);
    }

    @FXML
    private void KaufLego(ActionEvent event) {
        kaufSkin("Lego", lKauf);
    }

    @FXML
    private void KaufGameBoy(ActionEvent event) {
        kaufSkin("GameBoy", gKauf);
    }

    // Methode zum Kauf eines Skins
    private void kaufSkin(String skinName, JFXButton button) {
        if (!gekaufteSkins.contains(skinName)) {
            if (kontostand >= 500) {
                kontostand -= 500;
                gekaufteSkins.add(skinName);
                saveBalance();
                speichereSkins();
                updateKontostandLabel();
                System.out.println("Skin gekauft: " + skinName);
                button.setText("Gekauft");
                button.setDisable(true);
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

    // Methode zum Anwenden des ausgewählten Skins
    private void applySelectedSkin() {
        String selectedSkin = getSelectedSkin();

        if (!gekaufteSkins.contains(selectedSkin) && !selectedSkin.equals("Classic")) {
            System.out.println("Skin nicht gekauft!");
            // Zurücksetzen auf aktuellen gültigen Skin
            setSkinRadioButton(aktuellerSkin);
            return;
        }

        aktuellerSkin = selectedSkin;
        GameManager.setCurrentSkin(selectedSkin); // Skin im GameManager setzen
        speichereSkins();
        System.out.println("Neuer Skin: " + selectedSkin);
    }

    // Methode zum Ermitteln des aktuell ausgewählten Skins
    private String getSelectedSkin() {
        if (mClassicSkin.isSelected()) return "Classic";
        if (mMinecraftSkin.isSelected()) return "Minecraft";
        if (mLegoSkin.isSelected()) return "Lego";
        if (mGameBoySkin.isSelected()) return "GameBoy";
        return "Classic";
    }

    // Methode zum Anwenden des ausgewählten Skins
    private void setSkinRadioButton(String skin) {
        mClassicSkin.setSelected(skin.equals("Classic"));
        mMinecraftSkin.setSelected(skin.equals("Minecraft"));
        mLegoSkin.setSelected(skin.equals("Lego"));
        mGameBoySkin.setSelected(skin.equals("GameBoy"));
    }

    // Methode zum Laden des Kontostands
    private void loadBalance() {
        MinigameController minigameController = MakeNTetrisMain.getMinigameController();
        if (minigameController != null) {
            minigameController.loadBalance();
            kontostand = minigameController.getStartKontostand();
        }
    }

    // Methode zum Speichern des Kontostands
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
        soundManager.stopMusic();
        soundManager.playBackgroundMusic("/sounds/Start.mp3");
        Stage stage = (Stage) zShop.getScene().getWindow();
        stage.close();
    }

    // Skin speichern / laden
    private void ladeSkins() {
        File file = new File(SKINS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                aktuellerSkin = reader.readLine();
                String line;
                while ((line = reader.readLine()) != null) {
                    gekaufteSkins.add(line);
                }
            } catch (IOException e) {
                System.out.println("Fehler beim Laden der Skins.");
            }
        } else {
            aktuellerSkin = "Classic";
            gekaufteSkins.add("Classic");
            speichereSkins();
        }
    }

    // Methode zum Speichern der Skins
    private void speichereSkins() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SKINS_FILE))) {
            writer.write(aktuellerSkin);
            writer.newLine();
            for (String skin : gekaufteSkins) {
                writer.write(skin);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Skins.");
        }
    }

    // Methode zum Zurücksetzen der Skins
    public void resetSkins() {
        gekaufteSkins.clear();
        aktuellerSkin = "Classic";
        speichereSkins();
        setSkinRadioButton(aktuellerSkin);
        updateKontostandLabel();
        MakeNTetrisMain.initializeShopController();
    }
}