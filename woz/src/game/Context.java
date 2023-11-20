package src.game;

/*
Context class to hold all context relevant to a session.
 */
public class Context {

  Space current;
  private boolean done = false;

  Inventory playerInventory = new Inventory();

  RoundSystem roundSystem = new RoundSystem(0,Game.getWorld(),true);

  /**
   * The Context function is used to set the current node in the tree.
   *
   *
   * @param Space node Set the current node to the one that is passed in
   *
   * @return A pointer to the current node
   *
   */
  Context (Space node) {
    current = node;
  }
  
  /**
   * The getCurrent function returns the current space that the player is on.
   *
   *
   *
   * @return The current space
   *
   */
  public Space getCurrent() {
    return current;
  }

  public Inventory getPlayerInventory(){
    return playerInventory;
  }

  public RoundSystem getRoundSystem(){
    return roundSystem;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public boolean getDone () {return done;}

  /**
   * The transition function takes a direction as an argument and moves the player to the next space in that direction.
   * If there is no space in that direction, it prints out a message saying so.
   *
   *
   * @param String direction Determine which direction the player wants to go
   *
   * @return A space
   *
   */
  public void transition (String direction) {

    Space next = current.followEdge(direction);
    if (next==null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
    }
  }
  
  /**
   * The makeDone function sets the done variable to true.

   *
   *
   * @return Nothing
   *
   */
  public void makeDone () {
    done = true;
  }
  
  /**
   * The isDone function returns a boolean value that indicates whether or not the
   * game is over. The game is over when all of the tiles have been flipped and
   * matched, so this function checks to see if there are any unflipped tiles left.

   *
   *
   * @return A boolean value that is true if the task has been completed and false otherwise
   *
   */
  public boolean isDone () {
    return done;
  }
}

