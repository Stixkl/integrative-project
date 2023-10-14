package test;
import exceptions.ListIsNullException;
import model.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class QueueTest {
    private Queue<Integer> queue;

    public void setUp1() {
        queue = new Queue<>();
    }
    public void setUp2() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }
    public void setUp3() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

    @Test
    public void QueueTestInsert() {
        setUp1();
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
    }
    @Test
    public void QueueTestPeek(){
        setUp2();
        assertEquals(1, queue.peek());
    }
    @Test
    public void QueueTestDequeue(){
        setUp2();
        try {
            assertEquals(1, queue.dequeue());
            assertEquals(2, queue.dequeue());
            assertEquals(3, queue.dequeue());
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void QueueTestSize(){
        setUp2();
        assertEquals(3, queue.size());
        try {
            queue.dequeue();
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, queue.size());
        try {
            queue.dequeue();
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(1, queue.size());
        try {
            queue.dequeue();
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0, queue.size());
    }
    @Test
    public void QueueTestIsEmpty(){
        setUp1();
        assertEquals(true, queue.isEmpty());
        setUp2();
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void QueueTestSearch() {
        setUp3();
        assertEquals(true, queue.verify(1));
        assertEquals(true, queue.verify(2));
        assertEquals(true, queue.verify(3));
        assertEquals(true, queue.verify(4));
        assertEquals(false, queue.verify(5));
    }
}
