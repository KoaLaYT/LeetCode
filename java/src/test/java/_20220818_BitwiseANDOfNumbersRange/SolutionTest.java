package _20220818_BitwiseANDOfNumbersRange;

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
  public int left;

  @Parameter(1)
  public int right;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {5, 7},
        {0, 0},
        {1, Integer.MAX_VALUE},
        {500, 600},
        {675, 704},
        {100, 1000},
        {100, 101},
        {10, 20},
        {3, 3},
        {2147483646, 2147483647},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.rangeBitwiseAnd(left, right);
    int expected = calculate();
    Assert.assertEquals(expected, result);
  }

  private int calculate() {
    int res = left;
    for (int i = left + 1; i >= 0 && i <= right; i++) {
      res &= i;
      if (res == 0) {
        return res;
      }
    }
    return res;
  }

}