package model;

import exceptions.ListIsNullException;

public class Stack<K,V> implements IStack<V> {

    private ElementNode<V> top;

    private int size = 0;

    public Stack() {
    }

    @Override
    // The `push` method in the `Stack` class is used to add a new element to the top of the stack.
    public boolean push(V value) {
        ElementNode<V> node = new ElementNode(value);
        boolean flag = false;
        if (top == null) {
            top = node;
            flag = true;
            size++;
        } else {
            node.setNext(top);
            top = node;
            flag = true;
            size++;
        }
        return flag;
    }

   /**
    * The function pops the top element from a linked list and returns its value, throwing an exception
    * if the list is empty.
    * 
    * @return The method is returning the value of the element that is being popped from the top of the
    * list.
    */
    @Override
    public V pop() throws ListIsNullException {
        ElementNode<V> currentTop = top;
        ElementNode<V> currentPointer = top;
        if (currentPointer != null) {
            currentPointer = top.getNext();
            top = currentPointer.getNext();
            size--;
            if (top != null) {
                top.setPrev(null);
            }
            return currentTop.getValue();
        } else {
            throw new exceptions.ListIsNullException("The list is empty");
        }
    }

    /**
     * The Top() function returns the value of the top element in a data structure.
     * 
     * @return The method is returning the value of the top element in the data structure.
     */
    @Override
    public V Top(){
        return this.top.getValue();
    }

    /**
     * The function returns the size of an object.
     * 
     * @return The size of the object.
     */
    @Override
    public int size() {
        return this.size;
    }

/**
 * The function checks if the top element of a stack is null, indicating that the stack is empty.
 * 
 * @return The method is returning a boolean value, which indicates whether the top element of the
 * stack is null or not. If the top element is null, it means the stack is empty and the method will
 * return true. Otherwise, it will return false.
 */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
/**
 * The toString() function iterates through a linked list and concatenates the values of each node into
 * a string, separated by newlines.
 * 
 * @return The method is returning a string representation of the elements in the linked list.
 */

    public String toString(){
        String msg = "";
        ElementNode<V> pointer = top;
        while(pointer != null){
            msg += pointer.getValue() + "\n";
            pointer = pointer.getNext();
        }
        return msg;
    }

}