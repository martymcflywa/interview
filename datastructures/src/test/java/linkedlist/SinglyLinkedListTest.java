package linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 17/7/17.
 */
public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @Before
    public void setUp() throws Exception {
        list = new SinglyLinkedList();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
        System.gc();
    }

    @Test
    public void isEmpty() throws Exception {
        // test when list empty
        assertTrue(list.isEmpty());

        // test when list not empty
        list.insertFirst("a");
        assertFalse(list.isEmpty());
    }

    @Test
    public void insertFirst() throws Exception {
        // test when list empty
        String actualFirst = "a";
        String expectedFirst = "a ";
        list.insertFirst(actualFirst);
        assertEquals(expectedFirst, list.toString());

        // test when list not empty
        String actualSecond = "b";
        String expectedSecond = "b a ";
        list.insertFirst(actualSecond);
        assertEquals(expectedSecond, list.toString());
    }

    @Test
    public void insertLast() throws Exception {
        // test when list empty
        String actualFirst = "b";
        String expectedFirst = "b ";
        list.insertLast(actualFirst);
        assertEquals(expectedFirst, list.toString());

        // test when list not empty
        String actualSecond = "a";
        String expectedSecond = "b a ";
        list.insertLast(actualSecond);
        assertEquals(expectedSecond, list.toString());
    }

    @Test
    public void insertOrdered() throws Exception {
        String[] expected = {"a", "b", "c", "d"};
        String expectedString = "a b c d ";
        String[] actual = {"c", "a", "b", "d"};

        for(String s : actual) {
            list.insertOrdered(s);
        }

        assertEquals(expected.length, list.size());
        assertEquals(expectedString, list.toString());
    }

    @Test
    public void removeFirstOf() throws Exception {
        String expected = "a c b ";
        String[] actual = {"a", "b", "c", "b"};
        String removeFirst = "b";
        String removeSecond = "z";

        for(String s : actual) {
            list.insertLast(s);
        }

        list.remove(removeFirst);
        assertEquals(expected, list.toString());
        list.remove(removeSecond);
        assertEquals(expected, list.toString());
    }
}