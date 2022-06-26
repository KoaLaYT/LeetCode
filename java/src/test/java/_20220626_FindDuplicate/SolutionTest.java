package _20220626_FindDuplicate;

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
                {new int[]{1, 3, 4, 2, 2}, 2},
                {new int[]{3, 1, 3, 4, 2}, 3},
                {new int[]{3, 2, 5, 4, 6, 4, 1}, 4},
                {new int[]{3, 2, 4, 5, 6, 4, 1}, 4},
                {new int[]{4, 3, 2, 5, 6, 4, 1}, 4},
                {new int[]{3, 4, 2, 5, 6, 4, 1}, 4},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findDuplicate(nums);
        Assert.assertEquals(expected, result);
    }

}