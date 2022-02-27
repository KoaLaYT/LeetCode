package _20220227_FlattenBinaryTreeToLinkedList;

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
                new TestCase(Arrays.asList(1, 2, 5, 3, 4, null, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)),
                new TestCase(null, null),
                new TestCase(Collections.singletonList(0), Collections.singletonList(0)),
                new TestCase(Arrays.asList(1, 2, null, null, 4), Arrays.asList(1, 2, 4)),
                new TestCase(Arrays.asList(1, null, 2, null, null, 3, 4), Arrays.asList(1, 2, 3, 4)),
                new TestCase(Arrays.asList(1, 2, 3, 4, 5, null, null, null, null, 6, null, null, null, null, null, null, null, null, null, null, 7),
                        Arrays.asList(1, 2, 4, 5, 6, 7, 3)),
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.flatten(testCase.root);
        TreeNode node = testCase.root;
        int index = 0;
        while (node != null) {
            Assert.assertTrue(index < testCase.expected.size());
            Assert.assertEquals(testCase.expected.get(index).intValue(), node.val);
            Assert.assertNull(node.left);
            node = node.right;
            index += 1;
        }
    }

    private static class TestCase {
        private TreeNode root;
        private List<Integer> expected;

        TestCase(List<Integer> input, List<Integer> expected) {
            this.root = buildTree(input);
            this.expected = expected;
        }

        private TreeNode buildTree(List<Integer> input) {
            if (input == null) {
                return null;
            }
            return buildTree(input, 0);
        }

        private TreeNode buildTree(List<Integer> input, int pos) {
            if (pos >= input.size()) {
                return null;
            }

            Integer value = input.get(pos);
            if (value == null) {
                return null;
            }
            TreeNode node = new TreeNode(value);
            node.left = buildTree(input, 2 * pos + 1);
            node.right = buildTree(input, 2 * pos + 2);
            return node;
        }
    }

}