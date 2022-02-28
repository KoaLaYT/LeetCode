package _20220227_LongestIncreasingSubsequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameter(1)
    public int expected;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
                {new int[]{0, 1, 0, 3, 2, 3}, 4},
                {new int[]{7, 7, 7, 7, 7, 7, 7}, 1},
                {new int[]{1}, 1},
                {new int[]{10, 9, 8, 7, 5}, 1},
                {new int[]{1, 9, 8, 7, 5}, 2},
                {new int[]{1, 9, 3, 7, 5}, 3},
                {new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}, 6},
                {new int[]{10, 8, 9, 11}, 3},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.lengthOfLIS(nums);
        Assert.assertEquals(expected, result);
    }

}