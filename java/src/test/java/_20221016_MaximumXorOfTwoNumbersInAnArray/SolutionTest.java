package _20221016_MaximumXorOfTwoNumbersInAnArray;

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
                {new int[]{3, 10, 5, 25, 2, 8}, 28},
                {new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findMaximumXOR(nums);
        Assert.assertEquals(expected, result);
    }

}