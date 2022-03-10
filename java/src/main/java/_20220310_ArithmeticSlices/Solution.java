package _20220310_ArithmeticSlices;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int result = 0;
        int add = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                result += ++add;
            } else {
                add = 0;
            }
        }

        return result;
    }

}
