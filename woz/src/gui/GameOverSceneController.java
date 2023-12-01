package src.gui;


import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GameOverSceneController {
    public Button quitBtn;

    public void quitGame(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
