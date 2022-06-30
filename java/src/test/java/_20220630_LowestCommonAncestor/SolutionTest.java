package _20220630_LowestCommonAncestor;

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
                {Arrays.asList(3,5,1,6,2,0,8,null,null,7,4), 5, 1, 3},
                {Arrays.asList(3,5,1,6,2,0,8,null,null,7,4), 5, 4, 5},
                {Arrays.asList(1, 2), 1, 2, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode[] nodes = Utils.buildTree(input, p, q, expected);
        TreeNode root = nodes[0];
        TreeNode pNode = nodes[1];
        TreeNode qNode = nodes[2];
        TreeNode expectedNode = nodes[3];
        TreeNode node = solution.lowestCommonAncestor(root, pNode, qNode);
        Assert.assertEquals(expectedNode, node);
    }

}