package _20220815_LargestNumber;

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
  public int[] nums;

  @Parameter(1)
  public String expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{10, 2}, "210"},
        {new int[]{3, 30, 34, 5, 9}, "9534330"},
        {new int[]{432, 43243}, "43243432"},
        {new int[]{33, 333, 3}, "333333"},
        {new int[]{0, 0}, "0"},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    String result = solution.largestNumber(nums);
    Assert.assertEquals(expected, result);
  }

}