package test;
import exceptions.IndexOutOfBoundsException;
import exceptions.ListIsNullException;
import model.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    private Heap heap;

    public void setUp1() {
        heap = new Heap();
    }

    public void setUp2() {
        heap = new Heap();
        heap.insert(1,"Tarea1");
        heap.insert(2,"Tarea2");
    }
    public void setUp3(){
        heap= new Heap<>();
        heap.insert(-120, 40);
        heap.insert(-4, 30);

    }
     @Test
     public void HeapTestInsert() {
        setUp1();
        boolean result = heap.insert(1, null);
        assertEquals(false, result);
     }
    @Test
    public void HeapTestInsert2() {
        setUp1();
        boolean result = heap.insert(1, "Hola");
        assertEquals(true, result);
    }
    @Test
    public void HeapTestRemove() {
        setUp2();
        boolean result = heap.remove("Tarea1");
        assertEquals(true, result);
    }
    @Test
    public void HeapTestRemove2() {
        setUp2();
        boolean result = heap.remove("Tarea3");
        assertEquals(false, result);
    }
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
