package _20220302_BalancedBinaryTree;

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
    public TreeNode root;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)), true},
                {buildTree(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4)), false},
                {null, true},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isBalanced(root);
        Assert.assertEquals(expected, result);
    }

    private static TreeNode buildTree(List<Integer> input) {
        return buildTree(input, 0);
    }

    private static TreeNode buildTree(List<Integer> input, int index) {
        if (index >= input.size()) {
            return null;
        }
        Integer value = input.get(index);
        if (value == null) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = buildTree(input, 2 * index + 1);
        node.right = buildTree(input, 2 * index + 2);
        return node;
    }

}