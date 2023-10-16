import model.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

/**
 * The function sets up a new HashTable object with a capacity of 1000.
 */
    public void setUp1(){
        hashTable = new HashTable<>(1000);
    }

/**
 * The function sets up a hash table with a size of 5 and inserts 5 tasks into it.
 */
    public void setUp2(){
        hashTable = new HashTable<>(5);

        hashTable.insert(1,"Task1");
        hashTable.insert(2,"Task2");
        hashTable.insert(3,"Task3");
        hashTable.insert(4,"Task4");
        hashTable.insert(5,"Task5");
    }

/**
 * The setUp3 function initializes a hash table with a capacity of 2 and inserts two key-value pairs
 * into it.
 */
    public void setUp3(){
        hashTable = new HashTable<>(2);

        hashTable.insert(1,"Task1");
        hashTable.insert(2,"Task2");
    }

/**
 * The function HashTestInsert tests the insert method of a hash table by attempting to insert a null
 * key-value pair.
 */
    @Test
    public void HashTestInsert(){
        setUp1();
        boolean flag = hashTable.insert(null, null);
        assertEquals(false,flag);
    }

/**
 * The function tests the insert method of a hash table by inserting a key-value pair and checking if
 * it returns true.
 */
    @Test
    public void HashTestInsert2(){
        setUp1();
        boolean flag = hashTable.insert(1, "Task");
        assertEquals(true,flag);
    }

/**
 * The function HashTestInsert3 tests the insert method of a hash table by attempting to insert a null
 * value.
 */
    @Test
    public void HashTestInsert3(){
        setUp1();
        boolean flag = hashTable.insert(1, null);
        assertEquals(false,flag);
    }

/**
 * The function tests the insert method of a hash table by inserting the same key-value pair twice and
 * checking if the method returns true both times.
 */
    @Test
    public void HashTestInsert4(){
        setUp1();
        boolean flag = hashTable.insert(1, "Task1");
        boolean flag2 = hashTable.insert(1, "Task2");
        assertEquals(true,flag);
        assertEquals(true,flag2);
    }
/**
 * The HashTestSearch function tests the search method of a hash table by asserting that the result of
 * searching for a key is equal to the expected value.
 */
    @Test
    public void HashTestSearch(){
        setUp2();
        String result = hashTable.search(1);
        assertEquals("Task1",result);
    }
/**
 * The HashTestSearch2 function tests the search method of a hash table by searching for a key that
 * does not exist in the table.
 */
    @Test
    public void HashTestSearch2(){
        setUp2();
        String result = hashTable.search(6);
        assertEquals(null,result);
    }
/**
 * The HashDelete function tests the delete method of a hash table by deleting an element with a
 * specific key and checking if the deletion was successful.
 */
    @Test
    public void HashDelete(){
        setUp2();
        boolean flag = hashTable.delete(1);
        assertEquals(true,flag);
    }
/**
 * The HashDelete2 function tests the delete method of a hash table by attempting to delete a key that
 * does not exist in the table.
 */
    @Test
    public void HashDelete2(){
        setUp2();
        boolean flag = hashTable.delete(6);
        assertEquals(false,flag);
    }
}



