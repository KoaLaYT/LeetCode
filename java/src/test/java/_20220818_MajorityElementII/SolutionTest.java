package _20220818_MajorityElementII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public int[] nums;

  @Parameter(1)
  public List<Integer> expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{3, 2, 3}, Arrays.asList(3)},
        {new int[]{1}, Arrays.asList(1)},
        {new int[]{1, 2}, Arrays.asList(1, 2)},
        {new int[]{1, 2, 3}, Arrays.asList()},
        {new int[]{2, 2}, Arrays.asList(2)},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    List<Integer> result = solution.majorityElement(nums);
    Assert.assertEquals(expected, result);
  }

}