public class CommandStudy extends BaseCommand implements Command{
    @Override
    public void execute(Context context, String command, String[] parameters) {
        if(context.getCurrent().getName().equals("Office")){
            //go to next round

        }else {
            System.out.println("Sorry, you can't study outside the Office 😕");
        }
    }
}