package _20220806_MaxValue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] value;

    @Parameterized.Parameter(1)
    public int[][] extra_value;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 1, 1, 1, 1}, new int[][]{{0, 1, 2}, {0, 2, 3}}, 10},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.max_value(value, extra_value);
        Assert.assertEquals(expected, result);
    }

}