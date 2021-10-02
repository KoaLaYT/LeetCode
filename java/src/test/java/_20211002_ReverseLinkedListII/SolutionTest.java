package _20211002_ReverseLinkedListII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-10-02
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
                        new int[]{1, 2, 3, 4, 5},
                        2, 4,
                        new int[]{1, 4, 3, 2, 5}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        1, 4,
                        new int[]{4, 3, 2, 1, 5}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        1, 5,
                        new int[]{5, 4, 3, 2, 1}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4, 5},
                        1, 1,
                        new int[]{1, 2, 3, 4, 5}
                ),
                new TestCase(
                        new int[]{5},
                        1, 1,
                        new int[]{5}
                )
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        ListNode result = solution.reverseBetween(testcase.head, testcase.left, testcase.right);
        testcase.assertEquals(result);
    }

    private static class TestCase {
        ListNode head;
        ListNode expect;
        int left;
        int right;

        TestCase(int[] input, int left, int right, int[] expect) {
            this.head = build(input);
            this.expect = build(expect);
            this.left = left;
            this.right = right;
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