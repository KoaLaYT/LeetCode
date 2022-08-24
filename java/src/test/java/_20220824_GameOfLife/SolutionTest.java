package _20220824_GameOfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public int[][] board;

  @Parameter(1)
  public int[][] expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {
            new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}},
            new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}}
        },
        {
            new int[][]{
                {1, 1},
                {1, 0}},
            new int[][]{
                {1, 1},
                {1, 1}}
        }
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    solution.gameOfLife(board);
    Assert.assertArrayEquals(expected, board);
  }

}