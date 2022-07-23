package _20220723_IsBipartite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] graph;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}, false},
                {new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}, true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isBipartite(graph);
        Assert.assertEquals(expected, result);
    }

}