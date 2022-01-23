package _20220123_BinaryTreeLevelOrderTraversalII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
                        Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3))
                ),
                new TestCase(
                        new int[]{3, 9, 20, 4, 5, 15, 7, 1},
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(4, 5, 15, 7),
                                Arrays.asList(9, 20),
                                Arrays.asList(3))
                ),
                new TestCase(
                        new int[]{3, 9, 20, 4, -1, 15, 7, 1},
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(4, 15, 7),
                                Arrays.asList(9, 20),
                                Arrays.asList(3))
                ),
                new TestCase(
                        new int[]{1},
                        Arrays.asList(Arrays.asList(1))
                ),
                new TestCase(
                        new int[]{},
                        Collections.emptyList()
                )
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.levelOrderBottom(testCase.root);
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

        TreeNode buildTree(int[] input, int index) {
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