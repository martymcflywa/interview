package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by poncem on 18/7/17.
 */
public class FibonacciTest {
    @Test
    public void iterative() throws Exception {
        assertEquals(1, problems.Fibonacci.iterative(1));
        assertEquals(1, problems.Fibonacci.iterative(2));
        assertEquals(2, problems.Fibonacci.iterative(3));
        assertEquals(3, problems.Fibonacci.iterative(4));
        assertEquals(5, problems.Fibonacci.iterative(5));
        assertEquals(8, problems.Fibonacci.iterative(6));
        assertEquals(13, problems.Fibonacci.iterative(7));
    }

    @Test
    public void recursive() throws Exception {
        assertEquals(1, problems.Fibonacci.recursive(1));
        assertEquals(1, problems.Fibonacci.recursive(2));
        assertEquals(2, problems.Fibonacci.recursive(3));
        assertEquals(3, problems.Fibonacci.recursive(4));
        assertEquals(5, problems.Fibonacci.recursive(5));
        assertEquals(8, problems.Fibonacci.recursive(6));
        assertEquals(13, Fibonacci.recursive(7));
    }
}