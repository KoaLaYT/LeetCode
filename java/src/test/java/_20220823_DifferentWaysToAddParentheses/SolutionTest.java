package _20220823_DifferentWaysToAddParentheses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public String expression;

  @Parameter(1)
  public List<Integer> expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {"2-1-1", Arrays.asList(0, 2)},
        {"2*3-4*5", Arrays.asList(-34, -14, -10, -10, 10)},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    List<Integer> result = solution.diffWaysToCompute(expression);
    result.sort(Comparator.comparingInt(Integer::intValue));
    expected.sort(Comparator.comparingInt(Integer::intValue));
    Assert.assertEquals(expected, result);
  }

}