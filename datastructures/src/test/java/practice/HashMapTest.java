package practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by marty on 6/07/2017.
 */
public class HashMapTest {

    private HashMap hashMap;
    private final int SIZE = 10;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap(SIZE);
    }

    @After
    public void tearDown() throws Exception {
        hashMap = null;
        System.gc();
    }

    @Test
    public void put() {
        // test when key doesn't exist
        String key = "pkey";
        String val1 = "pval1";
        assertNull(hashMap.put(key, val1));

        // test when key does exist
        String val2 = "pval2";
        assertEquals(val1, hashMap.put(key, val2));
        assertEquals(val2, hashMap.get(key));
    }

    @Test
    public void get() {
        // test when key doesn't exist
        String key = "gkey";
        String val = "gval";
        assertNull(hashMap.get(key));

        // test when key does exist
        hashMap.put(key, val);
        assertEquals(val, hashMap.get(key));
    }

    @Test
    public void remove() {
        // test when key doesn't exist
        String key = "rkey";
        String val = "rval";
        assertNull(hashMap.remove(key));

        // test when key does exist
        hashMap.put(key, val);
        assertEquals(val, hashMap.remove(key));
        assertNull(hashMap.get(key));
    }

    @Test
    public void largerPut() {
        int sampleSize = 10;
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
        System.out.println(hashMap.toString());
    }
}