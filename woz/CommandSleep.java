public class CommandSleep extends BaseCommand implements Command{

    CommandSleep(){
        description = "sleep and go to next round, (usable only in bedchamber) (0 parameter)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {

        if(context.getCurrent().getName().equals("Bedchamber")){

            context.getRoundSystem().newRound();
        }else {
            System.out.println("Sorry, you can't sleep outside the bed chamber 😕");
        }

    }


}
