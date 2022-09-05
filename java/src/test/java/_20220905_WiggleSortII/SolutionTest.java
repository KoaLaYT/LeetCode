package _20220905_WiggleSortII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.ThreadLocalRandom;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 5, 1, 1, 6, 4}},
                {new int[]{1, 3, 2, 2, 3, 1}},
                {new int[]{1, 3, 4}},
                {random(99)},
                {random(100)},
                {new int[]{4, 5, 5, 6}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.wiggleSort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            Assert.assertTrue(nums[i] > nums[i - 1]);
            if (i + 1 < nums.length) {
                Assert.assertTrue(nums[i] > nums[i + 1]);
            }
        }
    }

    private static int[] random(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < size; i++) {
            int index = ThreadLocalRandom.current().nextInt(size);
            swap(arr, i, index);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}