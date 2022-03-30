package _20220330_BinaryTreeUpsideDown;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public List<Integer> nums;

    @Parameterized.Parameter(1)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(4, 5, 2, null, null, 3, 1)},
                {Arrays.asList(1, 2, 3, 4, 5, null, null, 6, 7), Arrays.asList(6, 7, 4, null, null, 5, 2, null, null, null, null, null, null, 3, 1)},
                {Arrays.asList(1, 2, 3, 4), Arrays.asList(4, null, 2, null, null, 3, 1)},
                {Collections.emptyList(), Collections.emptyList()},
                {Collections.singletonList(1), Collections.singletonList(1)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = buildTree(nums);
        TreeNode result = solution.upsideDownBinaryTree(root);
        isSameTree(buildTree(expected), result);
    }

    private void isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            Assert.assertEquals(t1.val, t2.val);
            isSameTree(t1.left, t2.left);
            isSameTree(t1.right, t2.right);
        } else {
            Assert.assertNull(t1);
            Assert.assertNull(t2);
        }
    }

    private TreeNode buildTree(List<Integer> nums) {
        return buildTree(nums, 0);
    }

    private TreeNode buildTree(List<Integer> nums, int i) {
        if (i >= nums.size()) {
            return null;
        }
        if (nums.get(i) == null) {
            return null;
        }
        TreeNode node = new TreeNode(nums.get(i));
        node.left = buildTree(nums, 2 * i + 1);
        node.right = buildTree(nums, 2 * i + 2);
        return node;
    }

}