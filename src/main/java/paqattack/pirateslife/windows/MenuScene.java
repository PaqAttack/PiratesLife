package paqattack.pirateslife.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class for the menu scene.
 *
 * @author Christopher Paquin
 */
public class MenuScene {

    private Scene scene;
    private MenuController controller;

    public MenuScene(double width, double height, Stage stage) {
        Parent root = loadFXML(stage);
        scene = new Scene(root, width, height);
        init();
    }

    /**
     * Loads FXML file for the scene information.
     * This also sets the controller for the scene.
     * @param stage The stage to set the controller to.
     * @return The root of the scene.
     */
    private Parent loadFXML(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/paqattack/pirateslife/fxmls/menu.fxml"));
        controller = new MenuController();
        loader.setController(controller);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.setStage(stage);
        return root;
    }

    /**
     * Initialize the scene.
     */
    private void init() {

    }

    public Scene getScene() {
        return scene;
    }

}





