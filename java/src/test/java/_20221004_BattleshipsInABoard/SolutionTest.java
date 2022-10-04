package _20221004_BattleshipsInABoard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public char[][] board;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new char[][]{
                        {'X', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', '.', '.', '.'},
                }, 2},
                {new char[][]{{'.'}}, 0},
                {new char[][]{
                        {'X', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', 'X', 'X', '.'},
                }, 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.countBattleships(board);
        Assert.assertEquals(expected, result);
    }

}