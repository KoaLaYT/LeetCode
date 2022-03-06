package _20220305_MaximumLengthOfSubarrayWithPostiveProduct;

public class Solution {

    public int getMaxLen(int[] nums) {
        int pos = 0;
        int neg = 0;
        int res = 0;

        for (int num : nums) {
            if (num == 0) {
                pos = 0;
                neg = 0;
            } else if (num > 0) {
                pos++;
                if (neg > 0) {
                    neg++;
                }
                res = Math.max(res, pos);
            } else {
                int tmp = pos;
                pos = neg;
                neg = tmp;
                neg++;
                if (pos > 0) {
                    pos++;
                }
                res = Math.max(res, pos);
            }
        }

        return res;
    }

}
