package test;
import exceptions.ListIsNullException;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class StackTest {

    private Stack<Object, Actions> undoStack;

   /**
    * The setUp1 function initializes a new stack.
    */
    public void setUp1() {
        undoStack = new Stack<>();
    }

/**
 * The setUp2 function initializes a stack and adds three Actions objects to it, each representing an
 * action on a Task object.
 */
    public void setUp2() {
        undoStack = new Stack<Object, Actions>();
        Task task = new Task(10, "1", "Description1", new Date(1,2,3), 1);
        Task task2 = new Task(9, "2", "Description2",new Date(1,2,4), 2);
        Task task3 = new Task(8, "3", "Description3",new Date(1,2,5), 3);
        undoStack.push(new Actions(EnumAction.ADD, task));
        undoStack.push(new Actions(EnumAction.REMOVE, task2));
        undoStack.push(new Actions(EnumAction.ADD, task3));
    }

/**
 * The StackTestPush function tests the push operation on a stack and checks if the stack is empty and
 * has a size of 0 before pushing any elements.
 */
    @Test
    public void StackTestPush() {
        setUp1();
        assertEquals(0, undoStack.size());
        assertEquals(true, undoStack.isEmpty());
    }
/**
 * The StackTestPop function tests the pop method of a stack by asserting the expected actions and
 * checking the size and emptiness of the stack.
 */

    @Test
    public void StackTestPop() throws ListIsNullException {
        setUp2();
        assertEquals(3, undoStack.size());
        try {
            assertEquals(EnumAction.ADD, undoStack.pop().getAction());

        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, undoStack.size());
    }

/**
 * The function StackTestTop tests the Top() method of a stack object.
 */
    public void StackTestTop(){
        setUp2();
        assertEquals(EnumAction.ADD, undoStack.Top().getAction());
    }
/**
 * The function tests the size of a stack and verifies that it decreases by 1 after a pop operation.
 */
    @Test
    public void StackTestSize(){
        setUp2();
        assertEquals(3, undoStack.size());
        try {
            undoStack.pop();
        } catch (ListIsNullException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, undoStack.size());
    }
}
