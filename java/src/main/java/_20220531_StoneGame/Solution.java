package _20220531_StoneGame;

public class Solution {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        return stoneGame(piles, 0, piles.length - 1, memo) > 0;
    }

    private int stoneGame(int[] piles, int a, int b, int[][] memo) {
        if (a >= b) {
            return 0;
        }

        if (memo[a][b] == 0) {
            int diff = 0;
            // 1. Alice pick a, Bob pick b
            diff = Math.max(diff, stoneGame(piles, a + 1, b - 1, memo) + piles[a] - piles[b]);
            // 2. Alice pick a, Bob pick a+1
            diff = Math.max(diff, stoneGame(piles, a + 2, b, memo) + piles[a] - piles[a + 1]);
            // 3. Alice pick b, Bob pick a
            diff = Math.max(diff, stoneGame(piles, a + 1, b - 1, memo) + piles[b] - piles[a]);
            // 4. Alice pick b, Bob pick b-1
            diff = Math.max(diff, stoneGame(piles, a, b - 2, memo) + piles[b] - piles[b - 1]);

            memo[a][b] = diff;
        }

        return memo[a][b];
    }

}
