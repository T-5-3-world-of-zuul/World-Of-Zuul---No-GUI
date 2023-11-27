package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


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
    @FXML
    private VBox InventoryPaneList;

    private Context context;

    public MainAppController() {
        context = Game.getContext();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDisplayPanel();
        updateNavigationPanel();
        updateInventoryPane();
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
            String label = exit.substring(0, 1).toUpperCase() + exit.substring(1);
            Button button = new Button(label);
            button.setPrefHeight(60);
            button.setPrefWidth(300);
            button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    Game.getRegistry().dispatch("go " + button.getText().toLowerCase());
                    updateNavigationPanel();
                    updateDisplayPanel();
                }
            });
            buttonList.add(button);
        }
        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().addAll(buttonList);
    }

    private void updateInventoryPane() {
        ArrayList<Button> buttonList = new ArrayList<>();
        for (int i = 0 ; i < context.getPlayerInventory().inventory.size() ; i++) {
            String label = context.getPlayerInventory().inventory.get(i).name.substring(0, 1).toUpperCase() + context.getPlayerInventory().inventory.get(i).name.substring(1);
            Button button = new Button(label);
            button.setPrefHeight(40);
            button.setPrefWidth(300);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Game.getRegistry().dispatch("interact " + button.getText().toLowerCase());
                    updateInventoryPane();
                }
            });
            buttonList.add(button);
        }
        InventoryPaneList.getChildren().clear();
        InventoryPaneList.getChildren().addAll(buttonList);
    }

    @FXML
    public void sleepCommand(ActionEvent event) throws IOException{
        Game.getRegistry().dispatch("sleep");
        updateDisplayPanel();
    }
    @FXML
    public void studyCommand(ActionEvent event) {
        Game.getRegistry().dispatch("study");
        updateDisplayPanel();
    }
    @FXML
    public void searchCommand(ActionEvent event) {
        System.out.println(event.getSource());
    }
    @FXML
    public void pickupCommand(ActionEvent event) {
        System.out.println(event.getSource());
    }
    @FXML
    public void buyCommand(ActionEvent event) {
        System.out.println(event.getSource());
    }
    @FXML
    public void discardCommand(ActionEvent event) {
        System.out.println(event.getSource());
    }
}


