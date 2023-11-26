package src.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class MainApp extends Application {
    @Override

    public void start(Stage mainStage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("IntroScene.FXML"));
            Scene scene = new Scene(root);

            mainStage.setTitle("Crop Guard");
            Image icon = new Image("src/images/CropGuardLogo.png");
            mainStage.getIcons().add(icon);

            mainStage.setScene(scene);
            mainStage.show();


        } catch(Exception e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        launch(args);


    }



}







/*
    @Override
    public void start (Stage mainStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));

        Scene scene = new Scene(root);
        String css = this.getClass().getResource("MainApp.css").toExternalForm();
        scene.getStylesheets().add(css);
        mainStage.setTitle("Crop Guard");
       // mainStage.setFullScreen(true);

        Image icon = new Image("src/images/CropGuardLogo.png");
        mainStage.getIcons().add(icon);

        mainStage.setScene(scene);
        mainStage.show();
    }
 */

/*

    @Override



    public void start (Stage mainStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IntroScene.fxml"));

        Scene scene = new Scene(root);

        String css = this.getClass().getResource("IntroScene.css").toExternalForm();
        scene.getStylesheets().add(css);

        mainStage.setTitle("Crop Guard");
        // mainStage.setFullScreen(true);

        Image icon = new Image("src/images/CropGuardLogo.png");
        mainStage.getIcons().add(icon);



        mainStage.setScene(scene);
        mainStage.show();
    }
 */







