package _20220717_TreeToDoublyList;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;
import java.util.Collections;
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
                {Arrays.asList(4, 2, 5, 1, 3), Arrays.asList(1, 2, 3, 4, 5)},
                {Arrays.asList(), Arrays.asList()},
                {Arrays.asList(1), Arrays.asList(1)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        TreeNode result = solution.treeToDoublyList(root);
        assertTreeAsList(expected, result);
    }

    private void assertTreeAsList(List<Integer> expected, TreeNode node) {
        if (expected.isEmpty()) {
            Assert.assertNull(node);
            return;
        }

        // one direction
        int i = 0;
        while (i < expected.size()) {
            Assert.assertEquals(expected.get(i).intValue(), node.val);
            i += 1;
            node = node.right;
        }

        Assert.assertNotNull(node);
        Assert.assertEquals(expected.get(0).intValue(), node.val);

        // reversed direction
        i = expected.size() - 1;
        node = node.left;
        while (i >= 0) {
            Assert.assertEquals(expected.get(i).intValue(), node.val);
            i -= 1;
            node = node.left;
        }

        Assert.assertNotNull(node);
        Assert.assertEquals(expected.get(expected.size() - 1).intValue(), node.val);
    }

}