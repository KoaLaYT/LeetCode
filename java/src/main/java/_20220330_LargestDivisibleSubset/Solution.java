package _20220330_LargestDivisibleSubset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > dp[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        int max = nums[maxIndex];
        int index = dp[maxIndex];
        result.add(max);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (max % nums[i] == 0 && dp[i] == index - 1) {
                result.addFirst(nums[i]);
                max = nums[i];
                index = dp[i];
            }
        }

        return result;
    }

}
