package paqattack.pirateslife.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class MenuScene extends VBox {

    public MenuScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/paqattack/pirateslife/fxmls/menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}