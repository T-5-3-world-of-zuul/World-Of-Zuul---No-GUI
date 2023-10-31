/* World class for modeling the entire in-game world
 */

class World {
  Space entry;
  
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
    Space bedchamber    = new Space("Bedchamber");
    Space office    = new Space("Office");
    Space houseEntry    = new Space("House");
    Space outside = new Space("Outside");
    Space barn     = new Space("Barn");
    Space well      = new Space("Well");
    Space field1  = new Space("Field 1");
    Space field2  = new Space("Field 2");
    Space field3  = new Space("Field 3");


    bedchamber.addEdge("Entry", houseEntry);
    houseEntry.addEdge("Bedchamber", bedchamber);
    houseEntry.addEdge("Outside", outside);
    houseEntry.addEdge("Office", office);
    office.addEdge("outside", houseEntry);
    outside.addEdge("House", houseEntry);
    outside.addEdge("Barn", barn);
    outside.addEdge("Well", well);
    outside.addEdge("Field 1", field1);
    outside.addEdge("Field 2", field2);
    outside.addEdge("Field 3", field3);
    field1.addEdge("outside", outside);
    field2.addEdge("outside", outside);
    field3.addEdge("outside", outside);
    barn.addEdge("outside", outside);
    well.addEdge("outside", outside);

    bedchamber.itemsInRoom.AddItemToInventory(new Item(0, "seeds"));

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
}

