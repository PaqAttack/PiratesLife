package paqattack.pirateslife;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import paqattack.pirateslife.util.Configuration;
import paqattack.pirateslife.windows.MenuScene;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        showSplashScreen(primaryStage);
    }

    private void showSplashScreen(Stage primaryStage) {
        Stage splashStage = new Stage(StageStyle.UNDECORATED);

        StackPane splashPane = new StackPane();
        ImageView logo = new ImageView(
                new Image(
                        Objects.requireNonNull(
                                getClass().getResource(
                                        "/paqattack/pirateslife/images/splash art2.png"))
                                .toExternalForm()));

        Label loadingLabel = new Label("Loading...");
        splashPane.getChildren().addAll(logo, loadingLabel);
        StackPane.setAlignment(loadingLabel, javafx.geometry.Pos.BOTTOM_CENTER);

        Scene splashScene = new Scene(splashPane, 873, 820);
        splashStage.setScene(splashScene);
        splashStage.show();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                splashStage.close();
                showMenu(primaryStage);
            });
        }).start();
    }

    private void showMenu(Stage stage) {
        Scene scene = new Scene(
                new MenuScene(),
                Configuration.getDouble("MENU_WIDTH"),
                Configuration.getDouble("MENU_HEIGHT"));

        stage.setScene(scene);
        stage.setTitle("Pirate's Life");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}