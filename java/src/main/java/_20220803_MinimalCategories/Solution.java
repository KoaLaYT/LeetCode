package _20220803_MinimalCategories;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int minimal_categories(int[] coins, int amount) {
        Set<Integer>[][] dp = new HashSet[coins.length + 1][amount + 1];
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = new HashSet<>();
        }

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int k = 1; k <= amount; k++) {
                int cats = Integer.MAX_VALUE;
                Set<Integer> set = null;
                if (k >= coin && dp[i][k - coin] != null) {
                    set = new HashSet<>();
                    set.addAll(dp[i][k - coin]);
                    set.add(coin);
                    cats = set.size();
                }
                if (dp[i - 1][k] != null && dp[i - 1][k].size() < cats) {
                    set = dp[i - 1][k];
                }
                dp[i][k] = set;
            }
        }

        Set<Integer> res = dp[coins.length][amount];
        return res == null ? -1 : res.size();
    }

}
