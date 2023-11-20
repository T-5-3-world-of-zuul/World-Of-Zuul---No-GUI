package src.game.commands;

import src.game.Context;
/*
Fallback for when a command is not implemented
Child of BaseCommand and it implements the interface Command
 */


public class CommandUnknown extends BaseCommand implements Command {
  /**
   * The execute function is the main function of a command. It takes in three parameters:
   *
   *
   *
   * @param Context context Access the context of the command

   * @param String command Determine which command is being called
   * @param String parameters[] Pass the arguments to the command
   *
   * @return Void
   *
   */
  @Override
  public void execute (Context context, String command, String parameters[]) {
    System.out.println("Woopsie, I don't understand '"+command+"' 😕");
  }
}
