package _20220306_BestSightseeingPair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] values;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{8, 1, 5, 2, 6}, 11},
                {new int[]{1, 8, 1, 5, 2, 6}, 11},
                {new int[]{1, 2}, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxScoreSightseeingPair(values);
        Assert.assertEquals(expected, result);
    }

}