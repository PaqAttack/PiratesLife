package paqattack.pirateslife.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import paqattack.pirateslife.util.Configuration;

/**
 * Controller class for the menu scene.
 *
 * @author Christopher Paquin
 */
public class MenuController {

    @FXML
    Button playButton;

    @FXML
    Button settingsButton;

    @FXML
    Button exitButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        initialize();
    }

    private void initialize() {
        playButton.setOnAction(e -> onPlay());
        playButton.setOnMouseEntered(e -> onHover(playButton));
        playButton.setOnMouseExited(e -> onExitHover(playButton));

        settingsButton.setOnAction(e -> onSettings());
        settingsButton.setOnMouseEntered(e -> onHover(settingsButton));
        settingsButton.setOnMouseExited(e -> onExitHover(settingsButton));

        exitButton.setOnAction(e -> onExit());
        exitButton.setOnMouseEntered(e -> onHover(exitButton));
        exitButton.setOnMouseExited(e -> onExitHover(exitButton));
    }

    private void onHover(Button button) {
        button.setScaleX(2.1);
        button.setScaleY(2.1);
    }

    private void onExitHover(Button button) {
        button.setScaleX(2.0);
        button.setScaleY(2.0);
    }

    private void onPlay() {
        GameScene gameScene = new GameScene(
                Configuration.getInt("GAME_WIDTH"),
                Configuration.getInt("GAME_HEIGHT"),
                stage);

        stage.close();
        Stage gamwStage = new Stage();
        gamwStage.setScene(gameScene.getScene());
        gamwStage.setTitle("Pirate's Life");
        gamwStage.setAlwaysOnTop(true);
        gamwStage.show();
        System.out.println("Play clicked");
    }

    private void onSettings() {
        System.out.println("Settings clicked");
    }

    private void onExit() {
        stage.close();
    }
}
