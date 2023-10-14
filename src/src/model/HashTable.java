package model;

public class HashTable<K,V> implements IHashTable<K,V>{

    private int size;

    private final HashNode[] table;

// The `HashTable` constructor is initializing a new instance of the `HashTable` class. It takes an
// integer parameter `capacity` which represents the initial capacity of the hash table.
    public HashTable(int capacity){
        this.size = 0;
        this.table = new HashNode[capacity];
    }

/**
 * The toString() function iterates through an array and appends the string representation of each
 * non-null element to a message.
 * 
 * @return The method is returning a string representation of the values stored in the "table" array.
 */
    public String toString() {
        String msg = "";
        for(int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                msg += table[i].getValue().toString() + "\n";
            }
        }
        return msg;
    }

   /**
    * The insert function inserts a key-value pair into a hash table, handling collisions by chaining.
    * 
    * @param key The key is the unique identifier for the value being inserted into the hash table. It
    * is used to determine the index at which the value will be stored in the table.
    * @param value The value parameter represents the value that you want to insert into the hash
    * table.
    * @return The method is returning a boolean value.
    */
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

 /**
  * The function recursively finds and returns the last node in a linked list.
  * 
  * @param pointer A reference to a HashNode object.
  * @return The method is returning the last node in a linked list.
  */
    private HashNode<K,V> LastNodeExtend(HashNode<K,V> pointer){
        if(pointer.getNext() == null){
            return pointer;
        }else{
            return LastNodeExtend(pointer.getNext());
        }
    }
    
    /**
     * This function searches for a value associated with a given key in a hash table.
     * 
     * @param key The key parameter is the key of the element that we want to search for in the data
     * structure.
     * @return The method is returning the value associated with the given key in the hash table. If
     * the key is not found or the value associated with the key is null, then it returns null.
     */
    @Override
    public V search(K key) {
        V pointer = null;
        int position = hashFunction(key);
        if (searchNode(key) != null) {
            if (searchNode(key).getValue() != null) {
                pointer = searchNode(key).getValue();
            } else {
                pointer = null;
            }
            if (pointer != null) {
                return pointer;
            }
        }
        return null;
    }

    /**
     * The searchNode function searches for a specific key in a hash table and returns the
     * corresponding node if found, or null if not found.
     * 
     * @param key The key parameter is the key of the node that we are searching for in the hash table.
     * @return The method is returning a HashNode object with the specified key.
     */
    public HashNode<K,V> searchNode(K key) {
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
            return pointer;
        }
    }

   /**
    * The delete function removes a key-value pair from a hash table based on the given key.
    * 
    * @param key The key parameter represents the key of the element that needs to be deleted from the
    * hash table.
    * @return The method is returning a boolean value. It returns true if the deletion was successful,
    * and false if the key was not found in the hash table.
    */
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

  /**
   * The getSize() function returns the size of an object.
   * 
   * @return The method is returning the value of the variable "size".
   */
    public int getSize() {
        return size;
    }
/**
 * The hashFunction method takes a key and returns the index of the corresponding bucket in a hash
 * table.
 * 
 * @param key The key parameter is the object that we want to hash. It can be of any type, as long as
 * it implements the hashCode() method.
 * @return The method is returning the result of the modulo operation, which is the remainder of
 * dividing the hash code of the key by the length of the table.
 */
    @Override
    public int hashFunction(K key) {
        return Math.abs(key.hashCode() % table.length);
    }







}