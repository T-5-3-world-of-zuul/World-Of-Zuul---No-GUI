package src.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;


public class IntroSceneController {
    @FXML

    public void switchToMainApp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("MainApp.css").toExternalForm();
        scene.getStylesheets().add(css);
        mainStage.setScene(scene);
        mainStage.show();

    }


    public void openHelpPopup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HelpScene.fxml"));
        Stage helpStage = new Stage();
        helpStage.setTitle("Help Menu");
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("HelpScene.css").toExternalForm();
        scene.getStylesheets().add(css);
        helpStage.setScene(scene);
        helpStage.show();
    }





}
