package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroSceneController {
    private Stage mainStage;
    private Scene scene;
    private Parent root;

    public void switchToMainApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
        mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("MainApp.css").toExternalForm();
        scene.getStylesheets().add(css);
        mainStage.setScene(scene);
        mainStage.show();






    }



}
