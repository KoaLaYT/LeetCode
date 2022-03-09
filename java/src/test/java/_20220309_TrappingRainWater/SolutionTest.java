package _20220309_TrappingRainWater;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] height;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6},
                {new int[]{4, 2, 0, 3, 2, 5}, 9},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.trap(height);
        Assert.assertEquals(expected, result);
    }

}