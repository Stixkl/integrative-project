package model;

public interface IHashTable<K,V> {

    boolean insert(K key, V value);
     V search(K key);
     void delete(K key);
     int hashFunction(K key);
}
