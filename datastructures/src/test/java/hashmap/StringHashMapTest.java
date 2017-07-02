package hashmap;

import hashmap.StringHashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 2/07/2017.
 */
public class StringHashMapTest {

    private StringHashMap hashMap;
    private final int NUM_ELEMENTS = 1000000;
    private final int INIT_SIZE = NUM_ELEMENTS * 2;

    @Before
    public void setUp() throws Exception {
        hashMap = new StringHashMap(INIT_SIZE);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    @Test
    public void isEmpty() throws Exception {
        // test empty hashMap, expecting isEmpty to return true
        assertTrue(hashMap.isEmpty());
        // test hashMap after adding one entry, expecting isEmpty to return false
        hashMap.put("test", "notEmpty");
        assertFalse(hashMap.isEmpty());
    }

    @Test
    public void size() throws Exception {
        // test initial entry
        hashMap.put("one", "test");
        assertEquals(1, hashMap.size());
        // test replacing same key
        hashMap.put("one", "one");
        assertEquals(1, hashMap.size());
        // test adding new key
        hashMap.put("two", "two");
        assertEquals(2, hashMap.size());
        // test removing existing key
        hashMap.remove("one");
        assertEquals(1, hashMap.size());
        // test removing non existent key
        hashMap.remove("one");
        assertEquals(1, hashMap.size());
    }

    @Test
    public void hash() throws Exception {
        String key = "test";
        int index = Math.abs(key.hashCode() % INIT_SIZE);
        assertEquals(index, hashMap.hash(key));
    }

    @Test
    public void get() throws Exception {
        String key = "key";
        String value = "value";
        hashMap.put(key, value);
        // test getting correct value
        assertEquals(hashMap.get(key), value);
        // test null when key doesn't exist
        assertNull(hashMap.get("doesntexist"));
    }

    @Test
    public void remove() throws Exception {
        hashMap.put("remove", "this");
        hashMap.remove("remove");
        assertNull(hashMap.get("remove"));
    }

    @Test
    public void put() throws Exception {
        String key = "put";
        String value = "this";
        hashMap.put(key, value);
        assertTrue(hashMap.get(key).equals(value));
    }

    @Test
    public void integration() throws Exception {
        for(int i = 0; i < 10000; i++) {
            hashMap.put(Integer.toString(i), Integer.toString(i));
        }
        for(int i = 0; i < 10000; i++) {
            String value = hashMap.get(Integer.toString(i));
            assertEquals(Integer.toString(i), value);
        }
    }

    @Test
    public void putAll() throws Exception {
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void keySet() throws Exception {
    }
}