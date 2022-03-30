package _20220330_LargestDivisibleSubset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3}, Arrays.asList(1, 2)},
                {new int[]{1, 2, 4, 8}, Arrays.asList(1, 2, 4, 8)},
                {new int[]{4, 8, 10, 240}, Arrays.asList(4, 8, 240)},
                {new int[]{4, 5, 8, 10, 24, 240}, Arrays.asList(4, 8, 24, 240)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.largestDivisibleSubset(nums);
        Assert.assertEquals(expected, result);
    }

}