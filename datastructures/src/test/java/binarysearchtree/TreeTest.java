package binarysearchtree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 3/07/2017.
 */
public class TreeTest {

    private Tree tree;
    private static int[] sample = getRandomData(10);

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
    public void put() throws Exception {
        int expected = 106;
        tree.put(expected);
        assertEquals(expected, tree.get(expected).data());
    }

    @Test
    public void get() throws Exception {
        for(int i : sample) {
            tree.put(i);
        }
        for(int i : sample) {
            assertEquals(i, tree.get(i).data());
        }
    }

    @Test
    public void preOrder() throws Exception {
        for(int i : sample) {
            tree.put(i);
        }
        System.out.println(tree.preOrder() + "\n");
    }

    @Test
    public void inOrder() throws Exception {
        for(int i : sample) {
            tree.put(i);
        }
        System.out.println(tree.inOrder() + "\n");
    }

    @Test
    public void postOrder() throws Exception {
        for(int i : sample) {
            tree.put(i);
        }
        System.out.println(tree.postOrder() + "\n");
    }

    private static int[] getRandomData(int size) {
        int[] sample = new int[size];
        for(int i = 0; i < sample.length; i++) {
            sample[i] = (int) (Math.random() * 100);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("INPUT:\n");
        for(int i : sample) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString() + "\n");
        return sample;
    }
}