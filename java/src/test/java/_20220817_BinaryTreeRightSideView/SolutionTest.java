package _20220817_BinaryTreeRightSideView;

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
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(1, 2, 3, null, 5, null, 4), Arrays.asList(1, 3, 4)},
                {Arrays.asList(1, null, 3), Arrays.asList(1, 3)},
                {Arrays.asList(), Arrays.asList()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        List<Integer> result = solution.rightSideView(root);
        Assert.assertEquals(expected, result);
    }

}