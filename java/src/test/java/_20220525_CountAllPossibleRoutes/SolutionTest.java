package _20220525_CountAllPossibleRoutes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] locations;

    @Parameterized.Parameter(1)
    public int start;

    @Parameterized.Parameter(2)
    public int finish;

    @Parameterized.Parameter(3)
    public int fuel;

    @Parameterized.Parameter(4)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{2, 3, 6, 8, 4}, 1, 3, 5, 4},
                {new int[]{4, 3, 1}, 1, 0, 6, 5},
                {new int[]{5, 2, 1}, 0, 2, 3, 0},
                {new int[]{5, 2, 1}, 0, 1, 0, 0},
                {new int[]{5, 2, 1}, 0, 1, 3, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.countRoutes(locations, start, finish, fuel);
        Assert.assertEquals(expected, result);
    }

}