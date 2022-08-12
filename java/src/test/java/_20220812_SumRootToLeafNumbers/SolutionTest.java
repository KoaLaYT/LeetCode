package _20220812_SumRootToLeafNumbers;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(1, 2, 3), 25},
                {Arrays.asList(4, 9, 0, 5, 1), 1026},
                {Arrays.asList(), 0},
                {Arrays.asList(1, 2), 12},
                {Arrays.asList(1), 1},
                {Arrays.asList(4, 9, 0, 5, 1, null, null, 2, 1, 3), 14856},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.sumNumbers(root);
        Assert.assertEquals(expected, result);
    }

}