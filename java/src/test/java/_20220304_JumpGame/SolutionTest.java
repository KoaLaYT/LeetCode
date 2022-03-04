package _20220304_JumpGame;

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
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{2, 3, 1, 1, 4}, true},
                {new int[]{3, 2, 1, 0, 4}, false},
                {new int[]{3, 2, 2, 0, 4}, true},
                {new int[]{3, 0, 0, 0, 0, 0, 1}, false},
                {new int[]{2, 0}, true}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.canJump(nums);
        Assert.assertEquals(expected, result);
    }

}