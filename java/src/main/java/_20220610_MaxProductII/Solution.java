package _20220610_MaxProductII;

public class Solution {

    public double maxProductII(double[] nums) {
        double preMax = nums[0];
        double max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax * nums[i], nums[i]);
            max = Math.max(max, preMax);
        }

        return max;
    }

}
