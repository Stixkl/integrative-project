package model;

public class ElementNode<V> {

    private V value;
    private ElementNode<V> next;
    private ElementNode<V> prev;

// The `public ElementNode(V value)` constructor is initializing a new instance of the `ElementNode`
// class with the given value. It sets the `value` field of the `ElementNode` object to the provided
// value.
    public ElementNode( V value ) {
        this.value = value;
    }

/**
 * The function returns the previous element node in a linked list.
 * 
 * @return The method is returning an ElementNode object with a generic type V.
 */
    public ElementNode< V> getPrev() {
        return prev;
    }

/**
 * The function returns the value associated with a key in a data structure.
 * 
 * @return The method is returning the value of type V.
 */
    public V getValue() {
        return value;
    }

/**
 * The function sets the value of a variable.
 * 
 * @param value The parameter "value" is of type V, which means it can be any type of object.
 */
    public void setValue(V value) {
        this.value = value;
    }

  /**
   * The function returns the next element node.
   * 
   * @return The method is returning an object of type ElementNode<V>.
   */
    public ElementNode<V> getNext() {
        return next;
    }

/**
 * The function sets the next element node in a linked list.
 * 
 * @param next The "next" parameter is of type ElementNode<V>, which represents the next node in a
 * linked list.
 */
    public void setNext(ElementNode<V> next) {
        this.next = next;
    }

/**
 * The function sets the previous element node of a given element node.
 * 
 * @param prev The "prev" parameter is of type ElementNode<V>, which represents the previous node in a
 * linked list.
 */
    public void setPrev(ElementNode<V> prev) {
        this.prev = prev;
    }

}
