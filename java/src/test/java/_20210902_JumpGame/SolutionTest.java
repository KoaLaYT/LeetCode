package _20210902_JumpGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author koalayt 2021-09-02
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase{index}")
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(new int[]{3, 2, 1, 0, 4}, false),
                new TestCase(new int[]{2, 3, 1, 1, 4}, true),
                new TestCase(new int[]{3, 2, 2, 0, 4}, true),
                new TestCase(new int[]{3, 0, 0, 0, 0, 0, 1}, false),
                new TestCase(new int[]{2, 0}, true),
                new TestCase("JumpGame.txt", false),
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.canJump(testCase.inputs);
        Assert.assertEquals(testCase.expect, result);
    }

    public static class TestCase {
        int[] inputs;
        boolean expect;

        public TestCase(int[] inputs, boolean expect) {
            this.inputs = inputs;
            this.expect = expect;
        }

        public TestCase(String fileName, boolean expect) {
            this.inputs = readNumFromFile(fileName);
            this.expect = expect;
        }

        private int[] readNumFromFile(String fileName) {
            try {
                URL file = getClass().getClassLoader().getResource(fileName);
                String line = new String(Files.readAllBytes(Path.of(file.toURI())));
                String[] nums = line.split(",");

                int[] array = new int[nums.length];

                for (int i = 0; i < nums.length; i++) {
                    array[i] = Integer.parseInt(nums[i].strip());
                }

                return array;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new int[]{};
        }
    }

}