package model;

public class Node<K,V> {
    private V value;
    private K key;
    private Node<K,V> next;
    private Node<K,V> prev;
    public Node(K key, V value ) {
        this.key = key;
        this.value = value;
    }
    public Node<K, V> getPrev() {
        return prev;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

}