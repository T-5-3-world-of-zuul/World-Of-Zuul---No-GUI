/* Command for picking up items in room
 */

public class CommandPickup extends BaseCommand implements Command{

    CommandPickup(){
        description = "pickup specific item in current room";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        //implement picking item up in inventory, when inventory system made
        Item item = context.getCurrent().itemsInRoom.CheckForItem(parameters[0]);
        if(item != null){
            context.getPlayerInventory().AddItemToInventory(item);
        }
    }
}
