import java.util.Scanner;

public class CommandBuy extends BaseCommand implements Command {

    boolean transactionComplete;

    Player player = Player.getPlayer();
    CommandBuy(){
        description = "buy item and put in barn, (usable only in bedchamber) (0 parameters)";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        Space barn = World.getSpace("Barn");
        Scanner sc = Game.getScanner();

        transactionComplete = false;



        while (!transactionComplete){

            printBuyMenu();
            System.out.print(">");
            String choice = sc.nextLine();

            if(choice.equalsIgnoreCase("cancel")){
                System.out.println("you ended your order");
                transactionComplete = true;
                break;
            }
            Item foundItem = findItem(choice);

            if (foundItem != null){
                if(player.getEnergy() > foundItem.price){
                    player.removeEnergy(foundItem.price);
                    barn.itemsInRoom.inventory.add(foundItem);
                    System.out.println("You bought : " + foundItem.name + " you have " + player.getEnergy()+" energy left, item can be found in barn");
                } else{
                    System.out.println("You don't have enough energy to buy that");
                }
            }else{
                System.out.println("that item doesnt exist");
            }

        }

    }

    public Item findItem(String itemName){
        for (Item item: Item.getItemList()) {

            if (item.name.equalsIgnoreCase(itemName)){
                return item;
            }

        }
        return null;
    }

    public void printBuyMenu(){
        System.out.println("---------------------");
        System.out.println("List of buyable items:");
        for (Item item: Item.getItemList()) {
            System.out.println("Item : " + item.name + "\tPrice: " + item.price + " energy");
        }
        System.out.println("---------------------");
        System.out.println("Energy : "+player.getEnergy());
        System.out.println("type the name of item to buy \ntype 'cancel' if you wish to end order");

    }

}
