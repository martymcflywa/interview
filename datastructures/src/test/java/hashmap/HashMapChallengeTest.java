package hashmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 2/07/2017.
 */
public class HashMapChallengeTest {

    private HashMapChallenge hashMap;
    private static final int ENTRIES = 100;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMapChallenge(ENTRIES);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    /**
     * Add item to dictionary. Return the previous value if exists and replace it, else add a new entry and return null.
     */
    @Test
    public void put() {
        // test when not exists
        String key1 = "putkey1";
        String value1 = "putvalue1";
        assertNull(hashMap.put(key1, value1));

        // test when exists
        String value2 = "putvalue2";
        // test the return value
        assertEquals(value1, hashMap.put(key1, value2));
        // test the put function
        assertEquals(value2, hashMap.get(key1));
    }

    /**
     * Return value of entry if exists, else return null.
     */
    @Test
    public void get() {
        // test when not exists
        String key1 = "getkey1";
        assertNull(hashMap.get(key1));

        // test when exist
        String key2 = "getkey2";
        String value2 = "getvalue2";
        hashMap.put(key2, value2);
        // test the return value
        assertEquals(value2, hashMap.get(key2));
    }

    /**
     * Remove entry from hashmap if exists and return value, else return null.
     */
    @Test
    public void remove() {
        // test when not exists
        String key1 = "removekey1";
        assertNull(hashMap.get(key1));

        // test when exists
        String key2 = "removekey2";
        String value2 = "removevalue2";
        hashMap.put(key2, value2);
        // test the return value
        assertEquals(value2, hashMap.remove(key2));
        // test the remove function
        assertNull(hashMap.get(key2));
    }
}