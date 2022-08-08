package _202210808_MedianOfTwoSortedArrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArrays(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArrays(nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 0) {
            return (getKthElement(nums1, nums2, (m + n) / 2) + getKthElement(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
        } else {
            return getKthElement(nums1, nums2, (m + n) / 2 + 1);
        }
    }

    private double findMedianSortedArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0.0;
        }
        int len = nums.length;
        if (len % 2 == 0) {
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        } else {
            return nums[len / 2];
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0;

        while (true) {
            if (i >= m) {
                return nums2[j + k - 1];
            }
            if (j >= n) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            int p = k / 2;
            int p1 = Math.min(i + p, m) - 1;
            int p2 = Math.min(j + p, n) - 1;
            if (nums1[p1] <= nums2[p2]) {
                k -= (p1 - i + 1);
                i = p1 + 1;
            } else {
                k -= (p2 - j + 1);
                j = p2 + 1;
            }
        }
    }

}
