package src.game.commands;
import src.game.Context;
/*
Command for transitioning between spaces
CommandGo is a child of BaseCommand which means that CommandGo can do everything the BaseCommand can.
 */

public class CommandGo extends BaseCommand implements Command {
  /**
   * The CommandGo function takes the user's input and checks to see if it matches any of the exits in the current room.
   * If there is a match, then it will change rooms to that exit's destination.
   *
   *
   * @return The exit that the player is trying to go through
   *
   */
  public CommandGo () {
    description = "Follow an exit";
  }

  /**
   * The execute function takes in a Context object, a String command, and an array of Strings called parameters.
   * It checks if the parameters array has exactly one element using the guard method. If not, it prints an error message and returns.
   * If the parameters array has exactly one element, it calls the transition method of the Context object with that parameter as its argument.

   *
   * @param Context context Call the transition method of the context object
   * @param String command Check if the command is equal to &quot;go&quot;

   * @param String[] parameters Pass the command line arguments to the execute method
   *
   * @return Nothing
   *
   */
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      System.out.println("I don't seem to know where that is 🤔");
      return;
    }
    context.transition(parameters[0]);
  }
}
