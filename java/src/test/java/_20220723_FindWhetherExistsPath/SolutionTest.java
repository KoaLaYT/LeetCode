package _20220723_FindWhetherExistsPath;

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
    public int[][] graph;

    @Parameterized.Parameter(2)
    public int start;

    @Parameterized.Parameter(3)
    public int target;

    @Parameterized.Parameter(4)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] dat() {
        return new Object[][]{
                {3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2, true},
                {5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4, true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.findWhetherExistsPath(n, graph, start, target);
        Assert.assertEquals(expected, result);
    }

}