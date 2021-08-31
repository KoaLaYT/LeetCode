#include "solution.hpp"
#include <gtest/gtest.h>

struct Case {
    std::vector<int>              candidates;
    int                           target;
    std::vector<std::vector<int>> expect;
};

TEST(combination_sum_2, basic)
{
    std::vector<Case> cases{
        {{10, 1, 2, 7, 6, 1, 5}, 8, {{{1, 1, 6}, {1, 2, 5}, {1, 7}, {2, 6}}}},
        {{2, 5, 2, 1, 2}, 5, {{1, 2, 2}, {5}}},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.combinationSum2(c.candidates, c.target);

        ASSERT_EQ(c.expect.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            EXPECT_EQ(c.expect[i], result[i]);
        }
    }
}