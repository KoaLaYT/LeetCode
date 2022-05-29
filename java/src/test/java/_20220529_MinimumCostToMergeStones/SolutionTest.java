package _20220529_MinimumCostToMergeStones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] stones;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{3, 2, 4, 1}, 2, 20},
                {new int[]{3, 2, 4, 1}, 3, -1},
                {new int[]{3, 5, 1, 2, 6}, 3, 25},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.mergeStones(stones, k);
        Assert.assertEquals(expected, result);
    }

}