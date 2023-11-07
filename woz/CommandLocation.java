public class CommandLocation extends BaseCommand implements Command{

    CommandLocation(){
        description = "locate current location + passages (0 parameters)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        context.getCurrent().welcome();
    }
}
