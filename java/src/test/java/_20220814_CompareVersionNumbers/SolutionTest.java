package _20220814_CompareVersionNumbers;

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
  public String version1;

  @Parameter(1)
  public String version2;

  @Parameter(2)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {"1.01", "1.001", 0},
        {"1.0", "1.0.0", 0},
        {"0.1", "1.1", -1},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.compareVersion(version1, version2);
    Assert.assertEquals(expected, result);
  }

}