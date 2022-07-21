package _20220721_IsConnectGraph;

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
    public int[][] e;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {5, new int[][]{{0, 1}, {2, 3}, {1, 4}}, false},
                {5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isConnectGraph(n, e);
        Assert.assertEquals(expected, result);
    }

}