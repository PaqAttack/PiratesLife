module paqattack.pirateslife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.logging;

    opens paqattack.pirateslife to javafx.fxml;
    exports paqattack.pirateslife;
}