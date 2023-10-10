/* Help command
 */

import java.util.Arrays;

class CommandHelp extends BaseCommand implements Command {
  Registry registry;
  
  /**
   * The CommandHelp function displays a help message.
   *
   *
   * @param Registry registry Access the registry of commands
   *
   * @return A string
   *
   * @docauthor Trelent
   */
  CommandHelp (Registry registry) {
    this.registry = registry;
    this.description = "Display a help message";
  }
  
  /**
   * The execute function prints out a list of all the commands that are available to the user.
   * It does this by first finding the maximum length of any command name, then printing out each
   * command name and its description in a formatted way.

   *
   * @param Context context Access the context of the command
   * @param String command Get the name of the command
   * @param String[] parameters Pass the parameters of the command
   *
   * @return Void
   *
   * @docauthor Trelent
   */
  @Override
  public void execute (Context context, String command, String[] parameters) {
    String[] commandNames = registry.getCommandNames();
    Arrays.sort(commandNames);
    
    // find max length of command name
    int max = 0;
    for (String commandName: commandNames) {
      int length = commandName.length();
      if (length>max) max = length;
    }
    
    // present list of commands
    System.out.println("Commands:");
    for (String commandName: commandNames) {
      String description = registry.getCommand(commandName).getDescription();
      System.out.printf(" - %-"+max+"s %s%n", commandName, description);
    }
  }
}
