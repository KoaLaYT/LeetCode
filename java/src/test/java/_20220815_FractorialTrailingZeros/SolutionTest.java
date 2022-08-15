package _20220815_FractorialTrailingZeros;

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
  public int n;

  @Parameter(1)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {3, 0},
        {5, 1},
        {0, 0},
        {10, 2},
        {20, 4},
        {30, 7},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.trailingZeroes(n);
    Assert.assertEquals(expected, result);
  }

}