package src.game;
/*
Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;

public class Space extends Node {
  public Inventory itemsInRoom = new Inventory();
  public Inventory itemsUsedInRoom = new Inventory();
  Space (String name, String imageUrl) {
    super(name, imageUrl);
  }




  /**
   * The welcome function prints out the name of the room and all possible exits.

   *
   *
   * @return Nothing, so it's return type is void
   *
   */
  public void welcome () {

  }
  
  /**
   * The goodbye function prints a goodbye message to the user.

   *
   *
   * @return Nothing
   *
   */
  public void goodbye () {
  }
  
  /**
   * The followEdge function is used to follow an edge in a given direction.
   *
   *
   * @param String direction Determine which direction the player is moving in
   *
   * @return The space that is connected to the current
   *
   */
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
