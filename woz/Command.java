/**
 * The Command interface defines a contract for implementing
 * executable commands in a software application.
 */
interface Command {

  /**
   * Executes the command with the provided context, command name, and parameters.
   *
   * @param context    The context in which the command is executed, which may contain
   *                   relevant information or resources.
   * @param command    The name or identifier of the command to be executed.
   * @param parameters An array of parameters or arguments associated with the command.
   */
  void execute(Context context, String command, String parameters[]);

  /**
   * Provides a brief description or explanation of the command.
   *
   * @return A String describing the purpose or functionality of the command.
   */
  String getDescription();
}
