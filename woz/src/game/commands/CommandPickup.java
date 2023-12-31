package src.game.commands;

import src.game.Context;
import src.game.Item;
/*
Command for picking up items in room
 */

public class CommandPickup extends BaseCommand implements Command{

    public CommandPickup(){
        description = "pickup specific item in current room, (1 parameter : item name)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //implement picking item up in inventory, when inventory system made
        if(guardEq(parameters, 1)){
            System.out.println("You need to enter, what you want picked up");
            return;
        }

        Item item = context.getCurrent().itemsInRoom.CheckForItem(parameters[0]);
        if(item != null){
            context.getPlayerInventory().AddItemToInventory(item);
            context.getCurrent().itemsInRoom.inventory.remove(item);
            System.out.println("You picked up : " + item.name);
        } else{
            System.out.println("Sorry, What do you want to pickup?");
        }
    }
}
