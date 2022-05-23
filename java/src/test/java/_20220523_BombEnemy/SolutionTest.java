package _20220523_BombEnemy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public char[][] grid;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new char[][]{
                        {'0', 'E', '0', '0'},
                        {'E', '0', 'W', 'E'},
                        {'0', 'E', '0', '0'}},
                        3},
                {new char[][]{
                        {'W', 'W', 'W'},
                        {'0', '0', '0'},
                        {'E', 'E', 'E'}},
                        1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxKilledEnemies(grid);
        Assert.assertEquals(expected, result);
    }

}