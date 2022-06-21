package _20220621_MaxSlidingWindowII;

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
    public int[] a;

    @Parameterized.Parameter(2)
    public int[] b;

    @Parameterized.Parameter(3)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 1, 4, 6, 1},
                        new int[]{0, 2, 2, 0, 2}, new int[]{1, 3, 0, 2, 0},
                        new int[]{1, 4, -1, 6, -1}},
                {new int[]{52, 43, 28, 16, 41},
                        new int[]{4}, new int[]{4},
                        new int[]{-1}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.maxSlidingWindowII(nums, a, b);
        Assert.assertArrayEquals(expected, result);
    }

}