package paqattack.pirateslife;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import paqattack.pirateslife.util.Configuration;
import paqattack.pirateslife.windows.MenuScene;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        showSplashScreen(primaryStage);
    }

    /**
     * Show the splash screen.
     * The splash screen is shown for a set amount of time.
     * @param primaryStage The stage to show the splash screen on.
     */
    private void showSplashScreen(Stage primaryStage) {
        Stage splashStage = new Stage(StageStyle.UNDECORATED);

        StackPane splashPane = new StackPane();
        ImageView logo = new ImageView(
                new Image(
                        Objects.requireNonNull(
                                getClass().getResource(
                                        "/paqattack/pirateslife/images/splash art2.png"))
                                .toExternalForm()));

        splashPane.getChildren().add(logo);
        Scene splashScene = new Scene(splashPane, 873, 820);
        splashStage.setScene(splashScene);
        splashStage.setAlwaysOnTop(true);
        splashStage.show();

        new Thread(() -> {
            try {
                int milli = Configuration.getInt("SPLASH_TIME") == 0 ? 3000 : Configuration.getInt("SPLASH_TIME");
                Thread.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                splashStage.close();
                showMenu(primaryStage);
            });
        }).start();
    }

    /**
     * Show the menu scene.
     * The size is loaded from a configuration file.
     * @param stage The stage to show the menu on.
     */
    private void showMenu(Stage stage) {
        MenuScene menuScene = new MenuScene(
                Configuration.getInt("MENU_WIDTH"),
                Configuration.getInt("MENU_HEIGHT"),
                stage);

        stage.setScene(menuScene.getScene());
        stage.setTitle("Pirate's Life");
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}