package _20220607_FindPermutation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"I", new int[]{1, 2}},
                {"DI", new int[]{2, 1, 3}},
                {"DIDI", new int[]{2, 1, 4, 3, 5}},
                {"DDII", new int[]{3, 2, 1, 4, 5}},
                {"IIDDIIID", new int[]{1, 2, 5, 4, 3, 6, 7, 9, 8}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.findPermutation(s);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(expected, result);
    }

}