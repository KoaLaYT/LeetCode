package _20220814_FractionToRecurringDecimal;

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
  public int numerator;

  @Parameter(1)
  public int denominator;

  @Parameter(2)
  public String expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {1, 2, "0.5"},
        {2, 1, "2"},
        {4, 333, "0.(012)"},
        {1, 7, "0.(142857)"},
        {1, 8, "0.125"},
        {0, 10, "0"},
        {-1, 2, "-0.5"},
        {-1, -2, "0.5"},
        {1, -2, "-0.5"},
        {-1, 7, "-0.(142857)"},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals(expected, result);
  }

}