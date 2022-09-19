package _20220919_LinkedListRandomNode;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameter
    public int[] inputs;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3}}
        };
    }

    @Test
    public void test() {
        ListNode head = Utils.buildList(inputs);
        Solution solution = new Solution(head);
        for (int i = 0; i < inputs.length; i++) {
            int random = solution.getRandom();
            Assert.assertTrue(Arrays.stream(inputs).anyMatch(ele -> ele == random));
        }
    }

}