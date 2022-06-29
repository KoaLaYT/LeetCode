package _20220629_LevelOrder;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public List<Integer> input;

    @Parameterized.Parameter(1)
    public List<List<Integer>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        Arrays.asList(3, 9, 20, null, null, 15, 7),
                        Arrays.asList(
                                Arrays.asList(3),
                                Arrays.asList(9, 20),
                                Arrays.asList(15, 7)
                        )
                },
                {
                        Arrays.asList(1),
                        Arrays.asList(
                                Arrays.asList(1)
                        )
                },
                {
                        Collections.emptyList(),
                        Collections.emptyList()
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = Utils.buildTree(input);
        List<List<Integer>> result = solution.levelOrder(root);
        Assert.assertEquals(expected, result);
    }

}