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
        problems.TwoSum.findWithNestedLoop(noDuplicates, targetSum);
        problems.TwoSum.findWithNestedLoop(duplicates, targetSum);
        problems.TwoSum.findWithNestedLoop(negatives, targetSum);
    }

    @Test
    public void findSet() {
        problems.TwoSum.findWithHashSet(noDuplicates, targetSum);
        problems.TwoSum.findWithHashSet(duplicates, targetSum);
        problems.TwoSum.findWithHashSet(negatives, targetSum);
    }

    @Test
    public void findWithTwoPointers() {
        problems.TwoSum.findWithTwoPointers(noDuplicates, targetSum);
        problems.TwoSum.findWithTwoPointers(duplicates, targetSum);
        TwoSum.findWithTwoPointers(negatives, targetSum);
    }
}