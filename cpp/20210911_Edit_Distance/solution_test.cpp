#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct TestCase {
    std::string word1;
    std::string word2;
    int         expect;
};

TEST(edit_distance, basic)
{
    std::vector<TestCase> cases{
        {"horse", "ros", 3},
        {"intention", "execution", 5},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.minDistance(c.word1, c.word2);
        EXPECT_EQ(c.expect, result);
    }
}