package model;

public class HashNode<K,V> {
    private V value;
    private K key;
    private HashNode<K,V> next;
    private HashNode<K,V> prev;
    public HashNode(K key, V value ) {
        this.key = key;
        this.value = value;
    }
    public HashNode<K, V> getPrev() {
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

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    public void setPrev(HashNode<K, V> prev) {
        this.prev = prev;
    }

}