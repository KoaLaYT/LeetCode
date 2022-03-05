package _20220305_LinkedListInBinaryTree;

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
    public ListNode head;

    @Parameterized.Parameter(1)
    public TreeNode root;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        buildList(Arrays.asList(4, 2, 8)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        true
                },
                {
                        buildList(Arrays.asList(1, 4, 2, 8)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        true
                },
                {
                        buildList(Arrays.asList(1, 4, 2, 8, 6)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        false
                },
                {
                        buildList(Arrays.asList(1, 4, 2, 6, 8)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        false
                },
                {
                        buildList(Arrays.asList(2, 8)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        true
                },
                {
                        buildList(Arrays.asList(1, 2)),
                        buildTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8, null, null, null, null, null, null, null, null, null, null, null, null, 1, 3)),
                        false
                },
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isSubPath(head, root);
        Assert.assertEquals(expected, result);
    }

    private static ListNode buildList(List<Integer> input) {
        ListNode head = null;
        for (int i = input.size() - 1; i >= 0; i--) {
            head = new ListNode(input.get(i), head);
        }
        return head;
    }

    private static TreeNode buildTree(List<Integer> input) {
        if (input == null) {
            return null;
        }
        return buildTree(input, 0);
    }

    private static TreeNode buildTree(List<Integer> input, int pos) {
        if (pos >= input.size() || input.get(pos) == null) {
            return null;
        }
        TreeNode left = buildTree(input, 2 * pos + 1);
        TreeNode right = buildTree(input, 2 * pos + 2);
        return new TreeNode(input.get(pos), left, right);
    }

}