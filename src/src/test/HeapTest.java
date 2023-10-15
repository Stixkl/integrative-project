package test;
import exceptions.IndexOutOfBoundsException;
import exceptions.ListIsNullException;
import model.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    private Heap heap;

/**
 * The setUp1 function initializes a new instance of the Heap class.
 */
    public void setUp1() {
        heap = new Heap();
    }

/**
 * The setUp2 function creates a new heap and inserts two tasks into it.
 */
    public void setUp2() {
        heap = new Heap();
        heap.insert(1,"Task1");
        heap.insert(2,"Task2");
    }

/**
 * The setUp3 function initializes a heap data structure and inserts two elements into it.
 */
    public void setUp3(){
        heap= new Heap<>();
        heap.insert(-120, 40);
        heap.insert(-4, 30);

    }
/**
 * The HeapTestInsert function tests the insert method of the heap class.
 */

     @Test
     public void HeapTestInsert() {
        setUp1();
        boolean result = heap.insert(1, null);
        assertEquals(false, result);
     }
/**
 * The function tests the insert method of a heap data structure by inserting a key-value pair and
 * checking if the insertion was successful.
 */
    @Test
    public void HeapTestInsert2() {
        setUp1();
        boolean result = heap.insert(1, "Task1");
        assertEquals(true, result);
    }
/**
 * The function tests the remove method of a heap data structure in Java.
 */
    @Test
    public void HeapTestRemove() {
        setUp2();
        boolean result = heap.remove("Task1");
        assertEquals(true, result);
    }
/**
 * The function tests the remove method of a heap data structure by attempting to remove an element
 * that does not exist in the heap.
 */
    @Test
    public void HeapTestRemove2() {
        setUp2();
        boolean result = heap.remove("Task3");
        assertEquals(false, result);
    }
/**
 * The function tests the heapSort method by asserting that the first element of the heap is not equal
 * to the result of extracting the maximum element.
 */
    @Test
    public void HeapTestSort() throws ListIsNullException {
        try {
            setUp2();
            heap.heapSort();
            assertNotEquals(heap.get(1), heap.extractMax());
        } catch (ListIsNullException e) {
            throw new ListIsNullException("The list is null");
        }
    }
/**
 * The function tests the heapSort method by setting up a heap, sorting it, extracting the maximum
 * element, and checking if the heap is not empty.
 */
    @Test
    public void HeapTestSort2() throws ListIsNullException {
        try {
            setUp2();
            heap.heapSort();
            heap.extractMax();
            assertFalse(heap.isEmpty());
        } catch (ListIsNullException e) {
            throw new ListIsNullException("The list is null");
        }
    }
}
