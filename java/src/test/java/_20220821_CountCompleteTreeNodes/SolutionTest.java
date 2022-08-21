package _20220821_CountCompleteTreeNodes;

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
                {Arrays.asList(1, 2, 3, 4, 5, 6), 6},
                {Arrays.asList(), 0},
                {Arrays.asList(1), 1},
                {Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 8},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.countNodes(root);
        Assert.assertEquals(expected, result);
    }

}