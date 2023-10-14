package model;

import exceptions.ListIsNullException;

public class Queue<V> {

    private ElementNode<V> front;
    private ElementNode<V> rear;

    private int size = 0;

    public Queue() {
    }

    /**
     * The enqueue function inserts an element at the end of the queue.
     * 
     * @param value The value to be inserted at the end of the queue.
     * @return The method is returning a boolean value.
     */
    public boolean enqueue(V value) { // inserta un elemento e al final de la queue
        ElementNode<V> node = new ElementNode(value);
        boolean flag = false;
        if (front == null) { // lista vacia
            front = node;
            rear = node;
            size++;
        } else {
            rear.setNext(node);
            node.setPrev(rear);
            rear = node;
            size++;
            flag = true;
        }
        return flag;
    }

   /**
    * The function dequeues (removes) the element at the front of the queue and returns its value.
    * 
    * @return The method is returning the value of the element that is being removed from the front of
    * the queue.
    */
    public V dequeue() throws ListIsNullException { // remueve el elemento del frente de la queue
        if (!this.isEmpty()) {
            V frontValue = front.getValue();
            ElementNode<V> nextFront = front.getNext();
            front = nextFront;
            size--;
            if (front != null) {
                front.setPrev(null);
            }
            return frontValue;
        } else {
            throw new ListIsNullException("The list is empty");
        }
    }

    /**
     * The peek() function returns the value of the front element in a data structure.
     * 
     * @return The method is returning the value of the front node in the data structure.
     */
    public V peek() {
        return front.getValue();
    }


   /**
    * The function checks if the front of a queue is null, indicating that the queue is empty.
    * 
    * @return The method is returning a boolean value.
    */
    public boolean isEmpty() {
        return front == null;
    }

/**
 * The function returns the size of an object.
 * 
 * @return The method is returning the value of the variable "size".
 */
    public int size() {
        return this.size;
    }

    /**
     * The function verifies if a given value exists in a linked list.
     * 
     * @param value The "value" parameter is the value that we want to verify if it exists in the
     * linked list.
     * @return The method is returning a boolean value.
     */
    public boolean verify(V value) {
        boolean flag = false;
        ElementNode<V> node = front;
        while (node != null && !flag) {
            flag = node.getValue().equals(value);
            node = node.getNext();
        }
        return flag;
    }


    // The `get(int index)` method in the `Queue` class is used to retrieve the value at a specific
    // index in the queue.
    public V get(int index) {
    	ElementNode<V> node = front;
    	int i = 0;
    	while(i!=index) {
    		node = node.getNext();
    		i++;
    	}
    	return node.getValue();
    }

    /**
     * The toString() function iterates through a linked list and concatenates the string
     * representation of each element, separated by newlines.
     * 
     * @return The method is returning a string representation of the values stored in the linked list.
     * Each value is appended to the string "msg" followed by a newline character.
     */
    public String toString(){
        String msg = "";
        ElementNode<V> node = front;
        while(node != null){
            msg += node.getValue().toString() + "\n";
            node = node.getNext();
        }
        return msg;
    }

/**
 * The search function iterates through a linked list and returns the value if it is found, otherwise
 * it returns null.
 * 
 * @param value The value parameter is the value that you want to search for in the linked list.
 * @return The method is returning the value of the node that matches the given value. If no matching
 * node is found, it returns null.
 */
    public V search(V value) {
    	ElementNode<V> node = front;
    	while(node != null) {
    		if(node.getValue().equals(value)) {
    			return node.getValue();
    		}
    		node = node.getNext();
    	}
    	return null;
    }
}

