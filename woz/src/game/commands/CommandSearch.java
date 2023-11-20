package src.game.commands;

import src.game.Context;
import src.game.Item;
public class CommandSearch extends BaseCommand implements Command{


    public CommandSearch () {
        description = "Search current room for items (0 parameters)";
    }
    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("---------------------");
        System.out.println("Items in room:");
        for (Item item: context.getCurrent().itemsInRoom.inventory) {
            System.out.println("item : " + item.name);
        }
        System.out.println("---------------------");
    }
}
