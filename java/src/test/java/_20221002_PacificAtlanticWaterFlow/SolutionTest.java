package _20221002_PacificAtlanticWaterFlow;

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
    public int[][] heights;

    @Parameterized.Parameter(1)
    public List<List<Integer>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{
                                {1, 2, 2, 3, 5},
                                {3, 2, 3, 4, 4},
                                {2, 4, 5, 3, 1},
                                {6, 7, 1, 4, 5},
                                {5, 1, 1, 2, 4}},
                        Arrays.asList(
                                Arrays.asList(0, 4),
                                Arrays.asList(1, 3),
                                Arrays.asList(1, 4),
                                Arrays.asList(2, 2),
                                Arrays.asList(3, 0),
                                Arrays.asList(3, 1),
                                Arrays.asList(4, 0)),
                },
                {
                        new int[][]{{1}}, Arrays.asList(Arrays.asList(0, 0))
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        Assert.assertEquals(expected, result);
    }

}