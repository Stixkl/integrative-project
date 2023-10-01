package model;

public class HashTable<K,V> implements IHashTable<K,V>{

    private int size;
    private int elements;
    private HashNode<K,V>[] table;

    public HashTable(int capacity){
        this.size = 0;
        this.table = new HashNode[1000];
    }

    @Override
    public boolean insert(K key, V value) {
        if(value == null){
            return false;
        }

        int hash = hashFunction(key);

        HashNode<K,V> newHashNode = new HashNode<>(key,value);

        if(this.table[hash]==null){
            table[hash] = newHashNode;
            this.size++;
            return true;
        }else if(table[hash] != null && table[hash].getNext() == null){
            table[hash].setNext(new HashNode<>(key,value));
            newHashNode.setPrev(table[hash]);
            this.size++;
            return true;
        }else{
            HashNode<K,V> pointer = LastNodeAmpliar(table[hash]);
            pointer.setNext(newHashNode);
            newHashNode.setPrev(pointer);
            this.size++;
            return true;
        }
    }

    private HashNode<K,V> LastNodeAmpliar(HashNode<K,V> pointer){

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