package hashmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 2/07/2017.
 */
public class HashMapTest {

    private HashMap hashMap;
    private int entries;
    private int initSize;

    @Before
    public void setUp() throws Exception {
        entries = 15;
        initSize = entries * 2;
        hashMap = new HashMap(initSize);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    @Test
    public void put() throws Exception {
        System.out.println("\nTesting put()");
        for(int i = 0; i < entries; i++) {
            String key = "key-" + Integer.toString(i);
            String value = "val-" + Integer.toString(i);
            hashMap.put(key, value);
        }
        assertEquals(hashMap.size(), entries);

        // test put on existing entry
        String key = "key-7";
        String value = "val-REPLACED";
        hashMap.put(key, value);
        assertEquals(hashMap.get(key), value);
    }

    @Test
    public void get() throws Exception {
        System.out.println("\nTesting get()");
        for(int i = 0; i < entries; i++) {
            String key = "key-" + Integer.toString(i);
            String value = "val-" + Integer.toString(i);
            hashMap.put(key, value);
        }
        String actualValue = hashMap.get("key-7");
        assertEquals(actualValue, "val-7");
    }

    @Test
    public void remove() throws Exception {
        System.out.println("\nTesting remove()");
        for(int i = 0; i < entries; i++) {
            String key = "key-" + Integer.toString(i);
            String value = "val-" + Integer.toString(i);
            hashMap.put(key, value);
        }
        String key = "key-7";
        hashMap.remove(key);
        assertNull(hashMap.get(key));

        // test remove on non-existent entry
        assertNull(hashMap.remove(key));
    }
}