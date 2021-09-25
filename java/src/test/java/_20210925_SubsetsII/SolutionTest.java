package _20210925_SubsetsII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author koalayt 2021-09-25
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameter(1)
    public List<List<Integer>> expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3, 3},
                        Arrays.asList(
                                Collections.emptyList(),
                                Arrays.asList(1),
                                Arrays.asList(2),
                                Arrays.asList(1, 2),
                                Arrays.asList(3),
                                Arrays.asList(1, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(3, 3),
                                Arrays.asList(1, 3, 3),
                                Arrays.asList(2, 3, 3),
                                Arrays.asList(1, 2, 3, 3)
                        )
                },
                {
                        new int[]{1, 2, 2},
                        Arrays.asList(
                                Collections.emptyList(),
                                Arrays.asList(1),
                                Arrays.asList(2),
                                Arrays.asList(1, 2),
                                Arrays.asList(2, 2),
                                Arrays.asList(1, 2, 2)
                        )
                },
                {
                        new int[]{0},
                        Arrays.asList(
                                Collections.emptyList(),
                                Arrays.asList(0)
                        )
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        Assert.assertEquals(expect.size(), result.size());
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertArrayEquals(expect.get(i).toArray(), result.get(i).toArray());
        }
    }

}