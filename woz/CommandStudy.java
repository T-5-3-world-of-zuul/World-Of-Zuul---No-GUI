public class CommandStudy extends BaseCommand implements Command{


    CommandStudy () {
        description = "Get hint on current problem (only usable in office) (0 parameters)";
    }



    @Override
    public void execute(Context context, String command, String[] parameters) {
        if(context.getCurrent().getName().equalsIgnoreCase("Office")){
            context.getRoundSystem().disasterHandler.hint();
            Player.getPlayer().removeEnergy(20);
        }else {
            System.out.println("Sorry, you can't study outside the Office 😕");
        }
    }
}
