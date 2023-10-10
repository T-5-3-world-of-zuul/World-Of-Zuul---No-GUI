/* Baseclass for commands
 */


//Defines a class called BaseCommand
class BaseCommand {

  //Creates a variable which is a string and sets it to "Undocumented"
  String description = "Undocumented";


  /**
   * The guardEq function checks if the length of the parameters array is equal to
   * the bound value. If it is, then this method returns true, indicating that
   * guard condition has failed. Otherwise, it returns false.

   *
   * @param String[] parameters Store the parameters of the method
   * @param int bound Check if the length of the parameters array is equal to bound
   *
   * @return True if the length of the parameters array is equal to
   *
   */
  protected boolean guardEq (String[] parameters, int bound) {

    //Checks if the length of the parameters array is not equal to the bound value,
    //if the method returns true, indicating that the guard condition has failed.
    return parameters.length!=bound;
  }


  /**
   * The getDescription function returns the description of the item.
   *
   * @return The description of the object
   *
   */
  public String getDescription () {
    return description;
  }
}
