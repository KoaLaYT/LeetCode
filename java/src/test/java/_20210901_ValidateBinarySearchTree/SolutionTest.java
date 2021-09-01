package _20210901_ValidateBinarySearchTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author koalayt 2021-09-01
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase{index}")
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(Arrays.asList(2, 1, 3), true),
                new TestCase(Arrays.asList(5, 1, 4, null, null, 3, 6), false),
                new TestCase(Arrays.asList(2, 1, 3, null, 4, null, null), false)
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void testIsValidBST() {
        TreeNode root = testCase.buildTree();
        boolean result = solution.isValidBST(root);
        Assert.assertEquals(testCase.expected, result);
    }

    public static class TestCase {
        List<Integer> inputs;
        boolean expected;

        public TestCase(List<Integer> inputs, boolean expected) {
            this.inputs = inputs;
            this.expected = expected;
        }

        public TreeNode buildTree() {
            return buildTree(0);
        }

        private TreeNode buildTree(int i) {
            if (i >= inputs.size() || Objects.isNull(inputs.get(i))) {
                return null;
            }
            TreeNode node = new TreeNode(inputs.get(i));
            node.left = buildTree(2 * i + 1);
            node.right = buildTree(2 * i + 2);
            return node;
        }
    }

}