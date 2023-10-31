public class Item {
    public int index;
    public String name;

    public Item(int itemIndex, String name){
        index = itemIndex;
        this.name = name;
    }

    //Obselete currently
    public enum itemTypes{
        shovel,
        sandbags,
        seeds
    }
}