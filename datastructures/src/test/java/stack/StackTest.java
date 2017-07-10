package stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 10/7/17.
 */
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
        System.gc();
    }

    @Test
    public void isEmpty() throws Exception {
        // test when stack is empty, return true
        assertTrue(stack.isEmpty());

        // test when stack is not empty, return false
        String notEmpty = "notEmpty";
        stack.push(notEmpty);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        // test when stack is empty, return null
        assertNull(stack.peek());

        // test when stack is not empty, return top of the stack
        String peek1 = "peekFirst";
        String peek2 = "peekSecond";
        String peek3 = "peekThird";
        stack.push(peek1);
        assertEquals(peek1, stack.peek());
        stack.push(peek2);
        assertEquals(peek2, stack.peek());
        stack.push(peek3);
        assertEquals(peek3, stack.peek());
    }

    @Test
    public void push() throws Exception {
        // test with peek
        String push1 = "pushFirst";
        String push2 = "pushSecond";
        String push3 = "pushThird";
        stack.push(push1);
        assertEquals(push1, stack.peek());
        stack.push(push2);
        assertEquals(push2, stack.peek());
        stack.push(push3);
        assertEquals(push3, stack.peek());
    }

    @Test
    public void pop() throws Exception {
        // test when stack is empty, return null
        assertNull(stack.pop());

        // test when stack is not empty, return top of the stack before popping it
        String pop1 = "popFirst";
        String pop2 = "popSecond";
        String pop3 = "popThird";
        stack.push(pop1);
        stack.push(pop2);
        stack.push(pop3);
        assertEquals(pop3, stack.pop());
        assertEquals(pop2, stack.pop());
        assertEquals(pop1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}