package paqattack.pirateslife.windows;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class GameController {
    @FXML
    Canvas canvas;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        init();
    }

    private void init() {
        canvas.setWidth(stage.getWidth() * 0.95);
        canvas.setHeight(stage.getHeight() * 0.95);
        canvas.setOnMouseClicked(e -> {
            System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
        });
    }
}
