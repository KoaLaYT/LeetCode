package _20220305_MaximumLengthOfSubarrayWithPostiveProduct;

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
                {new int[]{1, -2, -3, 4}, 4},
                {new int[]{0, 1, -2, -3, -4}, 3},
                {new int[]{-1, -2, -3, 0, 1}, 2},
                {new int[]{0}, 0},
                {new int[]{-1}, 0},
                {new int[]{1}, 1},
                {new int[]{1, -1, 1}, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.getMaxLen(nums);
        Assert.assertEquals(expected, result);
    }

}