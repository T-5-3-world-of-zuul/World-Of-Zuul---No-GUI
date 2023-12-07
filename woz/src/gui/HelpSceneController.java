package src.gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelpSceneController {
    @FXML
    private Button SceneSwitchButton;
    public void switchToMainApp(ActionEvent event) throws IOException {
        Stage stage = (Stage) SceneSwitchButton.getScene().getWindow();
        stage.close();

    }
}
