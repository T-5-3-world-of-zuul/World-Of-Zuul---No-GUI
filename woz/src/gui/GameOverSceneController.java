package src.gui;


import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import src.game.ScoreSystem;

public class GameOverSceneController {

    public Button quitBtn;
    public Label ScoreText;

    public void quitGame(MouseEvent mouseEvent) {
        Platform.exit();
    }


    public void initialize(){
        System.out.println("test214");

        ScoreText.setText("Your score was : " +ScoreSystem.getCombinedScore());
    }
}
