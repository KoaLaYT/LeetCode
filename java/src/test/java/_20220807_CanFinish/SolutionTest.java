package _20220807_CanFinish;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int numCourses;

    @Parameterized.Parameter(1)
    public int[][] prerequisites;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, new int[][]{{1, 0}}, true},
                {2, new int[][]{{1, 0}, {0, 1}}, false},
                {5, new int[][]{{0, 1}, {0, 2}, {3, 1}, {3, 4}, {1, 2}, {2, 4}}, true},
                {5, new int[][]{{0, 1}, {0, 2}, {3, 1}, {3, 4}, {1, 2}, {2, 4}, {4, 2}}, false},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.canFinish(numCourses, prerequisites);
        Assert.assertEquals(expected, result);
    }

}