package _20220707_SearchBST;

import common.TreeNode;
import org.junit.Assert;
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
    public List<Integer> input;

    @Parameterized.Parameter(1)
    public int val;

    @Parameterized.Parameter(2)
    public Integer expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(4, 2, 7, 1, 3), 2, 2},
                {Arrays.asList(4, 2, 7, 1, 3), 5, null}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        TreeNode result = solution.searchBST(root, val);
        if (expected == null) {
            Assert.assertNull(result);
        } else {
            Assert.assertEquals(expected.intValue(), result.val);

        }
    }

}