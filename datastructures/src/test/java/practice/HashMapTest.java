package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 4/07/2017.
 */
public class HashMapTest {

    private HashMap hashMap;
    private static final int INIT_SIZE = 128;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap(INIT_SIZE);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    @Test
    public void put() throws Exception {
        // test when key doesn't exist, return null
        String key = "putkey";
        String val1 = "putval1";
        assertNull(hashMap.put(key, val1));

        // test when key does exist, return previous value
        String val2 = "putval2";
        assertEquals(val1, hashMap.put(key, val2));
        assertEquals(val2, hashMap.get(key));
    }

    @Test
    public void get() throws Exception {
        // test when key doesn't exist, return null
        String key = "getkey";
        String val = "getval";
        assertNull(hashMap.get(key));

        // test when key exists, return value
        hashMap.put(key, val);
        assertEquals(val, hashMap.get(key));
    }

    @Test
    public void remove() throws Exception {
        // test when key doesn't exist, return null
        String key = "removekey";
        String val = "removeval";
        assertNull(hashMap.remove(key));

        // test when key exists, return value before removing
        hashMap.put(key, val);
        assertEquals(val, hashMap.remove(key));
        assertNull(hashMap.get(key));
    }
}