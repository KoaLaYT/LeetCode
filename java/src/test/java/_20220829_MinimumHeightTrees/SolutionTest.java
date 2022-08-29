package _20220829_MinimumHeightTrees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public int[][] edges;

    @Parameterized.Parameter(2)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, Arrays.asList(1)},
                {6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}, Arrays.asList(3, 4)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        Assert.assertEquals(expected, result);
    }

}