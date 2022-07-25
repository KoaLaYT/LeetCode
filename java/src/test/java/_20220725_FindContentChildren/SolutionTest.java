package _20220725_FindContentChildren;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] g;

    @Parameterized.Parameter(1)
    public int[] s;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3}, new int[]{1, 1}, 1},
                {new int[]{1, 2}, new int[]{1, 2, 3}, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findContentChildren(g, s);
        Assert.assertEquals(expected, result);
    }

}