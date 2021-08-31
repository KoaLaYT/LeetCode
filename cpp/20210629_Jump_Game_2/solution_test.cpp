#include "solution.hpp"
#include <gtest/gtest.h>

struct Case {
    std::vector<int> nums;
    int              expected;
};

TEST(jump_game, basic)
{
    std::vector<Case> cases{
        {{2, 3, 1, 1, 4}, 2},
        {{2, 3, 0, 1, 4}, 2},
        {{2, 1, 1, 1, 3}, 3},
        {{2, 0, 1, 1, 3}, 3},
        {{1, 1, 0}, 2},
        {{0}, 0},
        {{1}, 0},
        {{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}, 5},
        {{9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5}, 3},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.jump(c.nums);
        EXPECT_EQ(c.expected, result);
    }
}

/*

9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5
3  3  6  5 -1  4  3 -1  2  3  2  2  1  1  1 -1  1  1 -1   

*/