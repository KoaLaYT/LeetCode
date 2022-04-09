package _20220409_ShortestDistanceToTargetColor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] colors;

    @Parameterized.Parameter(1)
    public int[][] queries;

    @Parameterized.Parameter(2)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3}, new int[][]{{1, 3}, {2, 2}, {6, 1}}, Arrays.asList(3, 0, 3)},
                {new int[]{1, 2}, new int[][]{{0, 3}}, Collections.singletonList(-1)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.shortestDistanceColor(colors, queries);
        Assert.assertEquals(expected, result);
    }

}