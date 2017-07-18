package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by poncem on 18/7/17.
 */
public class FibonacciTest {
    @Test
    public void iterative() throws Exception {
        assertEquals(1, Fibonacci.iterative(1));
        assertEquals(1, Fibonacci.iterative(2));
        assertEquals(2, Fibonacci.iterative(3));
        assertEquals(3, Fibonacci.iterative(4));
        assertEquals(5, Fibonacci.iterative(5));
        assertEquals(8, Fibonacci.iterative(6));
        assertEquals(13, Fibonacci.iterative(7));
    }

    @Test
    public void recursive() throws Exception {
        assertEquals(1, Fibonacci.recursive(1));
        assertEquals(1, Fibonacci.recursive(2));
        assertEquals(2, Fibonacci.recursive(3));
        assertEquals(3, Fibonacci.recursive(4));
        assertEquals(5, Fibonacci.recursive(5));
        assertEquals(8, Fibonacci.recursive(6));
        assertEquals(13, Fibonacci.recursive(7));
    }
}