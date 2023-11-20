package src.game.commands;

import src.game.Context;
public class CommandSleep extends BaseCommand implements Command{

    public CommandSleep(){
        description = "sleep and go to next round, (usable only in bedchamber) (0 parameter)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {

        if(context.getCurrent().getName().equalsIgnoreCase("Bedchamber")){

            context.getRoundSystem().newRound();
        }else {
            System.out.println("Sorry, you can't sleep outside the bed chamber 😕");
        }

    }


}
