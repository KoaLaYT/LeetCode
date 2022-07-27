package _20220727_FindKthLargest;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;

        while (i <= j) {
            if (nums[i] < pivot) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(nums, lo, j);

        if (j - lo + 1 == k) {
            return nums[j];
        }
        if (j - lo + 1 < k) {
            return findKthLargest(nums, j + 1, hi, k - j + lo - 1);
        }
        return findKthLargest(nums, lo, j - 1, k);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
