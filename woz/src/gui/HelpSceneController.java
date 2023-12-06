package src.gui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelpSceneController {
    public Button CloseBtn;

    public void CloseHelpWindow(MouseEvent mouseEvent) {
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
