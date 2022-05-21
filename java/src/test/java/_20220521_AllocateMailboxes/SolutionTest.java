package _20220521_AllocateMailboxes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] houses;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 4, 8, 10, 20}, 3, 5},
                {new int[]{2, 3, 5, 12, 18}, 2, 9},
                {new int[]{1, 8, 12, 10, 3}, 3, 4},
                {new int[]{7, 4, 6, 1}, 1, 8},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minDistance(houses, k);
        Assert.assertEquals(expected, result);
    }

}