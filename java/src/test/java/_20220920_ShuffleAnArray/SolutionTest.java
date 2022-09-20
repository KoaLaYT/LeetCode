package _20220920_ShuffleAnArray;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution(nums);

        solution.shuffle();

        Assert.assertArrayEquals(nums, solution.reset());

        solution.shuffle();
    }

}