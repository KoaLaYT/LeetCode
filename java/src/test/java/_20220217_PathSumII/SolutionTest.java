package _20220217_PathSumII;

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
                new TestCase(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1), 22,
                        Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5))),
                new TestCase(Arrays.asList(1, 2, 3), 5, Collections.emptyList()),
                new TestCase(Arrays.asList(1, 2), 0, Collections.emptyList()),
                new TestCase(Arrays.asList(1, -1, 2), 0, Arrays.asList(Arrays.asList(1, -1))),
                new TestCase(Arrays.asList(1, 2), 1, Collections.emptyList())
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.pathSum(testCase.root, testCase.targetSum);
        Assert.assertArrayEquals(testCase.expected.toArray(), result.toArray());
    }

    private static class TestCase {
        private TreeNode root;
        private int targetSum;
        private List<List<Integer>> expected;

        TestCase(List<Integer> input, int targetSum, List<List<Integer>> expected) {
            this.root = buildTree(input);
            this.targetSum = targetSum;
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