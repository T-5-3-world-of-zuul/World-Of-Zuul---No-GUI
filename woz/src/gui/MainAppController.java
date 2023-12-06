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

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import src.game.Context;
import src.game.Game;
import src.game.Item;
import src.game.QuizRegistry;

public class MainAppController implements Initializable {
    @FXML
    public VBox CommandPaneList;

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

    private static VBox OutputPaneListStat;

    private Context context;

    private static Pane[] panesDisabled;
    public MainAppController() {
        context = Game.getContext();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDisplayPane();
        updateNavigationPane();
        updateInventoryPane();
        OutputPaneListStat = OutputPaneList;
    }

    private void updateDisplayPane() {
        CurrentRoomLabel.setText(context.getCurrent().getName());
        EnergyAmountLabel.setText(context.getPlayer().getEnergy() + "/" + context.getPlayer().getMaxEnergy());
        CurrentYearLabel.setText(String.valueOf(context.getRoundSystem().getRound()));
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
    private void updateOutputPane(List<String> list, List<Button> btnList) {
        ArrayList<Label> labelList = new ArrayList<>();
        for (String displayText : list) {
            Label label = new Label(displayText);
            label.setWrapText(true);
            label.setMaxWidth(440);
            labelList.add(label);
        }


        OutputPaneList.getChildren().clear();
        OutputPaneList.getChildren().addAll(labelList);
        OutputPaneList.getChildren().addAll(btnList);
    }
    private static void updateOutputPane(List<String> list) {
        ArrayList<Label> labelList = new ArrayList<>();
        for (String displayText : list) {
            Label label = new Label(displayText);
            label.setWrapText(true);
            label.setMaxWidth(440);
            labelList.add(label);
        }
        OutputPaneListStat.getChildren().clear();
        OutputPaneListStat.getChildren().addAll(labelList);
    }

    private void updateOutPane(List<Button> list) {
        OutputPaneList.getChildren().clear();
        OutputPaneList.getChildren().addAll(list);
    }


    @FXML
    public void sleepCommand(ActionEvent event) throws IOException{
        Game.getRegistry().dispatch("sleep");

        ArrayList<String> outputText = new ArrayList<>();
        outputText.add(Game.getRegistry().getOutput());
        updateOutputPane(outputText);
        if (context.getRoundSystem().getRound() != 1 && context.getCurrent().getName().equalsIgnoreCase("Bedchamber")){
            quizStartGUI();
        }


        updateDisplayPane();

    }

    public void quizStartGUI(){



        List<Button> btnList = QuizRegistry.quiz.get(0).startQuiz();
        ArrayList<String> outputText = new ArrayList<>();
        outputText.add(Game.getRegistry().getOutput());
        updateOutputPane(outputText, btnList);
        Pane[] panes = new Pane[]{NavigationPane, InventoryPaneList, CommandPaneList};
        disablePanes(panes);


    }



    public void disablePanes(Pane[] panes){
        for (Pane pane : panes) {
            pane.setDisable(true);
        }
        panesDisabled = panes.clone();
    }

    public static void activateAllPanes(){

        for (Pane pane : panesDisabled) {
            pane.setDisable(false);
        }
        ArrayList<String> outputText = new ArrayList<>();
        outputText.add(Game.getRegistry().getOutput());
        updateOutputPane(outputText);
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
        ArrayList<Button> buttonList = new ArrayList<>();
        for (int i = 0 ; i < context.getCurrent().itemsInRoom.inventory.size() ; i++) {
            Button button = new Button(context.getCurrent().itemsInRoom.inventory.get(i).name);
            button.setPrefHeight(60);
            button.setPrefWidth(440);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Game.getRegistry().dispatch("pickup " + button.getText());
                    OutputPaneList.getChildren().clear();
                    updateInventoryPane();
                }
            });

            buttonList.add(button);
        }
        updateOutPane(buttonList);
    }
    @FXML
    public void buyCommand(ActionEvent event) {
        ArrayList<Button> buttonList = new ArrayList<>();
        Button cancelButton = new Button("cancel");
        buttonList.add(cancelButton);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game.getRegistry().dispatch("buy cancel");
                updateDisplayPane();
                OutputPaneList.getChildren().clear();
            }
        });
        for (int i = 0 ; i < Item.getItemList().size() ; i++) {
            String label = Item.getItemList().get(i).name;

            Button button = new Button(label);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Game.getRegistry().dispatch("buy " + button.getText());

                    updateDisplayPane();
                    OutputPaneList.getChildren().clear();
                }
            });
            buttonList.add(button);
        }
        updateOutPane(buttonList);

    }
    @FXML
    public void discardCommand(ActionEvent event) {
        ArrayList<Button> buttonList = new ArrayList<>();
        for (int i = 0 ; i < context.getPlayerInventory().inventory.size() ; i++) {
            String label = context.getPlayerInventory().inventory.get(i).name.substring(0, 1).toUpperCase() + context.getPlayerInventory().inventory.get(i).name.substring(1);
            Button button = new Button(label);
            button.setPrefHeight(60);
            button.setPrefWidth(440);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Game.getRegistry().dispatch("discard " + button.getText().toLowerCase());
                    updateInventoryPane();
                    OutputPaneList.getChildren().clear();
                }
            });
            buttonList.add(button);

        }
        updateOutPane(buttonList);
    }
    @FXML
    public void helpMenu(ActionEvent event){
        System.out.println("clicked help");
    }
}