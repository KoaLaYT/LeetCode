package _20220304_MaximumSumCircularSubarray;

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
                {new int[]{1, -2, 3, -2}, 3},
                {new int[]{1, -2, 3, 2}, 6},
                {new int[]{-3, -4, -3}, -3},
                {new int[]{-10, 3, -4, -1}, 3},
                {new int[]{-1, -2, 3, 2}, 5},
                {new int[]{-3, -4, 1, -3}, 1},
                {new int[]{-1, -4, -3, 3}, 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxSubarraySumCircular(nums);
        Assert.assertEquals(expected, result);
    }

}