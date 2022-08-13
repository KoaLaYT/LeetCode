package _20220813_GasStation;

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
  public int[] gas;

  @Parameter(1)
  public int[] cost;

  @Parameter(2)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3},
        {new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.canCompleteCircuit(gas, cost);
    Assert.assertEquals(expected, result);
  }

}