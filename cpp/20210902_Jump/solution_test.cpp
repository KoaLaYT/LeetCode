#include "solution.hpp"
#include <gtest/gtest.h>

struct TestCase {
    std::vector<int> inputs;
    bool             expect;
};

TEST(jump_game, basic)
{
    std::vector<TestCase> cases{
        {{2, 3, 1, 1, 4}, true},
        {{3, 2, 1, 0, 4}, false},
        {{2, 0}, true},
    };

    Solution s;
    for (auto c : cases) {
        bool result = s.canJump(c.inputs);
        EXPECT_EQ(c.expect, result);
    }
}