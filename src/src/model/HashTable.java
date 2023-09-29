package model;

public class HashTable<K,V> implements IHashTable<K,V>{

    private int size;
    private int elements;
    private Node<K,V>[] table;

    public HashTable(int capacity){
        this.size = 0;
        this.table = new Node[1000];
    }

    @Override
    public boolean insert(K key, V value) {
        if(value == null){
            return false;
        }

        int hash = hashFunction(key);

        Node<K,V> newNode = new Node<>(key,value);

        if(this.table[hash]==null){
            table[hash] = newNode;
            this.size++;
            return true;
        }else if(table[hash] != null && table[hash].getNext() == null){
            table[hash].setNext(new Node<>(key,value));
            newNode.setPrev(table[hash]);
            this.size++;
            return true;
        }else{
            Node<K,V> pointer = LastNodeAmpliar(table[hash]);
            pointer.setNext(newNode);
            newNode.setPrev(pointer);
            this.size++;
            return true;
        }
    }

    private Node<K,V> LastNodeAmpliar(Node<K,V> pointer){

        if(pointer.getNext() == null){
            return pointer;
        }else{
            return LastNodeAmpliar(pointer.getNext());
        }
    }

    @Override
    public V search(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int hashFunction(K key) {
        return 0;
    }
}