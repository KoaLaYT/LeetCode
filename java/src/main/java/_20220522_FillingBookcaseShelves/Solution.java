package _20220522_FillingBookcaseShelves;

public class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int width = 0;
            int height = 0;
            dp[i] = Integer.MAX_VALUE;

            int j = i;
            while (j < n) {
                width += books[j][0];
                if (width <= shelfWidth) {
                    height = Math.max(height, books[j][1]);
                    dp[i] = Math.min(dp[i], (j + 1 < n ? dp[j + 1] : 0) + height);
                    j++;
                } else {
                    break;
                }
            }
        }

        return dp[0];
    }

}
