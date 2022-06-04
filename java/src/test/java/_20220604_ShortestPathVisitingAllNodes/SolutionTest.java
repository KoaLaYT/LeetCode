package _20220604_ShortestPathVisitingAllNodes;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {0}, {0}, {0}}, 4},
                {new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}, 4},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.shortestPathLength(graph);
        Assert.assertEquals(expected, result);
    }

}