module org.example.makentetris2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.makentetris2 to javafx.fxml;
    exports org.example.makentetris2;
    exports org.example.makentetris2.ControllerMappe;
    opens org.example.makentetris2.ControllerMappe to javafx.fxml;
    exports org.example.makentetris2.Manager;
    opens org.example.makentetris2.Manager to javafx.fxml;
}