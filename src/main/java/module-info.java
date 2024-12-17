module paqattack.pirateslife {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.logging;

    opens paqattack.pirateslife to javafx.fxml;
    exports paqattack.pirateslife;
    opens paqattack.pirateslife.windows to javafx.fxml;
    exports paqattack.pirateslife.windows;
    opens paqattack.pirateslife.util to javafx.fxml;
    exports paqattack.pirateslife.util;
}