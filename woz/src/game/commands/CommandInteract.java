package src.game.commands;

import src.game.Context;
import src.game.Item;
import src.game.Space;
import src.game.Game;


import java.util.Scanner;

public class CommandInteract extends BaseCommand implements Command {

    public CommandInteract() {
        this.description = "interact with item (1 parameter), example : 'interact sandbag'";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 2)) {
            System.out.println("You inputted to few or to many parameters");
            return;
        }

        Item choosenItem = context.getPlayerInventory().CheckForItem(parameters[0]);

        Space curremtRoom = context.getCurrent();

        String answer = parameters[1];
        if (answer.equalsIgnoreCase("Yes")) {
            switch (choosenItem.itemType) {
                case tool:
                    if (curremtRoom.getName().equalsIgnoreCase("Field1") || curremtRoom.getName().equalsIgnoreCase("Field2") || curremtRoom.getName().equalsIgnoreCase("Field3")) {

                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case sandbags:
                    if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have barricaded " + curremtRoom.getName() + " with sandbags");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case seeds:
                    if(curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have planted " + choosenItem.name + " in : "+ curremtRoom.getName());
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case waterPump:
                    if (curremtRoom.getName().equalsIgnoreCase("Well")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have install a Water pump on the well");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case pesticide:
                    if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have used pesticide");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;
                case plantPesticide:
                    if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have used plant pesticide");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case fertilizer:
                    if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have used fertilizer");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;

                case antihailnet:
                    if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        context.getPlayerInventory().inventory.remove(choosenItem);
                        Game.getRegistry().setOutput("You have build an anti-hail net");
                    } else {
                        Game.getRegistry().setOutput("Sorry, you can't use that here");
                    }
                    break;
            }
        }
    }
}
