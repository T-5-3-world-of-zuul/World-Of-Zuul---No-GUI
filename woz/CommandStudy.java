public class CommandStudy extends BaseCommand implements Command {
    PlayerEnergy player = PlayerEnergy.getPlayer();
    DisasterHandler disasterHandler = new DisasterHandler();
    CommandStudy() {
        description = "Get hint on current problem (only usable in office) (0 parameters)";
    }
    
    @Override
    public void execute(Context context, String command, String[] parameters) {
        if(context.getCurrent().getName().equalsIgnoreCase("Office")) {
            if(!player.isOutOfEnergy()) {
                System.out.println(context.getRoundSystem().getRound());
                context.getRoundSystem().disasterHandler.hint(context.getRoundSystem().getRound());
                player.removeEnergy(20);
                System.out.println("You have " + player.getEnergy() + " energy left");
            } else {
                context.done = true;
                System.out.println("You have run out of energy, you can't do anything else");
            }
        } else {
            System.out.println("Sorry, you can't study outside the Office 😕");
        }
    }
}
