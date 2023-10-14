package model;

public interface IHashTable<K,V> {

/**
 * The insert function inserts a key-value pair into a data structure.
 * 
 * @param key The key parameter represents the key of the element that you want to insert into a data
 * structure. The key is used to uniquely identify the element in the data structure.
 * @param value The value to be inserted into the data structure.
 * @return The method is returning a boolean value.
 */
    boolean insert(K key, V value);

/**
 * The function "search" takes a key of type K and returns a value of type V.
 * 
 * @param key The key parameter is the value that you want to search for in the data structure.
 * @return a value of type V, which is the value associated with the key in the search operation.
 */
     V search(K key);
/**
 * The delete function takes a key as input and returns a boolean value indicating whether the key was
 * successfully deleted from the data structure.
 * 
 * @param key The key parameter represents the key of the element that you want to delete from a data
 * structure. The data structure could be a map, set, or any other data structure that supports
 * deletion of elements based on a key. The method should return a boolean value indicating whether the
 * deletion was successful or not.
 * @return The method is returning a boolean value.
 */

     boolean delete(K key);
/**
 * The hashFunction takes a key as input and returns an integer value.
 * 
 * @param key The key parameter is the input value that will be used to calculate the hash value.
 * @return The hashFunction is returning an integer value.
 */

     int hashFunction(K key);
}
