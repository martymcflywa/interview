package practice;

/**
 * Created by poncem on 18/7/17.
 */
public class Fibonacci {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param n
     * @return
     */
    public static int iterative(int n) {
        if(n < 2) {
            return n;
        }
        int currentFib = 1;
        int previousFib = 1;
        for(int i = 2; i < n; i++) {
            int temp = currentFib;
            currentFib += previousFib;
            previousFib = temp;
        }
        return currentFib;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param n
     * @return
     */
    public static int recursive(int n) {
        if(n < 2) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }
}
