package _20220707_LastTreeNodeInBST;

import common.TreeNode;
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
    public List<Integer> input;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int expectedIndex;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(1, 1, 27, 1, 1, 24, 29), 1, 0},
                {Arrays.asList(1, 1, 27, 1, 1, 24, 29), 27, 2},
                {Arrays.asList(1, 1, 27, 1, 1, 24, 29), 2, -1},
                {Arrays.asList(1, 1, 1, 1, 1, 24, 29), 1, 2},
                {Arrays.asList(1, 1, 1, 1, 1, 1, 29), 1, 2},
                {Arrays.asList(1, 1, 27, 1, 1, 1, 29), 1, 5},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode[] rootAndExpect = buildRootAndExpectation();
        TreeNode result = solution.lastTreeNodeInBST(rootAndExpect[0], k);
        Assert.assertEquals(rootAndExpect[1], result);
    }

    private TreeNode[] buildRootAndExpectation() {
        TreeNode[] expected = new TreeNode[1];
        TreeNode root = buildTree(0, expected);
        return new TreeNode[]{root, expected[0]};
    }

    private TreeNode buildTree(int index, TreeNode[] expected) {
        if (index >= input.size()) {
            return null;
        }

        Integer val = input.get(index);

        if (val == null) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(2 * index + 1, expected);
        node.right = buildTree(2 * index + 2, expected);

        if (index == expectedIndex) {
            expected[0] = node;
        }

        return node;
    }

}