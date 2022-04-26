package _20220426_SuperEggDrop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int k;

    @Parameterized.Parameter(1)
    public int n;

    @Parameterized.Parameter(2)
    public int expect;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, 2, 2},
                {2, 6, 3},
                {3, 14, 4},
                {4, 14, 4},
                {3, 100, 9},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.superEggDrop(k, n);
        Assert.assertEquals(expect, result);
    }

}