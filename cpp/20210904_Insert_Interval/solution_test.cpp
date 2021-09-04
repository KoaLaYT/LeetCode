#include "solution.hpp"
#include <gtest/gtest.h>

struct TestCase {
    std::vector<std::vector<int>> intervals;
    std::vector<int>              newInterval;
    std::vector<std::vector<int>> expect;
};

TEST(insert_interval, basic)
{
    std::vector<TestCase> cases{
        {{{1, 3}, {6, 9}},
         {2, 5},
         {{1, 5}, {6, 9}}},
        {{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
         {4, 8},
         {{1, 2}, {3, 10}, {12, 16}}},
        {{},
         {5, 7},
         {{5, 7}}},
        {{{1, 5}},
         {2, 3},
         {{1, 5}}},
        {{{1, 5}},
         {2, 7},
         {{1, 7}}},
        {{{1, 5}},
         {6, 8},
         {{1, 5}, {6, 8}}},
        {{{1, 5}},
         {0, 3},
         {{0, 5}}},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.insert(c.intervals, c.newInterval);
        EXPECT_EQ(c.expect, result);
    }
}