#include "solution.hpp"

#include <vector>

int Solution::minDistance(std::string word1, std::string word2)
{
    int m = word1.size();
    int n = word2.size();

    if (m * n == 0) {
        return m + n;
    }

    std::vector<std::vector<int>> dp(m + 1, std::vector<int>(n + 1, 0));

    for (int i = 0; i < m + 1; i++) {
        dp[i][0] = i;
    }

    for (int i = 0; i < n + 1; i++) {
        dp[0][i] = i;
    }

    for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
            int left = dp[i][j - 1] + 1;
            int down = dp[i - 1][j] + 1;
            int left_down = dp[i - 1][j - 1];
            // if last charactor is not equal
            // add a replace operation
            if (word1[i - 1] != word2[j - 1]) {
                left_down += 1;
            }
            dp[i][j] = std::min({left, down, left_down});
        }
    }

    return dp[m][n];
}