package _20220301_ClimbingStairs;

import java.util.Arrays;

public class Solution {

    public int climbStairs(int n) {
        int[] memo = new int[46];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n <= 0) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int result = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        memo[n] = result;
        return result;
    }

}
