package _20220908_TopKFrequentElements;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}},
                {new int[]{1}, 1, new int[]{1}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.topKFrequent(nums, k);
        Arrays.sort(result);
        Arrays.sort(expected);
        Assert.assertArrayEquals(expected, result);
    }

}