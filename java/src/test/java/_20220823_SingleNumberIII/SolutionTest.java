package _20220823_SingleNumberIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public int[] nums;

  @Parameter(1)
  public int[] expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{1, 2, 1, 3, 2, 5}, new int[]{3, 5}},
        {new int[]{-1, 0}, new int[]{-1, 0}},
        {new int[]{0, 1}, new int[]{0, 1}},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int[] result = solution.singleNumber(nums);
    Arrays.sort(result);
    Assert.assertArrayEquals(expected, result);
  }

}