package _20220812_LongestConsecutiveSequence;

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
                {new int[]{100, 4, 200, 1, 3, 2}, 4},
                {new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.longestConsecutive(nums);
        Assert.assertEquals(expected, result);
    }

}