package _20210921_RemoveDuplicatesFromSortedList;

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
    public TestCase testcase;

    @Parameters
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new int[]{1, 1, 2},
                        new int[]{1, 2}
                ),
                new TestCase(
                        new int[]{1, 1, 2, 3, 3},
                        new int[]{1, 2, 3}
                ),
                new TestCase(
                        new int[]{1, 1, 1, 1},
                        new int[]{1}
                ),
                new TestCase(
                        new int[]{},
                        new int[]{}
                )
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode result = solution.deleteDuplicates(testcase.head);
        testcase.assertEquals(result);
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