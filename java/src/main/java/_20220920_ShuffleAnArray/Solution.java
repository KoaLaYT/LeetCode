package _20220920_ShuffleAnArray;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return copy();
    }

    public int[] shuffle() {
        int[] copy = copy();
        for (int i = 0; i < nums.length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(nums.length);
            swap(copy, i, randomIndex);
        }
        return copy;
    }

    private int[] copy() {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        return copy;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
