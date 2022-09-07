package _20220907_HouseRobberIII;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import tools.Utils;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public List<Integer> input;

  @Parameter(1)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {Arrays.asList(3, 2, 3, null, 3, null, 1), 7},
        {Arrays.asList(3, 4, 5, 1, 3, null, 1), 9},
        {Arrays.asList(3, 7, 5, 1, 2, 5, 1), 13},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    TreeNode root = Utils.buildTree(input);
    int result = solution.rob(root);
    Assert.assertEquals(expected, result);
  }

}