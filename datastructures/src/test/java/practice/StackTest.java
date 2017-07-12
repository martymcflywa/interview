package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 12/7/17.
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
        // test when stack empty, return true
        assertTrue(stack.isEmpty());

        // test when stack not empty, return false
        String notEmpty = "somethingHere";
        stack.push(notEmpty);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        // test when stack empty, return null
        assertNull(stack.peek());

        // test when stack not empty, return top of the stack
        String pk1 = "peekFirst";
        String pk2 = "peekSecond";
        String pk3 = "peekThird";

        stack.push(pk1);
        assertEquals(pk1, stack.peek());
        stack.push(pk2);
        assertEquals(pk2, stack.peek());
        stack.push(pk3);
        assertEquals(pk3, stack.peek());
    }

    @Test
    public void push() throws Exception {
        // test each push with peek
        String pu1 = "pushFirst";
        String pu2 = "pushSecond";
        String pu3 = "pushThird";

        stack.push(pu1);
        assertEquals(pu1, stack.peek());
        stack.push(pu2);
        assertEquals(pu2, stack.peek());
        stack.push(pu3);
        assertEquals(pu3, stack.peek());
    }

    @Test
    public void pop() throws Exception {
        // test when stack empty, return null
        assertNull(stack.pop());

        // test when stack not empty, return top before popping
        String po1 = "popFirst";
        String po2 = "popSecond";
        String po3 = "popThird";

        stack.push(po1);
        stack.push(po2);
        stack.push(po3);

        assertEquals(po3, stack.pop());
        assertEquals(po2, stack.pop());
        assertEquals(po1, stack.pop());
        assertTrue(stack.isEmpty());
    }

}