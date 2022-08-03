package _20220803_MinimalCategories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] coins;

    @Parameterized.Parameter(1)
    public int amount;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{2, 5}, 11, 2},
                {new int[]{2, 3, 5}, 12, 1},
                {new int[]{24, 399, 138, 345, 590, 358, 59, 976, 916, 627, 415, 914, 754, 93}, 19883, 1},
                {new int[]{59, 399, 138, 345, 590, 358, 24, 976, 916, 627, 415, 914, 754, 93}, 19883, 1},
                {new int[]{179, 553, 438, 50, 317, 619, 834, 249, 81, 21, 26, 173, 578, 519, 117, 44, 907, 278, 802, 759, 410, 139, 631, 478, 881, 908, 313, 259, 172, 40, 404, 611, 383, 55, 344, 741, 925, 628, 85, 151, 311, 208, 501, 994, 356, 214, 360, 503}, 9630, 1}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minimal_categories(coins, amount);
        Assert.assertEquals(expected, result);
    }

}