package _20210906_RotateList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Objects;

/**
 * @author koalayt 2021-09-06
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase:{index}")
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        1,
                        new int[]{5, 1, 2, 3, 4}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        2,
                        new int[]{4, 5, 1, 2, 3}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        3,
                        new int[]{3, 4, 5, 1, 2}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        4,
                        new int[]{2, 3, 4, 5, 1}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        5,
                        new int[]{1, 2, 3, 4, 5}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        6,
                        new int[]{5, 1, 2, 3, 4}
                ),
                new TestCase(
                        new int[]{0, 1, 2},
                        4,
                        new int[]{2, 0, 1}
                ),
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode result = solution.rotateRight(testCase.head, testCase.k);
        Assert.assertTrue(print(result), testCase.isSame(result));
    }

    private static String print(ListNode list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (Objects.nonNull(list)) {
            sb.append(String.format("%d,", list.val));
            list = list.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static class TestCase {
        ListNode head;
        int k;
        ListNode expect;

        public TestCase(int[] input, int k, int[] expect) {
            this.head = buildList(input);
            this.k = k;
            this.expect = buildList(expect);
        }

        private ListNode buildList(int[] input) {
            ListNode node = null;
            for (int i = input.length - 1; i >= 0; i--) {
                node = new ListNode(input[i], node);
            }
            return node;
        }

        public boolean isSame(ListNode result) {
            ListNode test = expect;
            while (true) {
                if (Objects.isNull(result) && Objects.isNull(test)) {
                    return true;
                }

                if (Objects.isNull(result) || Objects.isNull(test)) {
                    return false;
                }

                if (result.val != test.val) {
                    return false;
                }

                result = result.next;
                test = test.next;
            }
        }
    }

}