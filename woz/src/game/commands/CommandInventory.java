package src.game.commands;

import src.game.Context;
import src.game.Item;
public class CommandInventory extends BaseCommand implements Command{

    public CommandInventory(){
        description = "view current inventory";
    }
    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("---------------------");
        System.out.println("Items in src.game.Inventory : ");
        for (Item item : context.getPlayerInventory().inventory) {
            System.out.println(" src.game.Item : " + item.name);
        }
        System.out.println("---------------------");
    }
}
