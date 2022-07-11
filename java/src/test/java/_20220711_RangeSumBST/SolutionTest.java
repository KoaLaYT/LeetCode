package _20220711_RangeSumBST;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public List<Integer> input;

    @Parameterized.Parameter(1)
    public int low;

    @Parameterized.Parameter(2)
    public int high;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(10, 5, 15, 3, 7, null, 18), 7, 15, 32},
                {Arrays.asList(10, 5, 15, 3, 7, null, 18), 6, 16, 32},
                {Arrays.asList(10, 5, 15, 3, 7, null, 18), 6, 14, 17},
                {Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10, 23},
                {Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 2, 4, 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.rangeSumBST(root, low, high);
        Assert.assertEquals(expected, result);
    }

}