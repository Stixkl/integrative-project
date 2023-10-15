package model;

public class HashNode<K,V> {
    private V value;
    private K key;
    private HashNode<K,V> next;
    private HashNode<K,V> prev;

// The code snippet `public HashNode(K key, V value ) { this.key = key; this.value = value; }` is a
// constructor for the `HashNode` class.
    public HashNode(K key, V value ) {
        this.key = key;
        this.value = value;
    }

/**
 * The function returns the previous node in a hash table.
 * 
 * @return The method is returning a HashNode object.
 */
    public HashNode<K, V> getPrev() {
        return prev;
    }

/**
 * The function returns the value stored in a variable.
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
 * The function returns the key of a generic type.
 * 
 * @return The method is returning the value of the variable "key".
 */
    public K getKey() {
        return key;
    }

/**
 * The function returns the next node in a hash table.
 * 
 * @return The method is returning the next HashNode in the linked list.
 */
    public HashNode<K, V> getNext() {
        return next;
    }
/**
 * The function sets the next node in a linked list structure.
 * 
 * @param next The "next" parameter is of type HashNode<K, V>, which represents the next node in a
 * linked list.
 */
    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

/**
 * The function sets the previous node of a HashNode object.
 * 
 * @param prev The "prev" parameter is of type HashNode<K, V>, which represents the previous node in a
 * linked list structure.
 */
    public void setPrev(HashNode<K, V> prev) {
        this.prev = prev;
    }

}