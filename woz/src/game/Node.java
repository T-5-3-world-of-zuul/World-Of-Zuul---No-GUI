package src.game;/* Node class for modeling graphs
 */

import java.util.HashMap;
import java.util.Map;

class Node {
  String name;
  String imageURl;
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
  Node (String name, String imageURl) {
    this.name = name.toLowerCase();
    this.imageURl = imageURl;

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

    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

  public String getImageURl() {
    return imageURl;
  }

  public Map<String, Node> getEdges() {
    return edges;
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
    edges.put(name.toLowerCase(), node);
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
    return edges.get(direction.toLowerCase());
  }
}

