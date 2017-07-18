package practice;

/**
 * Created by poncem on 18/7/17.
 */
public class Palindrome {

    public static boolean isPalindromeIterative(String string) {
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return string.equals(new String(chars));
    }

    public static boolean isPalindromeRecursive(String string) {
        if(string == null) {
            return false;
        }
        String reverse = reverse(string);
        return string.equals(reverse);
    }

    private static String reverse(String string) {
        if(string == null) {
            return null;
        }
        if(string.length() < 2) {
            return string;
        }
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
