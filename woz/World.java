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
   * @docauthor Trelent
   */
  World () {
    Space entry    = new Space("Entry");
    Space corridor = new Space("Corridor");
    Space cave     = new Space("Cave");
    Space pit      = new Space("Darkest Pit");
    Space outside  = new Space("Outside");
    
    entry.addEdge("door", corridor);
    corridor.addEdge("door", cave);
    cave.addEdge("north", pit);
    cave.addEdge("south", outside);
    pit.addEdge("door", cave);
    outside.addEdge("door", cave);
    
    this.entry = entry;
  }
  
  /**
   * The getEntry function returns the entry of a given node.
   *
   *
   *
   * @return The entry of the room
   *
   * @docauthor Trelent
   */
  Space getEntry () {
    return entry;
  }
}

