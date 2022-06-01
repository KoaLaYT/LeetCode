package _20220601_StoneGameIII;

public class Solution {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dpA = new int[n + 3];
        int[] dpB = new int[n + 3];

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            dpA[i] = Integer.MIN_VALUE;
            dpB[i] = Integer.MAX_VALUE;

            sum += stoneValue[i];
            dpA[i] = Math.max(dpA[i], dpB[i + 1] + sum);
            dpB[i] = Math.min(dpB[i], dpA[i + 1] - sum);

            if (i + 1 >= n) continue;
            sum += stoneValue[i + 1];
            dpA[i] = Math.max(dpA[i], dpB[i + 2] + sum);
            dpB[i] = Math.min(dpB[i], dpA[i + 2] - sum);

            if (i + 2 >= n) continue;
            sum += stoneValue[i + 2];
            dpA[i] = Math.max(dpA[i], dpB[i + 3] + sum);
            dpB[i] = Math.min(dpB[i], dpA[i + 3] - sum);
        }

        if (dpA[0] == 0) {
            return "Tie";
        } else if (dpA[0] > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

}
