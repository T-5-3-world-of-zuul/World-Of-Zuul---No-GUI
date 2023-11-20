package src.game.commands;

import src.game.Context;


public class CommandLocation extends BaseCommand implements Command{

    public CommandLocation(){
        description = "locate current location + passages (0 parameters)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        context.getCurrent().welcome();
    }
}
