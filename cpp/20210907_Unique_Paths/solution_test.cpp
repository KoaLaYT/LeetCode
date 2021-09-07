#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct TestCase {
    int m;
    int n;
    int expect;
};

TEST(unique_paths, basic)
{
    std::vector<TestCase> cases{
        {3, 7, 28},
        {3, 2, 3},
        {7, 3, 28},
        {3, 3, 6},
        {4, 2, 4},
        {4, 3, 10},
        {4, 4, 20},
        {23, 12, 193536720},
        {1, 1, 1},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.uniquePaths(c.m, c.n);
        EXPECT_EQ(c.expect, result);
    }
}