package model;

public interface IQueue<V> {

   /**
    * The enqueue function adds an element to the end of a queue.
    * 
    * @param element The element parameter is the value that you want to add to the queue.
    * @return The enqueue method returns a boolean value.
    */
    boolean enqueue(V element);

    /**
     * The function dequeues and returns the element at the front of the queue.
     * 
     * @return The dequeue() function is returning the element that is removed from the front of the
     * queue.
     */
    V dequeue();

   /**
    * The function "front" returns the element at the front of a data structure.
    * 
    * @return The function `front()` is returning the value at the front of a data structure, such as a
    * queue or a deque.
    */
    V front();

    /**
     * The function checks if a data structure is empty.
     * 
     * @return The method `isEmpty()` returns a boolean value.
     */
    boolean isEmpty();

    /**
     * The function "size()" returns the size of a data structure.
     * 
     * @return an integer value.
     */
    int size();


}
