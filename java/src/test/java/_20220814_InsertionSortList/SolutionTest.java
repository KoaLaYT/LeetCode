package _20220814_InsertionSortList;

import common.ListNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import tools.Utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public int[] input;

  @Parameter(1)
  public int[] expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new int[]{4, 2, 1, 3}, new int[]{1, 2, 3, 4}},
        {new int[]{-1, 5, 3, 4, 0}, new int[]{-1, 0, 3, 4, 5}},
        {new int[]{1}, new int[]{1}},
        {new int[]{1, 1}, new int[]{1, 1}},
        random(100),
        random(500),
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    ListNode head = Utils.buildList(input);
    ListNode result = solution.insertionSortList(head);
    Utils.assertListEquals(expected, result);
  }

  private static Object[] random(int size) {
    int[] arr = IntStream.range(0, size).toArray();
    for (int i = 0; i < size; i++) {
      int randomIndex = ThreadLocalRandom.current().nextInt(size);
      swap(arr, i, randomIndex);
    }
    return new Object[]{
        arr,
        IntStream.range(0, size).toArray()
    };
  }

  private static void swap(int[] arr, int i, int j) {
    if (i != j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
  }

}