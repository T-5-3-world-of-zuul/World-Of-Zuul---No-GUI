package src.game;
/*
World class for modeling the entire in-game world
 */
import java.util.ArrayList;

public class World {
  Space entry;

  static ArrayList<Space> rooms = new ArrayList<Space>();



  /**
   * The World function creates a new world with the following spaces:
   *
   * Entry, Corridor, Cave, Darkest Pit and Outside. It also adds edges to each of these spaces so that they are connected in the following way:
   *
   * Entry -&gt; Corridor -&gt; Cave -&gt; Darkest Pit &lt;- Cave &lt;- Outside. The function then sets this.entry to be equal to entry (the first space). This is done so that we can access it from outside of this class when we need it for our game loop later on in main().


   *
   *
   * @return The entry space
   *
   */
  World () {
    Space bedchamber    = new Space("Bedchamber", "/src/images/BedchamberBackground.png");
    Space office    = new Space("Office", "/src/images/OfficeBackground.png");
    Space houseEntry    = new Space("House", "/src/images/HouseBackground.png");
    Space outside = new Space("Outside", "/src/images/OutsideBackground.png");
    Space barn     = new Space("Barn", "/src/images/BarnBackground.png");
    Space well      = new Space("Well", "/src/images/WellBackground.png");
    Space field1  = new Space("Field 1", "/src/images/Field1Background.png");
    Space field2  = new Space("Field 2", "/src/images/Field2Background.png");
    Space field3  = new Space("Field 3", "/src/images/Field3Background.png");

    World.rooms.add(bedchamber);
    World.rooms.add(office);
    World.rooms.add(houseEntry);
    World.rooms.add(outside);
    World.rooms.add(barn);
    World.rooms.add(well);
    World.rooms.add(field1);
    World.rooms.add(field2);
    World.rooms.add(field3);

    bedchamber.addEdge("Entry", houseEntry);
    houseEntry.addEdge("Bedchamber", bedchamber);
    houseEntry.addEdge("Outside", outside);
    houseEntry.addEdge("Office", office);
    office.addEdge("Entry", houseEntry);
    outside.addEdge("House", houseEntry);
    outside.addEdge("Barn", barn);
    outside.addEdge("Well", well);
    outside.addEdge("Field_1", field1);
    outside.addEdge("Field_2", field2);
    outside.addEdge("Field_3", field3);
    field1.addEdge("Outside", outside);
    field2.addEdge("Outside", outside);
    field3.addEdge("Outside", outside);
    barn.addEdge("Outside", outside);
    well.addEdge("Outside", outside);

    barn.itemsInRoom.AddItemToInventory(ItemRegistry.wheatSeed);
    barn.itemsInRoom.AddItemToInventory(ItemRegistry.cornSeed);




    this.entry = bedchamber;
  }
  
  /**
   * The getEntry function returns the entry of a given node.
   *
   *
   *
   * @return The entry of the room
   *
   */
  Space getEntry () {
    return entry;
  }

  public static Space getSpace(String space){
    for (Space spaces: rooms) {
      if (spaces.getName().equalsIgnoreCase(space)){
        return spaces;
      }
    }
      return null;
  }
}

