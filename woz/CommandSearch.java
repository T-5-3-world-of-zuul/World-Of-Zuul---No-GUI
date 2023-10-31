public class CommandSearch extends BaseCommand implements Command{

    @Override
    public void execute(Context context, String command, String[] parameters) {

        for (Item item: context.getCurrent().itemsInRoom.inventory) {
            System.out.println("item : " + item.name);
        }
    }
}
