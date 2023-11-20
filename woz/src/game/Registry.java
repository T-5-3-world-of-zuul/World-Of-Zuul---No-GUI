package src.game;
/*
Command registry
 */

import src.game.commands.*;
import java.util.HashMap;
import java.util.Map;

public class Registry {
  Context context;
  Command fallback;
  Map<String, Command> commands = new HashMap<String, Command>();
  
  /**
   * The Registry function is a constructor that takes in two parameters:
   *
   *
   *
   * @param Context context Get the context of the current activity
   * @param Command fallback Set the fallback command to be used when a command is not found
   *
   * @return A command object
   *
   */
  Registry (Context context, Command fallback) {
    this.context = context;
    this.fallback = fallback;
  }
  
  /**
   * The register function takes in a String and a Command object.
   * It then adds the String as the key and the Command object as
   * its value to commands HashMap. This allows us to access any command
   * by using its name (String) as an index into commands HashMap.

   *
   * @param String name Get the command from the hashmap
   * @param Command command Store the command object in a hashmap

  public void execute (string name) {

      commands
   *
   * @return Void, which means that nothing is returned
   *
   */
  public void register (String name, Command command) {
    commands.put(name, command);
  }
  
  /**
   * The dispatch function takes a line of input and splits it into an array of strings.
   * The first element is the command, and the rest are parameters.  It then calls getCommand()
   * to find a Command object that can handle this command, or null if there isn't one.
   * If there is one, it calls execute on that Command object with the context (the current state)
   * as well as all of the parameters from this line of input.   If there isn't one, it falls back to
   * calling execute on fallback instead (which just prints out &quot;Unknown command&quot;).    This
   *
   * @param String line Split the string into an array of strings
    private string[] getparameters (string[] elements) {
      if (elements
   *
   * @return The result of the execute function
   *
   */
  public void dispatch (String line) {
    String[] elements = line.split(" ");
    String command = elements[0];
    String[] parameters = getParameters(elements);
    Command handler = getCommand(command);
    (handler==null ? fallback : handler).execute(context, command, parameters);
  }
  
  /**
   * The getCommand function takes in a string and returns the command associated with that string.
   *
   *
   * @param String commandName Get the command from the hashmap
   *
   * @return The command object associated with the given name
   *
   */
  public Command getCommand (String commandName) {
    return commands.get(commandName);
  }
  
  /**
   * The getCommandNames function returns an array of strings containing the names of all commands that can be executed by this interpreter.
   *
   *
   *
   * @return An array of strings containing the names of all
   *
   */
  public String[] getCommandNames () {
    return commands.keySet().toArray(new String[0]);
  }
  
  // helpers
  
  /**
   * The getParameters function takes in an array of strings and returns a new array of strings that is one element shorter than the input.
   *
   *
   * @param String[] input Store the input from the user
   *
   * @return An array of strings,
   *
   */
  private String[] getParameters (String[] input) {
    String[] output = new String[input.length-1];
    for (int i=0 ; i<output.length ; i++) {
      output[i] = input[i+1];
    }
    return output;
  }
}

