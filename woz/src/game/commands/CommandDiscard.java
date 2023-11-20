package src.game.commands;

import src.game.Context;
import src.game.Item;
public class CommandDiscard extends BaseCommand implements Command{

    public CommandDiscard(){
        description = "discard item and put in current room";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //implement picking item up in inventory, when inventory system made
        if(guardEq(parameters, 1)){
            System.out.println("You need to enter, what you want discarded");
            return;
        }

        Item item = context.getPlayerInventory().CheckForItem(parameters[0]);
        if(item != null){
            context.getCurrent().itemsInRoom.AddItemToInventory(item);
            context.getPlayerInventory().inventory.remove(item);
            System.out.println("You discarded : " + item.name);
        } else{
            System.out.println("Sorry you dont have " + parameters[0] + " in your inventory");
        }

    }
}
