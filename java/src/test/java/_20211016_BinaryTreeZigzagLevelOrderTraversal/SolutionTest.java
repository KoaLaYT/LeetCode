package _20211016_BinaryTreeZigzagLevelOrderTraversal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author koalayt 2021-10-16
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new int[]{3, 9, 20, -1, -1, 15, 7},
                        Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7))
                ),
                new TestCase(
                        new int[]{1},
                        Arrays.asList(Arrays.asList(1))
                ),
                new TestCase(
                        new int[]{},
                        Collections.emptyList()
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, -1, -1, 5},
                        Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5))
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5, 6, 7))
                )
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.zigzagLevelOrder(testCase.root);
        Assert.assertArrayEquals(testCase.expect.toArray(), result.toArray());
    }

    private static class TestCase {
        private TreeNode root;
        private List<List<Integer>> expect;

        TestCase(int[] root, List<List<Integer>> expect) {
            this.root = buildTree(root);
            this.expect = expect;
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
    }

}