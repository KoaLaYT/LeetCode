package _20220610_MaxProduct;

public class Solution {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(max, res);
        }

        return res;
    }

}
