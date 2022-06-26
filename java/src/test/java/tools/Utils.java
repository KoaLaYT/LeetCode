package tools;

import common.ListNode;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    private Utils() {
    }

    public static String readFromFile(String file) {
        InputStream   inputStream = Utils.class.getClassLoader().getResourceAsStream(file);
        StringBuilder sb          = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static int[] readIntArrayFromFile(String file) {
        String   input = Utils.readFromFile(file);
        String[] nums  = input.split(",");
        int[]    res   = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Integer.parseInt(nums[i].trim());
        }
        return res;
    }

    public static ListNode buildList(int[] input) {
        ListNode head = null;
        for (int i = input.length - 1; i >= 0; i--) {
            head = new ListNode(input[i], head);
        }
        return head;
    }

    public static Pair<ListNode> buildCycleList(int[] input, int crossIndex) {
        ListNode head = buildList(input);
        if (crossIndex < 0) {
            return new Pair<>(head, null);
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        ListNode crossNode = head;
        while (crossIndex > 0) {
            crossNode = crossNode.next;
            crossIndex--;
        }
        last.next = crossNode;
        return new Pair<>(head, crossNode);
    }

    public static void assertListEquals(int[] expected, ListNode result) {
        int      i   = 0;
        ListNode cur = result;
        while (i < expected.length && cur != null) {
            Assert.assertEquals(expected[i], cur.val);
            cur = cur.next;
            i++;
        }
        Assert.assertEquals(i, expected.length);
        Assert.assertNull(cur);
    }

    public static class Pair<T> {
        public T left;
        public T right;

        Pair(T left, T right) {
            this.left  = left;
            this.right = right;
        }
    }

}
