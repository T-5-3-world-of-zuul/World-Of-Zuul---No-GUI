/* Node class for modeling graphs
 */

import java.util.HashMap;
import java.util.Map;

class Node {
  String name;
  Map<String, Node> edges = new HashMap<String, Node>();
  
  /**
   * The Node function is a constructor that creates a new node with the given name.
   *
   *
   * @param String name Set the name of the node
   *
   * @return A new node with the name of the parameter
   *
   */
  Node (String name) {
    this.name = name;

  }
  
  /**
   * The getName function returns the name of the person.
   *
   *
   *
   * @return The name of the person
   *
   */
  public String getName () {
    return name;
  }
  
  /**
   * The addEdge function adds a new edge to the node.
   *
   *
   * @param String name Identify the edge, and the node node parameter is used to store a reference to another node
   * @param Node node Add a node to the edges hashmap
   *
   * @return Nothing, it is a void function
   *
   */
  public void addEdge (String name, Node node) {
    edges.put(name, node);
  }
  
  /**
   * The followEdge function takes in a direction and returns the node that is connected to this node by an edge with that direction.
   *
   *
   * @param String direction Determine which edge to follow
   *
   * @return The node that is connected to the current node by the edge with the given direction
   *
   */
  public Node followEdge (String direction) {
    return edges.get(direction);
  }
}

