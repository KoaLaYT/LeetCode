package _20220821_ProductOfArrayExceptSelf;

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
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}},
                {new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.productExceptSelf(nums);
        Assert.assertArrayEquals(expected, result);
    }

}