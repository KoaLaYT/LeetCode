package _20220610_MaxProduct;

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
                {new int[]{2, 3, -2, 4}, 6},
                {new int[]{2, 3, -2, -4}, 48},
                {new int[]{-2, 0, -1}, 0},
                {new int[]{-2, 1, 0, -1}, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxProduct(nums);
        Assert.assertEquals(expected, result);
    }

}