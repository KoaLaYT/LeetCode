package _20220215_ConvertSortedListToBinarySearchTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(new int[]{-10, -3, 0, 5, 9}, Arrays.asList(0, -10, 5, null, -3, null, 9)),
                new TestCase(new int[]{1, 3}, Arrays.asList(1, null, 3)),
                new TestCase(new int[]{}, Collections.emptyList())
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode result = solution.sortedListToBST(testCase.listNode);
        testCase.assertEqual(result);
    }

    private static class TestCase {
        private ListNode listNode;
        private List<Integer> expected;

        TestCase(int[] input, List<Integer> expected) {
            this.listNode = arrayToListNode(input);
            this.expected = expected;
        }

        void assertEqual(TreeNode treeNode) {
            List<Integer> result = bstToArray(treeNode);
            Assert.assertEquals(expected.size(), result.size());
            for (int i = 0; i < expected.size(); i++) {
                Assert.assertEquals(expected.get(i), result.get(i));
            }
        }

        ListNode arrayToListNode(int[] input) {
            if (input.length <= 0) {
                return null;
            }

            ListNode node = new ListNode(input[input.length - 1]);
            for (int i = input.length - 2; i >= 0; i--) {
                node = new ListNode(input[i], node);
            }

            return node;
        }

        List<Integer> bstToArray(TreeNode node) {
            if (node == null) {
                return Collections.emptyList();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            LinkedList<Integer> result = new LinkedList<>();

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    if (head == null) {
                        result.add(null);
                    } else {
                        result.add(head.val);
                        queue.add(head.left);
                        queue.add(head.right);
                    }
                }
            }

            while (result.peekLast() == null) {
                result.removeLast();
            }

            return result;
        }
    }

}