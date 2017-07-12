package practice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 12/7/17.
 */
public class StringQuickSortTest {

    private final String[] EXPECTED = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    private final String[] ACTUAL = {"g", "j", "c", "f", "a", "i", "h", "e", "b", "d"};

    @Test
    public void sort() throws Exception {
        StringQuickSort.sort(ACTUAL);
        assertArrayEquals(EXPECTED, ACTUAL);
    }
}