package practice;

/**
 * Created by poncem on 18/7/17.
 */
public class Reverse {

    public static int[] reverseIterativeInt(int[] array) {
        int[] output = array;
        int left = 0;
        int right = array.length - 1;
        int temp;

        while(left < right) {
            temp = output[left];
            output[left] = output[right];
            output[right] = temp;
            left++;
            right--;
        }
        return output;
    }

    public static String reverseIterativeString(String string) {
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        char temp;

        while(left < right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static String reverseRecursiveString(String string) {
        if(string == null) {
            return null;
        }
        if(string.length() < 2) {
            return string;
        }
        return reverseRecursiveString(string.substring(1)) + string.charAt(0);
    }
}
