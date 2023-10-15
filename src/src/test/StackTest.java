package test;
import exceptions.ListIsNullException;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class StackTest {

    private Stack<Object, Actions> stack;

   /**
    * The setUp1 function initializes a new stack.
    */
    public void setUp1() {
        stack = new Stack<>();
    }

/**
 * The setUp2 function initializes a stack and adds three Actions objects to it, each representing an
 * action on a Task object.
 */
    public void setUp2() {
        stack = new Stack<>();
        Task task = new Task(10, "1", "1", new Date(1,2,3), 1);
        Task task2 = new Task(9, "2", "epa",new Date(1,2,4), 2);
        Task task3 = new Task(8, "3", "sisa",new Date(1,2,5), 3);
        stack.push(new Actions(EnumAction.ADD, task));
        stack.push(new Actions(EnumAction.REMOVE, task2));
        stack.push(new Actions(EnumAction.ADD, task3));
    }

/**
 * The StackTestPush function tests the push operation on a stack and checks if the stack is empty and
 * has a size of 0 before pushing any elements.
 */
    @Test
    public void StackTestPush() {
        setUp1();
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }
/**
 * The StackTestPop function tests the pop method of a stack by asserting the expected actions and
 * checking the size and emptiness of the stack.
 */

    @Test
    public void StackTestPop() throws ListIsNullException {
        setUp2();
        try {
            assertEquals(EnumAction.ADD, stack.pop().getAction());
            assertEquals(EnumAction.REMOVE, stack.pop().getAction());
            assertEquals(EnumAction.ADD, stack.pop().getAction());
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }

/**
 * The function StackTestTop tests the Top() method of a stack object.
 */
    @Test
    public void StackTestTop(){
        setUp2();
        assertEquals(EnumAction.ADD, stack.Top().getAction());
    }

/**
 * The function tests the size of a stack and verifies that it decreases by 1 after a pop operation.
 */
    @Test
    public void StackTestSize(){
        setUp2();
        assertEquals(3, stack.size());
        try {
            stack.pop();
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, stack.size());
    }
}
