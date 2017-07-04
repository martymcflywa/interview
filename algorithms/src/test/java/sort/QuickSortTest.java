package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marty on 4/07/2017.
 */
public class QuickSortTest {

    private int[] actual;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        int[] testData = {0, 5, 7, 9, 3, 8, 2, 1, 4, 6};
        actual = testData;
        int[] expectedData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        expected = expectedData;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sort() throws Exception {
        print("INPUT", actual);
        QuickSort.sort(actual);
        print("QUICKSORT", actual);

        for(int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private void print(String title, int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(":\n");
        for(int i : array) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}