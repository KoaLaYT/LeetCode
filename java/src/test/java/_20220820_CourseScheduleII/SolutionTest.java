package _20220820_CourseScheduleII;

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
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, new int[][]{{1, 0}}, new int[]{0, 1}},
                {4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, new int[]{0, 1, 2, 3}},
                {1, new int[][]{}, new int[]{0}}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.findOrder(numCourses, prerequisites);
        Assert.assertArrayEquals(expected, result);
    }

}