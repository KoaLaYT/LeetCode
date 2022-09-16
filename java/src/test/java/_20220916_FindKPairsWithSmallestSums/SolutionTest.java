package _20220916_FindKPairsWithSmallestSums;

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
    public int[] nums1;

    @Parameterized.Parameter(1)
    public int[] nums2;

    @Parameterized.Parameter(2)
    public int k;

    @Parameterized.Parameter(3)
    public List<List<Integer>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6))},
                {new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2, Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 1))},
                {new int[]{1, 2}, new int[]{3}, 3, Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 3))},
                {new int[]{1}, new int[]{2, 3}, 3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3))},
                {new int[]{1, 7, 11}, new int[]{2, 4, 6}, 5, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6), Arrays.asList(7, 2), Arrays.asList(7, 4))},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        Assert.assertEquals(expected, result);
    }

}