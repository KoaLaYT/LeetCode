package _20220503_NonOverlappingIntervals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] intervals;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1},
                {new int[][]{{1, 2}, {1, 2}, {1, 2}}, 2},
                {new int[][]{{1, 2,}, {2, 3}}, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.eraseOverlapIntervals(intervals);
        Assert.assertEquals(expected, result);
    }

}