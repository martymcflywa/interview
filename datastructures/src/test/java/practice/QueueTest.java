package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 12/7/17.
 */
public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue();
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
        System.gc();
    }

    @Test
    public void isEmpty() throws Exception {
        // test when queue is empty
        assertTrue(queue.isEmpty());

        // test when queue has elements
        queue.add("isEmpty");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void add() throws Exception {
        // test calling add, call peek to verify
        String add1 = "addMe";
        queue.add(add1);
        assertEquals(add1, queue.peek());
    }

    @Test
    public void peek() throws Exception {
        // test when queue is empty
        assertNull(queue.peek());
        // test when queue is not empty
        String peek1 = "always found";
        String peek2 = "not this";
        String peek3 = "not this either";
        queue.add(peek1);
        assertEquals(peek1, queue.peek());
        queue.add(peek2);
        assertEquals(peek1, queue.peek());
        queue.add(peek3);
        assertEquals(peek1, queue.peek());
    }

    @Test
    public void remove() throws Exception {
        // test when queue is empty
        assertNull(queue.remove());

        // test when queue is not empty
        String rem1 = "removeFirst";
        String rem2 = "removeSecond";
        String rem3 = "removeThird";
        queue.add(rem1);
        queue.add(rem2);
        queue.add(rem3);
        
        assertEquals(rem1, queue.remove());
        assertEquals(rem2, queue.peek());
        assertEquals(rem2, queue.remove());
        assertEquals(rem3, queue.peek());
        assertEquals(rem3, queue.remove());
        assertNull(queue.peek());
        assertTrue(queue.isEmpty());
    }
}