package _20211006_RecoverBinarySearchTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-10-06
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(new int[]{1, 3, -1, -1, 2}, new int[]{3, 1, -1, -1, 2}),
                new TestCase(new int[]{3, 1, 4, -1, -1, 2}, new int[]{2, 1, 4, -1, -1, 3}),
                new TestCase(new int[]{2, -1, 1}, new int[]{1, -1, 2}),
                new TestCase(new int[]{2, 3, 1}, new int[]{2, 1, 3}),
                new TestCase(new int[]{3, -1, 2, -1, -1, -1, 1}, new int[]{1, -1, 2, -1, -1, -1, 3})
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.recoverTree(testCase.root);
        testCase.assertEquals(testCase.root);
    }

    private static class TestCase {
        private TreeNode root;
        private TreeNode expect;

        TestCase(int[] root, int[] expect) {
            this.root = buildTree(root);
            this.expect = buildTree(expect);
        }

        TreeNode buildTree(int[] input) {
            return buildTree(input, 0);
        }

        private TreeNode buildTree(int[] input, int index) {
            if (index >= input.length || input[index] == -1) {
                return null;
            }
            TreeNode node = new TreeNode(input[index]);
            node.left = buildTree(input, 2 * index + 1);
            node.right = buildTree(input, 2 * index + 2);
            return node;
        }

        void assertEquals(TreeNode result) {
            assertEquals(expect, result);
        }

        private void assertEquals(TreeNode node1, TreeNode node2) {
            if (node1 != null && node2 != null) {
                Assert.assertEquals(node1.val, node2.val);
                assertEquals(node1.left, node2.left);
                assertEquals(node1.right, node2.right);
            } else {
                Assert.assertNull(node1);
                Assert.assertNull(node2);
            }
        }
    }

}