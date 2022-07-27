package _20220727_MaximumGap;

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
                {new int[]{3, 6, 9, 1}, 3},
                {new int[]{10}, 0},
                {new int[]{1, 10, 100, 101}, 90},
                {new int[]{100, 3, 2, 1}, 97},
                {new int[]{1, 1, 1, 1, 1, 5, 5, 5, 5, 5}, 4},
                {new int[]{1, 10000000}, 9999999},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maximumGap(nums);
        Assert.assertEquals(expected, result);
    }

}