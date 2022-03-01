package _20220301_MonotonicArray;

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
                {new int[]{1, 2, 2, 3}, true},
                {new int[]{6, 5, 4, 4}, true},
                {new int[]{1, 3, 2}, false},
                {new int[]{1, 1, 2}, true},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isMonotonic(nums);
        Assert.assertEquals(expected, result);
    }

}