#include "solution.hpp"
#include <gtest/gtest.h>

struct Case {
    std::vector<int>              candidates;
    int                           target;
    std::vector<std::vector<int>> expect;
};

TEST(combination_sum, basic)
{
    std::vector<Case> cases{
        {{2, 3, 4, 7}, 7, {{7}, {3, 4}, {2, 2, 3}}},
        {{2, 3, 5}, 8, {{3, 5}, {2, 3, 3}, {2, 2, 2, 2}}},
        {{2}, 1, {}},
        {{1}, 1, {{1}}},
        {{1}, 2, {{1, 1}}},
        {{2, 3, 4, 5, 6}, 8, {{2, 6}, {3, 5}, {4, 4}, {2, 2, 4}, {2, 3, 3}, {2, 2, 2, 2}}},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.combinationSum(c.candidates, c.target);
        ASSERT_EQ(c.expect.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            EXPECT_EQ(c.expect[i], result[i]);
        }
    }
}