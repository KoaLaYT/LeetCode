package _20220708_DeleteNode;

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
    public int key;

    @Parameterized.Parameter(2)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(5, 3, 6, 2, 4, null, 7), 3, Arrays.asList(5, 4, 6, 2, null, null, 7)},
                {Arrays.asList(5, 3, 6, 2, 4, null, 7), 0, Arrays.asList(5, 3, 6, 2, 4, null, 7)},
                {Arrays.asList(5, 3, 6, 2, 4, null, 7), 5, Arrays.asList(6, 3, 7, 2, 4)},
                {Arrays.asList(8, 4, 10, 3, 6, 9, 11, null, null, 5, 7), 4, Arrays.asList(8, 5, 10, 3, 6, 9, 11, null, null, null, 7)},
                {Arrays.asList(50, 30, 70, null, 40, 60, 80), 50, Arrays.asList(60, 30, 70, null, 40, null, 80)},
                {Arrays.asList(3, 2, 5, null, null, 4, 10, null, null, null, null, null, null, 8, 15, null, null, null, null, null, null, null, null, null, null, null, null, 7), 5,
                        Arrays.asList(3, 2, 7, null, null, 4, 10, null, null, null, null, null, null, 8, 15)},
                {Arrays.asList(), 0, Arrays.asList()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        TreeNode result = solution.deleteNode(root, key);
        TreeNode expectedTree = Utils.buildTree(expected);
        treeEquals(expectedTree, result);
    }

    private void treeEquals(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            Assert.assertNull(t2);
            return;
        }

        Assert.assertNotNull(t2);

        Assert.assertEquals(t1.val, t2.val);
        treeEquals(t1.left, t2.left);
        treeEquals(t1.right, t2.right);
    }

}