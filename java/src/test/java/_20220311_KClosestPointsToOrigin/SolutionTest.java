package _20220311_KClosestPointsToOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Set;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] points;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int[][] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}},
                {new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}}},
                {new int[][]{{-5, 4}, {-3, 2}, {0, 1}, {-3, 7}, {-2, 0}, {-4, -6}, {0, -5}}, 6,
                        new int[][]{{0, 1}, {-2, 0}, {-3, 2}, {0, -5}, {-5, 4}, {-4, -6}}},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.kClosest(points, k);
        Assert.assertEquals(expected.length, result.length);
        for (int[] ints : result) {
            boolean hasEqual = false;
            for (int[] expect : expected) {
                if (Arrays.equals(expect, ints)) {
                    hasEqual = true;
                    break;
                }
            }
            Assert.assertTrue(hasEqual);
        }
    }

}