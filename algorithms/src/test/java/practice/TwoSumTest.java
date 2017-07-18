package practice;

import org.junit.Test;

/**
 * Created by poncem on 18/7/17.
 */
public class TwoSumTest {

    private int[] noDuplicates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private int[] duplicates = {1, 1, 3, 4, 5, 5, 7, 8, 9, 0};
    private int[] negatives = {-5, 8, 2, -1, 4, 6, 9, 11, 15};
    private int targetSum = 10;

    @Test
    public void findNaive() {
        TwoSum.findWithNestedLoop(noDuplicates, targetSum);
        TwoSum.findWithNestedLoop(duplicates, targetSum);
        TwoSum.findWithNestedLoop(negatives, targetSum);
    }

    @Test
    public void findSet() {
        TwoSum.findWithHashSet(noDuplicates, targetSum);
        TwoSum.findWithHashSet(duplicates, targetSum);
        TwoSum.findWithHashSet(negatives, targetSum);
    }

    @Test
    public void findWithTwoPointers() {
        TwoSum.findWithTwoPointers(noDuplicates, targetSum);
        TwoSum.findWithTwoPointers(duplicates, targetSum);
        TwoSum.findWithTwoPointers(negatives, targetSum);
    }
}