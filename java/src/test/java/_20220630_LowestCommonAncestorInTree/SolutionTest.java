package _20220630_LowestCommonAncestorInTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] childs;

    @Parameterized.Parameter(1)
    public int root;

    @Parameterized.Parameter(2)
    public int p;

    @Parameterized.Parameter(3)
    public int q;

    @Parameterized.Parameter(4)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2}, {3}, {4, 5}, {}, {6}, {}, {}}, 0, 3, 4, 0},
                {new int[][]{{1, 2}, {3}, {4, 5}, {}, {6}, {}, {}}, 0, 4, 5, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.lowestCommonAncestorInTree(childs, root, p, q);
        Assert.assertEquals(expected, result);
    }

}