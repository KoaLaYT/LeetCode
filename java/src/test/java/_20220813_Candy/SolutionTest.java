package _20220813_Candy;

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
  public int[] ratings;

  @Parameter(1)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{1, 0, 2}, 5},
        {new int[]{1, 2, 2}, 4},
        {new int[]{1, 0, 2, 2, 3}, 8},
        {new int[]{10, 9, 8, 7, 6, 0}, 21},
        {new int[]{3, 2, 3, 2, 1, 2}, 11},
        {new int[]{0, 0, 0}, 3},
        {new int[]{0, 0, 0, 1}, 5},
        {new int[]{0, 0, 0, 1, 1, 1}, 7},
        {new int[]{1, 3, 2, 2, 1}, 7},
        {new int[]{1, 6, 10, 8, 7, 3, 2}, 18},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.candy(ratings);
    Assert.assertEquals(expected, result);
  }

}