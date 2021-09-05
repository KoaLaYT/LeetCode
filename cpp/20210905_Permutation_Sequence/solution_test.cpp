#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct TestCase {
    int         n;
    int         k;
    std::string expect;
};

TEST(permutation_sequence, basic)
{
    std::vector<TestCase> cases{
        {3, 3, "213"},
        {4, 9, "2314"},
        {3, 1, "123"},
        {5, 21, "15324"},
        {5, 24, "15432"},
        {5, 18, "14532"},
        {5, 1, "12345"},
        {5, 2, "12354"},
        {5, 89, "43512"},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.getPermutation(c.n, c.k);
        EXPECT_EQ(c.expect, result);
    }
}