#include "solution.hpp"
#include <gtest/gtest.h>

struct Case {
    std::vector<int> nums;
    std::vector<int> expect;
};

TEST(next_permutation, basic)
{
    std::vector<Case> cases{
        {{1, 2, 3}, {1, 3, 2}},
        {{3, 2, 1}, {1, 2, 3}},
        {{1, 1, 5}, {1, 5, 1}},
        {{1}, {1}},
        {{}, {}},
        {{1, 2, 3, 4}, {1, 2, 4, 3}},
        {{1, 4, 3, 2}, {2, 1, 3, 4}},
        {{1, 5, 1}, {5, 1, 1}},
        {{1, 5, 1, 1}, {5, 1, 1, 1}},
        {{1, 1, 5, 1}, {1, 5, 1, 1}},
    };

    Solution s;
    for (auto& c : cases) {
        s.nextPermutation(c.nums);
        EXPECT_TRUE(c.nums == c.expect);
    }
}