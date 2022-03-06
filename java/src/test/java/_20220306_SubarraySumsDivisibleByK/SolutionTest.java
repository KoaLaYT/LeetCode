package _20220306_SubarraySumsDivisibleByK;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() throws IOException {
        return new Object[][]{
                {new int[]{4, 5, 0, -2, -3, 1}, 5, 7},
                {new int[]{5}, 9, 0},
                {new int[]{2, -4, 2, -4}, 6, 2},
                {readFromFile("SubarraySumsDivisibleByK.txt"), 4141, 108696},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.subarraysDivByK(nums, k);
        Assert.assertEquals(expected, result);
    }

    private static int[] readFromFile(String file) throws IOException {
        InputStream inputStream = SolutionTest.class.getClassLoader().getResourceAsStream(file);
        String input = readFromInputStream(inputStream);
        String[] nums = input.split(",");
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Integer.parseInt(nums[i].trim());
        }
        return res;
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}