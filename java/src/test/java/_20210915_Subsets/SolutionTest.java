package _20210915_Subsets;

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
 * @author koalayt 2021-09-15
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
                        new int[]{1, 2, 3},
                        Arrays.asList(
                                Collections.emptyList(),
                                Collections.singletonList(1),
                                Collections.singletonList(2),
                                Collections.singletonList(3),
                                Arrays.asList(1, 2),
                                Arrays.asList(1, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(1, 2, 3)
                        )
                },
                {
                        new int[]{0},
                        Arrays.asList(
                                Collections.emptyList(),
                                Collections.singletonList(0)
                        )
                },
                {
                        new int[]{1, 2, 3, 4, 5},
                        Arrays.asList(
                                Collections.emptyList(),
                                Collections.singletonList(1),
                                Collections.singletonList(2),
                                Collections.singletonList(3),
                                Collections.singletonList(4),
                                Collections.singletonList(5),
                                Arrays.asList(1, 2),
                                Arrays.asList(1, 3),
                                Arrays.asList(1, 4),
                                Arrays.asList(1, 5),
                                Arrays.asList(2, 3),
                                Arrays.asList(2, 4),
                                Arrays.asList(2, 5),
                                Arrays.asList(3, 4),
                                Arrays.asList(3, 5),
                                Arrays.asList(4, 5),
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(1, 2, 4),
                                Arrays.asList(1, 2, 5),
                                Arrays.asList(1, 3, 4),
                                Arrays.asList(1, 3, 5),
                                Arrays.asList(1, 4, 5),
                                Arrays.asList(2, 3, 4),
                                Arrays.asList(2, 3, 5),
                                Arrays.asList(2, 4, 5),
                                Arrays.asList(3, 4, 5),
                                Arrays.asList(1, 2, 3, 4),
                                Arrays.asList(1, 2, 3, 5),
                                Arrays.asList(1, 2, 4, 5),
                                Arrays.asList(1, 3, 4, 5),
                                Arrays.asList(2, 3, 4, 5),
                                Arrays.asList(1, 2, 3, 4, 5)
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
        List<List<Integer>> result = solution.subsets(nums);
        Assert.assertEquals(expect.size(), result.size());
        for (int i = 0; i < expect.size(); i++) {
            Assert.assertEquals(expect.get(i), result.get(i));
        }
    }

}