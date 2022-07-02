package _20220702_IsLegalHeap;

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
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {Arrays.asList(99, 93, 71, 47, 47, 23, 20, 33, 30, 27), true},
                {Arrays.asList(90, 63, 47, 9, 90, null, null, null, null, null, 91), false},
                {Arrays.asList(30), true},
                {Arrays.asList(67, 7, 10, null, null, 23, 18), false},
                {Arrays.asList(50, 89, null, null, 36), false},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        boolean result = solution.isLegalHeap(root);
        Assert.assertEquals(expected, result);
    }

}