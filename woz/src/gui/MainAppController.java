package src.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.scene.layout.AnchorPane;
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
    private Label CurrentDisasterLabel;
    @FXML
    private VBox NavigationPane;
    @FXML
    private ImageView BackgroundImg;
    @FXML
    private VBox InventoryPaneList;
    @FXML
    private VBox OutputPaneList;

    private Context context;

    public MainAppController() {
        context = Game.getContext();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDisplayPane();
        updateNavigationPane();
        updateInventoryPane();
    }

    private void updateDisplayPane() {
        CurrentRoomLabel.setText(context.getCurrent().getName());
        EnergyAmountLabel.setText(context.getPlayer().getEnergy() + "/" + context.getPlayer().getMaxEnergy());
        CurrentYearLabel.setText(String.valueOf(context.getRoundSystem().getRound() + 1));
        CurrentDisasterLabel.setText(context.getRoundSystem().disasterHandler.getDisasterName());
        BackgroundImg.setImage(new Image(context.getCurrent().getImageURl()));
    }
    private void updateNavigationPane() {
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
                    updateNavigationPane();
                    updateDisplayPane();
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
                    interactWithItem(button);
                }
            });
            buttonList.add(button);
        }
        InventoryPaneList.getChildren().clear();
        InventoryPaneList.getChildren().addAll(buttonList);
    }

    private void interactWithItem(Button button) {
        OutputPaneList.getChildren().clear();
        Label interactWith = new Label("Would you like to interact with " + button.getText().toLowerCase());
        interactWith.setWrapText(true);
        interactWith.setMaxWidth(440);
        Button yesBtn = new Button("Yes");
        yesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game.getRegistry().dispatch("interact " + button.getText().toLowerCase() + " Yes");
                updateInventoryPane();
                ArrayList<String> outputText = new ArrayList<>();
                outputText.add(Game.getRegistry().getOutput());
                updateOutputPane(outputText);

            }
        });
        Button noBtn = new Button("No");
        noBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game.getRegistry().dispatch("interact " + button.getText().toLowerCase() + " No");
                updateInventoryPane();
                OutputPaneList.getChildren().clear();
            }
        });
        OutputPaneList.getChildren().addAll(interactWith, yesBtn, noBtn);
    }

    private void updateOutputPane(List<String> list) {
        ArrayList<Label> labelList = new ArrayList<>();
        for (String displayText : list) {
            Label label = new Label(displayText);
            label.setWrapText(true);
            label.setMaxWidth(440);
            labelList.add(label);
        }
        OutputPaneList.getChildren().clear();
        OutputPaneList.getChildren().addAll(labelList);
    }

    @FXML
    public void sleepCommand(ActionEvent event) throws IOException{
        Game.getRegistry().dispatch("sleep");
        updateDisplayPane();
    }
    @FXML
    public void studyCommand(ActionEvent event) {
        Game.getRegistry().dispatch("study");
        updateDisplayPane();
        ArrayList<String> outputText = new ArrayList<>();
        outputText.add(Game.getRegistry().getOutput());
        updateOutputPane(outputText);
    }
    @FXML
    public void searchCommand(ActionEvent event) {
        Game.getRegistry().dispatch("search");
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


