package model;

import exceptions.ListIsNullException;

public interface IPriorityHeap<K> {

/**
 * The function inserts a value and a key into a data structure.
 * 
 * @param value An integer value that you want to insert into a data structure or collection.
 * @param value2 The parameter "value2" is of type K, which means it can be any data type.
 * @return The return type of the method is boolean, so it will return either true or false.
 */
    boolean insert(int value, K value2);

/**
 * The function "extractMax" returns and removes the maximum element from a list.
 * 
 * @return The `extractMax()` method is expected to return the maximum element from the list.
 */
    K extractMax() throws ListIsNullException;

 /**
  * The function "max" returns the maximum value from a collection of elements.
  * 
  * @return The function `K max()` is returning a value of type `K`.
  */
    K max();

    /**
     * The function increases the key value of a given element to a new value.
     * 
     * @param value The value parameter represents the key that you want to increase the value of.
     * @param newValue newValue is an integer value that represents the new value to be assigned to the
     * key.
     */
    void increaseKey(K value, int newValue);



}
