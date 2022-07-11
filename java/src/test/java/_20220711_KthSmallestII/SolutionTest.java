package _20220711_KthSmallestII;

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
    public List<Integer> nodeval_input;

    @Parameterized.Parameter(1)
    public List<Integer> nodenum_input;

    @Parameterized.Parameter(2)
    public int k;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(5, 3, 8, 2, 3), Arrays.asList(5, 3, 1, 1, 1), 1, 2},
                {Arrays.asList(5, 3, 8, 2, 3), Arrays.asList(5, 3, 1, 1, 1), 2, 3},
                {Arrays.asList(5, 3, 8, 2, 3), Arrays.asList(5, 3, 1, 1, 1), 3, 3},
                {Arrays.asList(5, 3, 8, 2, 3), Arrays.asList(5, 3, 1, 1, 1), 4, 5},
                {Arrays.asList(5, 3, 8, 2, 3), Arrays.asList(5, 3, 1, 1, 1), 5, 8},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(nodeval_input);
        TreeNode nodenum_root = Utils.buildTree(nodenum_input);
        int result = solution.kthSmallestII(root, nodenum_root, k);
        Assert.assertEquals(expected, result);
    }

}