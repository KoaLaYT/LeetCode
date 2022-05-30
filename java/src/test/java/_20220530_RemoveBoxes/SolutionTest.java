package _20220530_RemoveBoxes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] boxes;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}, 23},
                {new int[]{1, 1, 1}, 9},
                {new int[]{1}, 1},
                {new int[]{9, 3, 6, 8, 8, 1, 2, 5, 5, 6}, 16},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.removeBoxes(boxes);
        Assert.assertEquals(expected, result);
    }

}