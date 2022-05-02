package _20220502_AllocateMailboxes;

import java.util.Arrays;

public class Solution {

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int len = houses.length;
        int[][] dp1 = new int[len][len]; // 在房子区间[i,j]中放置一个邮筒时，最小距离

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int p = i + (j - i) / 2;
                for (int a = i; a <= j; a++) {
                    dp1[i][j] += Math.abs(houses[a] - houses[p]);
                }
            }
        }

        int[][] dp2 = new int[len][k + 1]; // 在房子区间[0,i]中放置k邮筒时，最小距离
        for (int i = 0; i < len; i++) {
            dp2[i][1] = dp1[0][i];
        }

        for (int j = 1; j < len; j++) {
            for (int a = 2; a <= k; a++) {
                dp2[j][a] = Integer.MAX_VALUE;
                for (int i = j - 1; i >= 0; i--) {
                    dp2[j][a] = Math.min(dp2[j][a], dp2[i][a - 1] + dp1[i + 1][j]);
                }
            }
        }

        return dp2[len - 1][k];
    }

}
