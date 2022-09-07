package _20220907_IncreasingTripletSubsequence;

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
  public boolean expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{1, 2, 3, 4, 5}, true},
        {new int[]{5, 4, 3, 2, 1}, false},
        {new int[]{2, 1, 5, 0, 4, 6}, true},
        {new int[]{20, 100, 10, 12, 5, 13}, true},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    boolean result = solution.increasingTriplet(nums);
    Assert.assertEquals(expected, result);
  }

}