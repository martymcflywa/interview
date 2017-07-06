package hashmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by marty on 5/07/2017.
 */
public class HashMapTest {

    private HashMap hashMap;
    private int entries;

    @Before
    public void setUp() throws Exception {
        entries = 10;
        hashMap = new HashMap(10);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    @Test
    public void put() {
        // test when key doesn't exist
        String key = "putKey";
        String val1 = "putVal1";
        assertNull(hashMap.put(key, val1));

        // test when key does exist
        String val2 = "putVal2";
        assertEquals(val1, hashMap.put(key, val2));
        assertEquals(val2, hashMap.get(key));
    }

    @Test
    public void get() {
        // test when key doesn't exist
        String key = "getKey";
        String val = "getVal";
        assertNull(hashMap.get(key));

        // test when key does exist
        hashMap.put(key, val);
        assertEquals(val, hashMap.get(key));
    }

    @Test
    public void remove() {
        // test when key doesn't exist
        String key = "removeKey";
        String val = "removeVal";
        assertNull(hashMap.remove(key));

        // test when key does exist
        hashMap.put(key, val);
        assertEquals(val, hashMap.remove(key));
        assertNull(hashMap.get(key));
    }

    @Test
    public void largeSample() throws Exception {
        int sampleSize = 100;
        Random rng = new Random();
        String[] samples = new String[sampleSize];

        hashMap = new HashMap(sampleSize);

        for(int i = 0; i < sampleSize; i++) {
            char[] chars = new char[4];
            for(int j = 0; j < chars.length; j++) {
                chars[j] = (char) ('a' + rng.nextInt(26));
            }
            samples[i] = new String(chars);
        }

        for(int i = 0; i < samples.length; i++) {
            hashMap.put(samples[i], samples[i]);
        }
        System.out.println("\nsampleSize=" + sampleSize + "\nactualSize=" + hashMap.size() + "\ncollisions=" + hashMap.collisions());
        System.out.println(hashMap.toString());
    }
}