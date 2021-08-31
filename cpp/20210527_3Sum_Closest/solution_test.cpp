#include "solution.hpp"
#include <gtest/gtest.h>

TEST(Test3Sum_Closest, basic)
{
    struct Case {
        std::vector<int> nums;
        int              target;
        int              expect;
    };

    std::vector<Case> cases{
        {{-1, 2, 1, -4}, 1, 2},
        {{-1, 2, 1, -4}, 0, -1},
        {{-1, 2, 1, -4}, -1, -1},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.threeSumClosest(c.nums, c.target);
        EXPECT_EQ(result, c.expect);
    }
}