package test;
import model.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

    public void setUp1(){
        hashTable = new HashTable<>(1000);
    }


    @Test
    public void testInsert(){
        // SetUp test
        setUp1();

        // Act
        boolean flag = hashTable.insert(null, null);

        // assert
        assertEquals(false,flag);
    }
}

