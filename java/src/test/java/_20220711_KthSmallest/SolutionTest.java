package _20220711_KthSmallest;

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
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(3, 1, 4, null, 2), 1, 1},
                {Arrays.asList(3, 1, 4, null, 2), 2, 2},
                {Arrays.asList(3, 1, 4, null, 2), 3, 3},
                {Arrays.asList(3, 1, 4, null, 2), 4, 4},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 1, 1},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 2, 2},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 3, 3},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 4, 4},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 5, 5},
                {Arrays.asList(5, 3, 6, 2, 4, null, null, 1), 6, 6},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.kthSmallest(root, k);
        Assert.assertEquals(expected, result);
    }

}