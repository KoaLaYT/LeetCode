package _20220608_TwoDimensionArrayIntervalSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] nums;

    @Parameterized.Parameter(1)
    public int[][] queries;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{
                        {1, 3, 1, 2, 1},
                        {1, 3, 1, 2, 1},
                        {1, 3, 1, 2, 1}},
                        new int[][]{{1, 1, 3, 3}, {2, 2, 3, 3}},
                        new int[]{15, 8}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.two_dimension_array_interval_sum(nums, queries);
        Assert.assertArrayEquals(expected, result);
    }

}