package _20221001_QueueReconstructionByHeight;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] people;

    @Parameterized.Parameter(1)
    public int[][] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}},
                        new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}},
                },
                {
                        new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}},
                        new int[][]{{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}},
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.reconstructQueue(people);
        Assert.assertArrayEquals(expected, result);
    }

}