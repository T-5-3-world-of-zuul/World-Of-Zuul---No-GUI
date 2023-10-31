import java.util.ArrayList;
public class Inventory {
    public ArrayList<Item> inventory = new ArrayList<>();

    public void AddItemToInventory(Item item){
        int inventorySlots = 8;
        if(inventory.size() >= inventorySlots) {
            return;
        }
        inventory.add(item);
    }

    public void RemoveItemFromInventory(int itemIndex){
        for (Item item:
                inventory) {
            if(item.index == itemIndex)
                inventory.remove(itemIndex);
        }
    }

    public boolean CheckForItem(int itemIndex){
        for (Item item:
                inventory){
            if(item.index == itemIndex)
                return true;
        }
        return false;
    }
}