package _20220824_HIndexII;

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
  public int[] citations;

  @Parameter(1)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{0, 1, 3, 5, 6}, 3},
        {new int[]{1, 2, 100}, 2},
        {new int[]{0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 6}, 4},
        {new int[]{0}, 0},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.hIndex(citations);
    Assert.assertEquals(expected, result);
  }

}