package practice;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by poncem on 18/7/17.
 */
public class PalindromeTest {

    @Test
    public void isPalindromeIterative() throws Exception {
        String isPal = "bob";
        String notPal = "loop";
        assertTrue(problems.Palindrome.isPalindromeIterative(isPal));
        assertFalse(problems.Palindrome.isPalindromeIterative(notPal));
    }

    @Test
    public void isPalindromeRecursive() throws Exception {
        String isPal = "boob";
        String notPal = "what";
        assertTrue(problems.Palindrome.isPalindromeRecursive(isPal));
        assertFalse(Palindrome.isPalindromeRecursive(notPal));
    }
}