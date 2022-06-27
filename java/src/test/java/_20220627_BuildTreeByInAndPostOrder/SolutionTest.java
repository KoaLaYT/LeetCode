package _20220627_BuildTreeByInAndPostOrder;

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
    public int[] inorder;

    @Parameterized.Parameter(1)
    public int[] postorder;

    @Parameterized.Parameter(2)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}, Arrays.asList(3, 9, 20, null, null, 15, 7)},
                {new int[]{3}, new int[]{3}, Arrays.asList(3)},
                {new int[]{2, 1}, new int[]{2, 1}, Arrays.asList(1, 2)},
                {new int[]{1, 2}, new int[]{2, 1}, Arrays.asList(1, null, 2)},
                {new int[]{2, 3, 1}, new int[]{3, 2, 1}, Arrays.asList(1, 2, null, null, 3)},
                {new int[]{1, 2, 3}, new int[]{3, 2, 1}, Arrays.asList(1, null, 2, null, 3)},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode result = solution.buildTree(inorder, postorder);
        Utils.assertTreeEquals(expected, result);
    }

}