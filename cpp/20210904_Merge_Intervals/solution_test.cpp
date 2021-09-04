#include "solution.hpp"
#include <gtest/gtest.h>

struct TestCase {
    std::vector<std::vector<int>> intervals;
    std::vector<std::vector<int>> expect;
};

TEST(merge_intervals, basic)
{
    std::vector<TestCase> cases{
        {{{1, 3}, {8, 10}, {2, 6}, {15, 18}},
         {{1, 6}, {8, 10}, {15, 18}}},
        {{{1, 4}, {4, 5}},
         {{1, 5}}},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.merge(c.intervals);
        EXPECT_EQ(c.expect, result);
    }
}