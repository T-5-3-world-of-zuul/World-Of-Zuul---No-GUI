public class CommandSearch extends BaseCommand implements Command{

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
