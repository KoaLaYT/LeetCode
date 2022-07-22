package _20220722_FindJudge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public int[][] trust;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, new int[][]{{1, 2}}, 2},
                {3, new int[][]{{1, 3}, {2, 3}}, 3},
                {3, new int[][]{{1, 3}, {2, 3}, {3, 1}}, -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findJudge(n, trust);
        Assert.assertEquals(expected, result);
    }

}