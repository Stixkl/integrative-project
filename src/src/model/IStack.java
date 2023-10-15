package model;

import exceptions.ListIsNullException;

public interface IStack<V> {

    /**
     * The push function is used to add a value to a data structure.
     * 
     * @param value The value parameter represents the value that you want to push onto a data
     * structure, such as a stack or a queue.
     * @return The push method returns a boolean value.
     */
    boolean push(V value);

    /**
     * The pop() function removes and returns the top element from a stack.
     * 
     * @return The pop() method is used to remove and return the last element from a list. In this
     * case, if the list is null (empty), it will throw a ListIsNullException.
     */
    V pop() throws ListIsNullException;

    /**
     * The function "Top" returns the top element of a stack.
     * 
     * @return The top element of the stack.
     */
    V Top();

    /**
     * The function "size()" returns the size of a data structure.
     * 
     * @return an integer value.
     */
    int size();

    /**
     * The function checks if a data structure is empty.
     * 
     * @return The method `isEmpty()` returns a boolean value.
     */
    boolean isEmpty();






}
