package queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by poncem on 10/7/17.
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
        // test when queue is empty, returns true
        assertTrue(queue.isEmpty());

        // test when queue is not empty, returns false
        queue.add("notEmpty");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        // test when queue is empty, return null
        assertNull(queue.peek());

        // test when queue is not empty, return head.data
        String peek1 = "peekFirst";
        String peek2 = "peekSecond";
        String peek3 = "peekThird";
        queue.add(peek1);
        assertEquals(peek1, queue.peek());
        queue.add(peek2);
        assertEquals(peek1, queue.peek());
        queue.add(peek3);
        assertEquals(peek1, queue.peek());
    }

    @Test
    public void remove() throws Exception {
        // test when queue is empty, throw NoSuchElementException
        assertNull(queue.remove());

        // test when queue is not empty, return data being removed
        String remove1 = "removeFirst";
        String remove2 = "removeSecond";
        String remove3 = "removeThird";
        queue.add(remove1);
        queue.add(remove2);
        queue.add(remove3);

        assertEquals(remove1, queue.peek());
        assertEquals(remove1, queue.remove());
        assertEquals(remove2, queue.peek());
        assertEquals(remove2, queue.remove());
        assertEquals(remove3, queue.peek());
        assertEquals(remove3, queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void add() throws Exception {
        // test by peeking
        String add1 = "addFirst";
        String add2 = "addSecond";
        String add3 = "addThird";

        queue.add(add1);
        assertEquals(add1, queue.peek());
        queue.add(add2);
        assertEquals(add1, queue.remove());
        assertEquals(add2, queue.peek());
        queue.add(add3);
        assertEquals(add2, queue.remove());
        assertEquals(add3, queue.peek());
    }
}