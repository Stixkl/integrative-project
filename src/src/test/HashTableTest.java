package test;
import model.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HashTableTest {

    private HashTable<Integer, String> hashTable;

    public void setUp1(){
        hashTable = new HashTable<>(1000);
    }


    @Test
    public void HashTestInsert(){
        // SetUp test
        setUp1();

        // Act
        boolean flag = hashTable.insert(null, null);

        // assert
        assertEquals(false,flag);
    }

    @Test
    public void HashTestInsert2(){
        // SetUp test
        setUp1();

        // Act
        boolean flag = hashTable.insert(1, "Hola");

        // assert
        assertEquals(true,flag);
    }

    @Test
    public void HashTestInsert3(){
        // SetUp test
        setUp1();

        // Act
        boolean flag = hashTable.insert(1, null);
        // assert
        assertEquals(false,flag);
    }
}

