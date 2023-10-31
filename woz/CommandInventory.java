public class CommandInventory extends BaseCommand implements Command{

    CommandInventory(){
        description = "view current inventory";
    }
    @Override
    public void execute(Context context, String command, String[] parameters) {
        System.out.println("Items in Inventory : ");
        for (Item item : context.getPlayerInventory().inventory) {
            System.out.println(" Item : " + item.name);
        }
    }
}
