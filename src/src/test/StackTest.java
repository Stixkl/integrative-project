package test;
import exceptions.ListIsNullException;
import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class StackTest {

    private Stack<Object, Actions> stack;

    public void setUp1() {
        stack = new Stack<>();
    }

    public void setUp2() {
        stack = new Stack<>();
        Task task = new Task(10, "1", "1", new Date(1,2,3), 1);
        Task task2 = new Task(9, "2", "epa",new Date(1,2,4), 2);
        Task task3 = new Task(8, "3", "sisa",new Date(1,2,5), 3);
        stack.push(new Actions(EnumAction.ADD, task));
        stack.push(new Actions(EnumAction.REMOVE, task2));
        stack.push(new Actions(EnumAction.ADD, task3));
    }

    @Test
    public void StackTestPush() {
        setUp1();
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
    }

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

    @Test
    public void StackTestTop(){
        setUp2();
        assertEquals(EnumAction.ADD, stack.Top().getAction());
    }

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
