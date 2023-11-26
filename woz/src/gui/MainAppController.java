package src.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.scene.layout.VBox;
import src.game.Context;
import src.game.Game;
public class MainAppController implements Initializable {
    @FXML
    private Label CurrentRoomLabel;
    @FXML
    private Label EnergyAmountLabel;
    @FXML
    private Label CurrentYearLabel;
    @FXML
    private VBox NavigationPane;
    @FXML
    private ImageView BackgroundImg;

    private Context context;

    public MainAppController() {
        context = Game.getContext();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDisplayPanel();
        updateNavigationPanel();
    }

    private void updateDisplayPanel() {
        CurrentRoomLabel.setText(context.getCurrent().getName());
        EnergyAmountLabel.setText(context.getPlayer().getEnergy() + "/" + context.getPlayer().getMaxEnergy());
        CurrentYearLabel.setText(String.valueOf(context.getRoundSystem().getRound() + 1));
        BackgroundImg.setImage(new Image(context.getCurrent().getImageURl()));
    }
    private void updateNavigationPanel() {
        ArrayList<Button> buttonList = new ArrayList<>();
        Set<String> exits = context.getCurrent().getEdges().keySet();
        for (String exit: exits) {
            Button button = new Button(exit);
            button.setPrefHeight(60);
            button.setPrefWidth(300);
            button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    Game.getRegistry().dispatch("go " + button.getText());
                    updateNavigationPanel();
                    updateDisplayPanel();
                }
            });

            buttonList.add(button);
        }

        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().addAll(buttonList);
    }
}
