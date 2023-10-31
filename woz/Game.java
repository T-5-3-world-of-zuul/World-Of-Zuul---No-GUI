/* Main class for launching the game
 */

import java.util.Scanner;

class Game {
  static World    world    = new World();
  static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);

  public static World getWorld() {
    return world;
  }

  /**
   * The initRegistry function initializes the registry with a few commands.
   *
   *
   *
   *
   * @return A commandregistry object
   *
   */
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("exit", cmdExit);
    registry.register("quit", cmdExit);
    registry.register("bye", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("study", new CommandStudy());
    registry.register("sleep", new CommandSleep());
    registry.register("search", new CommandSearch());
    registry.register("pickup", new CommandPickup());
    registry.register("interact", new CommandInteract());
    registry.register("buy", new CommandBuy());
    registry.register("discard", new CommandDiscard());
    registry.register("inventory", new CommandInventory());
  }
  
  /**
   * The main function is the entry point of the program.
   * It initializes a new game context, and then enters a loop that reads user input from stdin,
   * dispatches it to the command registry for processing, and repeats until either an exit command is issued or
   * an error occurs. The main function also prints out welcome messages at startup and goodbye messages when exiting.

   *
   * @param String args[] Pass command line arguments to the program
   *
   * @return Nothing (void)
   *
   */
  public static void main (String[] args) {
    System.out.println("Welcome to the World of Zuul!");
    
    initRegistry();
    context.getCurrent().welcome();



    while (!context.isDone()) {
      System.out.print("> ");
      String line = scanner.nextLine();
      registry.dispatch(line);
    }
    System.out.println("Game Over 😥");
  }
}
