package org.example.makentetris2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MakeNTetrisMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MakeNTetrisMain.class.getResource("MakeNTetris.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 640);
        stage.setResizable(false);
        stage.setTitle("MakeNTetris");
        stage.setScene(scene);
        stage.show();

        KeyInputManager keyInputManager = new KeyInputManager();
        keyInputManager.addKeyHandler(scene);

    }

    public static void main(String[] args) {
        launch();
    }
}