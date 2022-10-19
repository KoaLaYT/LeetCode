package _20221019_PathSumIII;

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
    public int targetSum;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(10, 5, -3, 3, 2, null, 11, 0, 0, null, 1), 8, 5},
                {Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3},
                {Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22, 3},
                {Arrays.asList(1, null, 2, null, null, null, 3, null, null, null, null, null, 4, null, null, null, null, null, null, null, null, null, 5), 3, 2},
                {Arrays.asList(1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000), 0, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.pathSum(root, targetSum);
        Assert.assertEquals(expected, result);
    }

}