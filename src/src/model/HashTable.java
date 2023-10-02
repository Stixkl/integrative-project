package model;

public class HashTable<K,V> implements IHashTable<K,V>{

    private int size;
    private int elements;
    private HashNode<K,V>[] table;

    public HashTable(int capacity){
        this.size = 0;
        this.table = new HashNode[999];
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
            HashNode<K,V> pointer = LastNodeExtend(table[hash]);
            pointer.setNext(newHashNode);
            newHashNode.setPrev(pointer);
            this.size++;
            return true;
        }
    }

    private HashNode<K,V> LastNodeExtend(HashNode<K,V> pointer){
        if(pointer.getNext() == null){
            return pointer;
        }else{
            return LastNodeExtend(pointer.getNext());
        }
    }

    @Override
    public V search(K key) {

        int position = this.hashFunction(key);

        HashNode<K,V> pointer = table[position];
        boolean flag = true;
        if (pointer != null) {
            while(flag){
                if(pointer.getKey().equals(key)){
                    flag = false;
                }
                if(flag){
                    pointer = pointer.getNext();
                    if(pointer == null){
                        flag = false;
                    }
                }
            }
        }
        if (pointer == null) {
            return null;
        } else {
            return pointer.getValue();
        }
    }

    public HashNode searchNode(K key) {

        int position = this.hashFunction(key);

        HashNode<K,V> pointer = table[position];
        boolean flag = true;
        if (pointer != null) {
            while(flag){
                if(pointer.getKey().equals(key)){
                    flag = false;
                }

                if(flag){
                    pointer = pointer.getNext();
                    if(pointer == null){
                        flag = false;
                    }
                }
            }
        }
        return pointer;
    }

    @Override
    public boolean delete(K key) {
        int position = this.hashFunction(key);

        HashNode<K,V> pointer = searchNode(key);

        if(pointer != null){
            if(pointer == table[position]){
                table[position] = pointer.getNext();
            }else{
                HashNode<K,V> toReplace = pointer.getPrev();
                pointer.getNext().setPrev(toReplace);
                toReplace.setNext(pointer.getNext());
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int hashFunction(K key) {
        return key.hashCode() % 999;
    }
}