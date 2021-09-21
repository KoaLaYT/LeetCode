package _20210921_RemoveDuplicatesFromSortedListII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-21
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new int[]{1, 2, 3, 3, 4, 4, 5},
                        new int[]{1, 2, 5}
                ),
                new TestCase(
                        new int[]{1, 1, 1, 2, 3},
                        new int[]{2, 3}
                ),
                new TestCase(
                        new int[]{1, 1, 2, 2, 3, 4, 4},
                        new int[]{3}
                ),
                new TestCase(
                        new int[]{1, 1, 2, 2, 4, 4, 5},
                        new int[]{5}
                ),
                new TestCase(
                        new int[]{1, 1, 2, 2, 4, 4, 4},
                        new int[]{}
                ),
                new TestCase(
                        new int[]{0, 1, 1, 2, 2, 4, 4, 4},
                        new int[]{0}
                )
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode result = solution.deleteDuplicates(testCase.head);
        testCase.assertEquals(result);
    }

    private static class TestCase {
        ListNode head;
        ListNode expect;

        TestCase(int[] input, int[] expect) {
            this.head = build(input);
            this.expect = build(expect);
        }

        ListNode build(int[] list) {
            ListNode node = null;
            for (int i = list.length - 1; i >= 0; i--) {
                node = new ListNode(list[i], node);
            }
            return node;
        }

        void assertEquals(ListNode result) {
            ListNode expectHead = expect;
            ListNode resultHead = result;

            while (expectHead != null && resultHead != null) {
                Assert.assertEquals(expectHead.val, resultHead.val);
                expectHead = expectHead.next;
                resultHead = resultHead.next;
            }

            Assert.assertNull(expectHead);
            Assert.assertNull(resultHead);
        }
    }

}