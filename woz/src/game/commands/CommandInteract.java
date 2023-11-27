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
        if (guardEq(parameters, 1)) {
            System.out.println("You inputted to few or to many parameters");
            return;
        }

        Item choosenItem = context.getPlayerInventory().CheckForItem(parameters[0]);

        if (choosenItem == null) {
            System.out.println("that item isn't in your inventory");
            return;
        }
        Space curremtRoom = context.getCurrent();

        Scanner sc = Game.getScanner();

        switch (choosenItem.itemType) {
            case tool:
                if (curremtRoom.getName().equalsIgnoreCase("Field1") || curremtRoom.getName().equalsIgnoreCase("Field2") || curremtRoom.getName().equalsIgnoreCase("Field3")) {

                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case sandbags:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have barricaded " + curremtRoom.getName() + " with sandbags");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case seeds:
                if(curremtRoom.getName().equalsIgnoreCase("Field 1") || curremtRoom.getName().equalsIgnoreCase("Field 2") || curremtRoom.getName().equalsIgnoreCase("Field 3")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have planted " + choosenItem.name + " in : "+ curremtRoom.getName());
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case waterPump:
                if (curremtRoom.getName().equalsIgnoreCase("Well")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have installed a Water pump on the well");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case pesticide:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have used pesticide.");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case plantPesticide:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have used plant pesticide.");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case fertilizer:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have used fertilizer.");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;

            case antihailnet:
                if (curremtRoom.getName().equalsIgnoreCase("Field 1")) {
                    curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                    context.getPlayerInventory().inventory.remove(choosenItem);
                    System.out.println("You have build an anti-hail net.");
                } else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
        }
    }
}
