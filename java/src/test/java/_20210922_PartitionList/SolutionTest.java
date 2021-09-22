package _20210922_PartitionList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-22
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
                        new int[]{1, 4, 3, 2, 5, 2},
                        3,
                        new int[]{1, 2, 2, 4, 3, 5}
                ),
                new TestCase(
                        new int[]{2, 1},
                        2,
                        new int[]{1, 2}
                ),
                new TestCase(
                        new int[]{4, 3, 2, 1},
                        2,
                        new int[]{1, 4, 3, 2}
                ),
                new TestCase(
                        new int[]{4, 3, 2, 1},
                        1,
                        new int[]{4, 3, 2, 1}
                ),
                new TestCase(
                        new int[]{1, 2, 3, 4},
                        1,
                        new int[]{1, 2, 3, 4}
                ),
                new TestCase(
                        new int[]{4, 3, 2, 3, 4},
                        3,
                        new int[]{2, 4, 3, 3, 4}
                )
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode result = solution.partition(testCase.head, testCase.x);
        testCase.assertEquals(result);
    }

    private static class TestCase {
        ListNode head;
        int x;
        ListNode expect;

        TestCase(int[] head, int x, int[] expect) {
            this.head = build(head);
            this.x = x;
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