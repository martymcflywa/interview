package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poncem on 18/7/17.
 * Given an int[], find two values that sum to target.
 */
public class TwoSum {

    /**
     * O(n^2)
     * @param array
     * @param sum
     */
    public static void findWithNestedLoop(int[] array, int sum) {
        if(array.length < 2) {
            return;
        }

        System.out.println("Naive pairs that sum:");
        for(int i = 0; i < array.length; i++) {
            int first = array[i];
            for(int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if((first + second) == sum) {
                    System.out.printf("%d + %d = %d%n", first, second, sum);
                }
            }
        }
    }

    /**
     * O(1)
     * @param array
     * @param sum
     */
    public static void findWithHashSet(int[] array, int sum) {
        if(array.length < 2) {
            return;
        }

        System.out.println("Hashed pairs that sum:");
        // convert array to hashset
        Set set = new HashSet<Integer>(array.length);
        for(int value : array) {
            // target is what we look for in set
            int target = sum - value;
            if(!set.contains(target)) {
                // if it doesn't exist, add it to set
                set.add(value);
            } else {
                // otherwise we found the correct pair
                System.out.printf("%d + %d = %d%n", value, target, sum);
            }
        }
    }

    /**
     * O(log(n))
     * @param array
     * @param sum
     */
    public static void findWithTwoPointers(int[] array, int sum) {
        if(array.length < 2) {
            return;
        }

        System.out.println("Two pointer pairs that sum:");
        // sort array
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        // loop array, left pointer going right, right pointer going left
        while(left < right) {
            int tempSum = array[left] + array[right];
            if(tempSum == sum) {
                System.out.printf("%d + %d = %d%n", array[left], array[right], sum);
                left++;
                right--;
            } else if(tempSum < sum) {
                // if tempSum less than sum, increase left
                left++;
            } else {
                // if tempSum greater than sum, decrease right
                right--;
            }
        }
    }
}
