package _20220426_EggDropWith2EggsAndNFloors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public int expect;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, 2},
                {100, 14},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.twoEggDrop(n);
        Assert.assertEquals(expect, result);
    }

}