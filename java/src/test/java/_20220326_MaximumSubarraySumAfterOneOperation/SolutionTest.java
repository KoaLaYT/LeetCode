package _20220326_MaximumSubarraySumAfterOneOperation;

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
                {new int[]{2, -1, -4, -3}, 17},
                {new int[]{-2, -1, -4, -3}, 16},
                {new int[]{1, -1, 1, 1, -1, -1, 1}, 4},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxSumAfterOperation(nums);
        Assert.assertEquals(expected, result);
    }

}