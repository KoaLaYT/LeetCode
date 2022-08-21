package _20220821_ProductOfArrayExceptSelf;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] * left[i - 1];
        }


        int right = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            left[i] = left[i - 1] * right;
            right *= nums[i];
        }
        left[0] = right;

        return left;
    }

}
