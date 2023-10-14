package test;
import exceptions.ListIsNullException;
import model.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class QueueTest {
    private Queue<Integer> queue;

   /**
    * The function sets up a new instance of a queue.
    */
    public void setUp1() {
        queue = new Queue<>();
    }
/**
 * The setUp2 function initializes a queue and enqueues three elements into it.
 */
    public void setUp2() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }
/**
 * The function sets up a queue and enqueues four elements into it.
 */
    public void setUp3() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

/**
 * The QueueTestInsert function tests if the queue is initially empty and has a size of 0.
 */
    @Test
    public void QueueTestInsert() {
        setUp1();
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
    }
/**
 * The function tests the peek method of a queue and asserts that the expected value is returned.
 */
    @Test
    public void QueueTestPeek(){
        setUp2();
        assertEquals(1, queue.peek());
    }
/**
 * The function tests the dequeue operation of a queue and checks if the size and empty status of the
 * queue are updated correctly.
 */
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

    /**
     * The function tests the size of a queue and asserts that it decreases by 1 each time an element
     * is dequeued.
     */
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
    /**
     * The function tests whether a queue is empty or not.
     */
    @Test
    public void QueueTestIsEmpty(){
        setUp1();
        assertEquals(true, queue.isEmpty());
        setUp2();
        assertEquals(false, queue.isEmpty());
    }

    /**
     * The QueueTestSearch function tests the verify method of a queue to check if certain elements are
     * present in the queue.
     */
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
