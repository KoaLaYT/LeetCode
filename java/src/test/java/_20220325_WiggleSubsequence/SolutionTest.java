package _20220325_WiggleSubsequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 7, 4, 9, 2, 5}, 6},
                {new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2},
                {new int[]{1}, 1},
                {new int[]{1, 1, 2}, 2},
                {new int[]{1, 1, 2, 2, 3}, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.wiggleMaxLength(nums);
        Assert.assertEquals(expected, result);
    }

}