package sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 11/7/17.
 */
public class MergeSortTest {


    private final int[] EXPECTED = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] ACTUAL = {8, 5, 3, 9, 0, 1, 6, 4, 2, 7};

    @Test
    public void sort() throws Exception {
        MergeSort.sort(ACTUAL);
        assertArrayEquals(EXPECTED, ACTUAL);
    }
}