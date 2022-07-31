package _20220731_SequentialDistance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] x;

    @Parameterized.Parameter(1)
    public int[] y;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{5, 10, 4, 9, 2, 8, 1, 7, 3, 6}, false},
                {new int[]{5, 6, 1, 7, 4, 3, 2}, new int[]{3, 7, 1, 4, 2, 6, 5}, false},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.sequential_distance(x, y);
        Assert.assertEquals(expected, result);
    }

}