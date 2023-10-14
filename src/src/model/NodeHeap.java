package model;

public class NodeHeap<T> {

    private int priority;

    private T node;

 // The `public NodeHeap(int priority, T node)` constructor is initializing a new instance of the
 // `NodeHeap` class with the given priority and node. It sets the `priority` field to the value of the
 // `priority` parameter and the `node` field to the value of the `node` parameter.
    public NodeHeap(int priority, T node) {
        this.priority = priority;
        this.node = node;
    }

/**
 * The function returns the priority value.
 * 
 * @return The method is returning the value of the variable "priority".
 */
    public int getPriority() {
        return priority;
    }

 /**
  * The function sets the priority of an object.
  * 
  * @param priority The "priority" parameter is an integer value that represents the priority level of
  * an object or task. It is used to determine the order in which objects or tasks should be processed
  * or executed.
  */
    public void setPriority(int priority) {
        this.priority = priority;
    }
/**
 * The function returns the value of the node.
 * 
 * @return The method is returning the value of the variable "node". The type of the returned value is
 * T.
 */
    public T getNode() {
        return node;
    }

/**
 * The function sets the value of a node in a Java program.
 * 
 * @param node The parameter "node" is of type T, which means it can be any type of object.
 */
    public void setNode(T node) {
        this.node = node;
    }
}
