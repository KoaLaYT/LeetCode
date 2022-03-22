package _20220322_MaximumSubarray;

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
                {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
                {new int[]{1}, 1},
                {new int[]{5, 4, -1, 7, 8}, 23},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(expected, result);
    }

}