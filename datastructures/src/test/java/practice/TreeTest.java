package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 12/7/17.
 */
public class TreeTest {

    private Tree tree;
    private static String[] sample = {"c", "a", "f", "g", "d", "b", "e"};
    private static String MIN = sample[1];
    private static String MAX = sample[3];

    @Before
    public void setUp() throws Exception {
        tree = new Tree();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
        System.gc();
    }

    @Test
    public void insert() throws Exception {
        assertTrue(tree.isEmpty());
        for(String s : sample) {
            tree.insert(s);
        }
        assertFalse(tree.isEmpty());
        assertEquals(MIN, tree.findMin());
        assertEquals(MAX, tree.findMax());
    }

    @Test
    public void find() throws Exception {
        for(String s : sample) {
            tree.insert(s);
        }
        for(String s : sample) {
            assertEquals(s, tree.find(s));
        }
    }

    @Test
    public void remove() throws Exception {
        for(String s : sample) {
            tree.insert(s);
        }
        assertFalse(tree.isEmpty());
        for(String s : sample) {
            tree.remove(s);
        }
        assertTrue(tree.isEmpty());
    }
}