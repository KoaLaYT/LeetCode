package _20220707_InorderSuccessor;

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
    public int pIndex;

    @Parameterized.Parameter(2)
    public int expectedIndex;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(2, 1, 3), 1, 0},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 2, -1},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 4, 0},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 3, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode[] data = buildData();
        TreeNode result = solution.inorderSuccessor(data[0], data[1]);
        Assert.assertEquals(data[2], result);
    }

    private TreeNode[] buildData() {
        TreeNode[] data = new TreeNode[3];
        TreeNode root = buildTree(0, data);
        data[0] = root;
        return data;
    }

    private TreeNode buildTree(int index, TreeNode[] data) {
        if (index >= input.size()) {
            return null;
        }

        Integer val = input.get(index);

        if (val == null) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(2 * index + 1, data);
        node.right = buildTree(2 * index + 2, data);

        if (index == pIndex) {
            data[1] = node;
        }

        if (index == expectedIndex) {
            data[2] = node;
        }

        return node;
    }

}