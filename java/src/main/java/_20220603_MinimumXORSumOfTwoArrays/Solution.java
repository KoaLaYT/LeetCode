package _20220603_MinimumXORSumOfTwoArrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int used = 0;
        Map<Integer, Integer> memo = new HashMap<>();

        return minimumXORSum(nums1, nums2, 0, used, memo);
    }

    private int minimumXORSum(int[] nums1, int[] nums2, int i, int used, Map<Integer, Integer> memo) {
        if (i >= nums1.length) {
            return 0;
        }

        int key = (i << 14) | used;
        if (!memo.containsKey(key)) {
            int sum = Integer.MAX_VALUE;
            for (int j = 0; j < nums2.length; j++) {
                boolean isUsed = (used & (1 << j)) > 0;
                if (isUsed) continue;
                int res = nums1[i] ^ nums2[j];
                if (res < sum) {
                    sum = Math.min(sum, res + minimumXORSum(nums1, nums2, i + 1, used | (1 << j), memo));
                }
            }
            memo.put(key, sum);
        }

        return memo.get(key);
    }

}
