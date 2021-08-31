#include "solution.hpp"
#include <gtest/gtest.h>

TEST(four_sum, basic)
{
    struct Case {
        std::vector<int>              nums;
        int                           target;
        std::vector<std::vector<int>> expect;
    };

    std::vector<Case> cases{
        {
            {1, 0, -1, 0, -2, 2},
            0,
            {{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}},
        },
        {
            {2, 2, 2, 2, 2},
            8,
            {{2, 2, 2, 2}},
        },
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.fourSum(c.nums, c.target);
        ASSERT_EQ(result.size(), c.expect.size());
        for (int i = 0; i < result.size(); i++) {
            EXPECT_EQ(result[i], c.expect[i]);
        }
    }
}