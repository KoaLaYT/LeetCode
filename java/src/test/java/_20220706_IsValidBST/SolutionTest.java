package _20220706_IsValidBST;

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
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(2, 1, 3), true},
                {Arrays.asList(5, 1, 4, null, null, 3, 6), false},
                {Arrays.asList(1, 1), false},
                {Arrays.asList(2147483647), true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        boolean result = solution.isValidBST(root);
        Assert.assertEquals(expected, result);
    }

}