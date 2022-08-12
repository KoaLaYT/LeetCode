package _20220812_SurrounedRegions;

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
    public char[][] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'X'},
                                {'X', 'O', 'X', 'X'},
                        },
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'X', 'X'},
                        }
                },
                {
                        new char[][]{{'X'}},
                        new char[][]{{'X'}}
                },
                {
                        new char[][]{
                                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                                {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'},
                        },
                        new char[][]{
                                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                                {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'},
                        }
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.solve(board);
        Assert.assertEquals(expected, board);
    }

}