package _20220727_FindDiagonalOrder;

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
    public List<List<Integer>> nums;

    @Parameterized.Parameter(1)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(4, 5, 6),
                                Arrays.asList(7, 8, 9)),
                        new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9}
                },
                {
                        Arrays.asList(
                                Arrays.asList(1, 2, 3, 4, 5),
                                Arrays.asList(6, 7),
                                Arrays.asList(8),
                                Arrays.asList(9, 10, 11),
                                Arrays.asList(12, 13, 14, 15, 16)),
                        new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16}
                },
                {
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(4),
                                Arrays.asList(5, 6, 7),
                                Arrays.asList(8),
                                Arrays.asList(9, 10, 11)),
                        new int[]{1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11}
                },
                {
                        Arrays.asList(
                                Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new int[]{1, 2, 3, 4, 5, 6}
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.findDiagonalOrder(nums);
        Assert.assertArrayEquals(expected, result);
    }

}