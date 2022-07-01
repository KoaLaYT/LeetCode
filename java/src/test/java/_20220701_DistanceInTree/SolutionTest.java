package _20220701_DistanceInTree;

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
    public int p;

    @Parameterized.Parameter(2)
    public int q;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(0, 3, 4, 5, 1, 2, 6), 2, 6, 2},
                {Arrays.asList(0, 3, 4, 5, 1, 2, 6), 0, 6, 2},
                {Arrays.asList(0, 3, 4, 5, 1, 2, 6), 5, 6, 4},
                {Arrays.asList(0, 3, 4, 5, 1, 2, 6), 4, 6, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        int result = solution.distanceInTree(root, p, q);
        Assert.assertEquals(expected, result);
    }

}