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
        Scene scene = new Scene(fxmlLoader.load(), 600, 716);
        stage.setResizable(false);
        stage.setTitle("MakeNTetris");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    Bloecke.bloeckeBewegen(1 , 1);
                    break;
                case A:
                    System.out.println("A");
                    break;
                case S:
                    System.out.println("S");
                    break;
                case D:
                    System.out.println("D");
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}