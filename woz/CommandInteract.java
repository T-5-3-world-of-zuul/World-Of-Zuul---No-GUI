import java.util.Scanner;

public class CommandInteract extends BaseCommand implements Command{

    CommandInteract(){
        this.description = "interact with item (1 parameter), example : 'interact sandbag'";
    }
    @Override
    public void execute(Context context, String command, String[] parameters) {
        if(guardEq(parameters,1)){
            System.out.println("You inputted to few or to many parameters");
            return;
        }

        Item choosenItem = context.getPlayerInventory().CheckForItem(parameters[0]);

        if (choosenItem == null){
            System.out.println("that item isn't in your inventory");
            return;
        }
        Space curremtRoom = context.getCurrent();

        Scanner sc = Game.getScanner();
        
        switch (choosenItem.itemType){
            case tool:
                if(curremtRoom.getName().equals("Field1") || curremtRoom.getName().equals("Field2") || curremtRoom.getName().equals("Field3")){

                }else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case sandbags:
                if(curremtRoom.getName().equals("Field 1") || curremtRoom.getName().equals("Field 2") || curremtRoom.getName().equals("Field 3")){
                    System.out.print("Do you want to barricade your field with sandbags \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if(choice.equals("YES")){
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        System.out.println("You have barricaded "+curremtRoom+" with sandbags");
                    } else if (choice.equals("NO")) {
                        System.out.println("You chose not to barricade " + curremtRoom +" with sandbags");
                    } else{
                        while (!choice.equals("YES") && !choice.equals("NO")){
                            System.out.print("invalid choice, Do you want to baricade your field with sandbags \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }
                }else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
            case seeds:

                break;
            case waterPump:
                if(curremtRoom.getName().equals("Well")){
                    System.out.print("Do you want to install a water pump on your well \n[YES/NO] \n> ");
                    String choice = sc.nextLine();
                    if(choice.equals("YES")){
                        curremtRoom.itemsUsedInRoom.AddItemToInventory(choosenItem);
                        System.out.println("You have installed a Water pump on the well");
                    } else if (choice.equals("NO")) {
                        System.out.println("You chose not to install a water pump ");
                    } else{
                        while (!choice.equals("YES") && !choice.equals("NO")){
                            System.out.print("invalid choice, Do you want to install a Water pump on the well \n[YES/NO] \n>");
                            choice = sc.nextLine();
                        }

                    }
                }else {
                    System.out.println("Sorry, you can't use that here");
                }
                break;
        }


    }
}
