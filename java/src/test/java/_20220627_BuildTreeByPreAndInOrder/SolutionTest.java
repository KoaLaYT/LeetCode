package _20220627_BuildTreeByPreAndInOrder;

import common.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] preorder;

    @Parameterized.Parameter(1)
    public int[] inorder;

    @Parameterized.Parameter(2)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, Arrays.asList(3, 9, 20, null, null, 15, 7)},
                {new int[]{3}, new int[]{3}, List.of(3)},
                {new int[]{1, 2}, new int[]{2, 1}, Arrays.asList(1, 2)},
                {new int[]{1, 2}, new int[]{1, 2}, Arrays.asList(1, null, 2)},
                {new int[]{1, 2, 3}, new int[]{2, 3, 1}, Arrays.asList(1, 2, null, null, 3)},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}, Arrays.asList(1, null, 2, null, 3)},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode result = solution.buildTree(preorder, inorder);
        Utils.assertTreeEquals(expected, result);
    }

}