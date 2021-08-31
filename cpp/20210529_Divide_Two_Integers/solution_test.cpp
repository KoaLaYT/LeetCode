#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct Case {
    int dividend;
    int divisor;
    int expect;
};

TEST(divide_two_integers, basic)
{
    std::vector<Case> cases{
        {10, 3, 3},
        {7, -3, -2},
        {0, 1, 0},
        {1, 1, 1},
        {-10, -3, 3},
        {-10, 3, -3},
        {-2147483648, -1, 2147483647},
        {-2147483648, 1, -2147483648},
        {-2147483648, 2, -1073741824},
        {-2147483648, -2147483648, 1},
        {-2147483647, -2147483648, 0},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.divide(c.dividend, c.divisor);
        EXPECT_EQ(result, c.expect);
    }
}