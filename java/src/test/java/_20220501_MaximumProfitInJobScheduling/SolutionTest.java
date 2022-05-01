package _20220501_MaximumProfitInJobScheduling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] startTime;

    @Parameterized.Parameter(1)
    public int[] endTime;

    @Parameterized.Parameter(2)
    public int[] profit;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}, 120},
                {new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}, 150},
                {new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}, 6},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.jobScheduling(startTime, endTime, profit);
        Assert.assertEquals(expected, result);
    }

}