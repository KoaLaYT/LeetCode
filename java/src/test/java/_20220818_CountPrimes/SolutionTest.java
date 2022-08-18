package _20220818_CountPrimes;

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
        {10, 4},
        {1, 0},
        {0, 0},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.countPrimes(n);
    Assert.assertEquals(expected, result);
  }

}