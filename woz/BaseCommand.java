/* Baseclass for commands
 */


//Defines a class called BaseCommand
class BaseCommand {

  //Creates a variable which is a string and sets it to "Undocumented"
  String description = "Undocumented";


  //The method is declared as protected, which means that it can only be accessed within the same package or by a subclass of the class that defines it.
  //Takes an array of strings parameters and an integer bound as input and returns a boolean value.
  protected boolean guardEq (String[] parameters, int bound) {

    //Checks if the length of the parameters array is not equal to the bound value,
    //if the method returns true, indicating that the guard condition has failed.
    return parameters.length!=bound;
  }


  //Getter for the description
  public String getDescription () {
    return description;
  }
}
