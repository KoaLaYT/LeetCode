package _20220322_HouseRobbor;

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
                {new int[]{1, 2, 3, 1}, 4},
                {new int[]{2, 7, 9, 3, 1}, 12},
                {new int[]{1}, 1},
                {new int[]{1, 2}, 2},
                {new int[]{2, 1, 1, 2}, 4},
                {new int[]{3, 1, 1, 1, 1, 3}, 7},
                {new int[]{2, 11, 2}, 11},
                {new int[]{1, 1, 1}, 2},
                {new int[]{4, 1, 2, 7, 5, 3, 1}, 14},
                {new int[]{183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238, 168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211}, 3365}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.rob(nums);
        Assert.assertEquals(expected, result);
    }

}