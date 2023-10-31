public class CommandDiscard extends BaseCommand implements Command{

    CommandDiscard(){
        description = "discard item and put in current room";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //implement picking item up in inventory, when inventory system made
        if (guardEq(parameters, 1)) {
            System.out.println("Sorry, not possible 🤔");
            return;
        }

    }
}
