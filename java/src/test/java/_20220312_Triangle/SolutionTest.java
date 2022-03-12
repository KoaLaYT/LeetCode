package _20220312_Triangle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public List<List<Integer>> triangle;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {fromArray(new int[][]{
                        {2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}
                }), 11},
                {fromArray(new int[][]{{-10}}), -10},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minimumTotal(triangle);
        Assert.assertEquals(expected, result);
    }

    private static List<List<Integer>> fromArray(int[][] triangle) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] ints : triangle) {
            List<Integer> row = new ArrayList<>();
            for (int anInt : ints) {
                row.add(anInt);
            }
            result.add(row);
        }
        return result;
    }

}