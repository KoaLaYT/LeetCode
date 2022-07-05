package _20220705_MedianSlidingWindow;

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
    public int k;

    @Parameterized.Parameter(2)
    public double[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new double[]{1, -1, -1, 3, 5, 6}},
                {new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647}, 2, new double[]{1073741824.0, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1073741827.0}},
                {new int[]{5, 2, 2, 7, 3, 7, 9, 0, 2, 3}, 9, new double[]{3, 3}},
                {new int[]{-2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648}, 6,
                        new double[]{-1073741823.5, -1073741823.5, -49.5, -49.5, 2.0, 5.5, -46.0, -46.0, 12.5, 19.5, 1073741834.5, 2147483647.0, 2147483647.0, 2147483647.0, 2147483647.0}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double[] result = solution.medianSlidingWindow(nums, k);
        Assert.assertArrayEquals(expected, result, 0.00001);
    }

}