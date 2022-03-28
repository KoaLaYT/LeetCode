package _20220328_LongestIncreasingSubsequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{0, 1, 0, 3, 2, 3}, 4},
                {new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4},
                {new int[]{7, 7, 7, 7, 7, 7, 7}, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.lengthOfLIS(nums);
        Assert.assertEquals(expected, result);
    }

}