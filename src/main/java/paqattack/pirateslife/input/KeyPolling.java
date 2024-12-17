package paqattack.pirateslife.input;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class KeyPolling {

    private static Scene scene;
    private static final Set<KeyCode> keysCurrentlyDown = new HashSet<>();

    private KeyPolling() {}

    public static KeyPolling getInstance() {
        return new KeyPolling();
    }

    public void pollScene(Scene scene) {
        clearKeys();
        removeCurKeyHandlers();
        setScene(scene);
    }

    private void clearKeys() {
        keysCurrentlyDown.clear();
    }

    private void removeCurKeyHandlers() {
        if (scene != null) {
            KeyPolling.scene.setOnKeyPressed(null);
            KeyPolling.scene.setOnKeyReleased(null);
        }
    }

    private void setScene(Scene scene) {
        KeyPolling.scene = scene;
        KeyPolling.scene.setOnKeyPressed((keyEvent -> {
            keysCurrentlyDown.add(keyEvent.getCode());
        }));
        KeyPolling.scene.setOnKeyReleased((keyEvent -> {
            keysCurrentlyDown.remove(keyEvent.getCode());
        }));
    }

    public boolean isDown(KeyCode keyCode) {
        return keysCurrentlyDown.contains(keyCode);
    }

    public boolean isMovementKeyPressed() {
        return keysCurrentlyDown.contains(KeyCode.W) ||
                keysCurrentlyDown.contains(KeyCode.S) ||
                keysCurrentlyDown.contains(KeyCode.A) ||
                keysCurrentlyDown.contains(KeyCode.D);
    }
}
