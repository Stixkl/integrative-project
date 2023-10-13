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

    public void setUp2(){
        hashTable = new HashTable<>(5);

        hashTable.insert(1,"Tarea1");
        hashTable.insert(2,"Tarea2");
        hashTable.insert(3,"Tarea3");
        hashTable.insert(4,"Tarea4");
        hashTable.insert(5,"Tarea5");
    }

    public void setUp3(){
        hashTable = new HashTable<>(1);

        hashTable.insert(1,"Tarea1");
        hashTable.insert(2,"Tarea2");
    }

    @Test
    public void HashTestInsert(){
        setUp1();
        boolean flag = hashTable.insert(null, null);
        assertEquals(false,flag);
    }

    @Test
    public void HashTestInsert2(){
        setUp1();
        boolean flag = hashTable.insert(1, "Hola");
        assertEquals(true,flag);
    }

    @Test
    public void HashTestInsert3(){
        setUp1();
        boolean flag = hashTable.insert(1, null);
        assertEquals(false,flag);
    }

    @Test
    public void HashTestInsert4(){
        setUp1();
        boolean flag = hashTable.insert(1, "Hola");
        boolean flag2 = hashTable.insert(1, "Hola");
        assertEquals(true,flag);
        assertEquals(true,flag2);
    }
    @Test
    public void HashTestSearch(){
        setUp2();
        String result = hashTable.search(1);
        assertEquals("Tarea1",result);
    }
    @Test
    public void HashTestSearch2(){
        setUp2();
        String result = hashTable.search(6);
        assertEquals(null,result);
    }
    @Test
    public void HashDelete(){
        setUp2();
        boolean flag = hashTable.delete(1);
        assertEquals(true,flag);
    }
    @Test
    public void HashDelete2(){
        setUp2();
        boolean flag = hashTable.delete(6);
        assertEquals(false,flag);
    }
}



