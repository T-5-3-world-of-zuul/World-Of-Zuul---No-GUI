/* Command for exiting program
 */

//CommandExit is a child of BaseCommand and it implements command which is used to implement an interface
class CommandExit extends BaseCommand implements Command {

  /**
   * The execute function is the function that is called when a command
   * needs to be executed. It takes in three parameters:
   *
   *
   * @param Context context Access the context object
   * @param String command Determine what command to execute
   * @param String parameters[] Pass the parameters of the command
   *
   */
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
