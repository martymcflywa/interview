package problems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by poncem on 18/7/17.
 */
public class ReverseTest {

    @Test
    public void reverseInt() {
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] actual = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, Reverse.reverseIterativeInt(actual));
    }

    @Test
    public void reverseIterativeString() {
        String expected = "abcdefg";
        String actual = "gfedcba";
        assertEquals(expected, Reverse.reverseIterativeString(actual));
    }

    @Test
    public void reverseRecursiveString() {
        String expected = "abcdefg";
        String actual = "gfedcba";
        assertEquals(expected, Reverse.reverseRecursiveString(actual));
    }
}