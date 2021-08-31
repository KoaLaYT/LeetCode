#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

TEST(count_and_say, basic)
{
    struct Case {
        int         input;
        std::string expect;
    };

    std::vector<Case> cases{
        {1, "1"},
        {2, "11"},
        {3, "21"},
        {4, "1211"},
        {5, "111221"},
        {6, "312211"},
        {7, "13112221"},
        {8, "1113213211"},
        {9, "31131211131221"},
        {10, "13211311123113112211"},
        {11, "11131221133112132113212221"},
        {12, "3113112221232112111312211312113211"},
    };

    Solution s;
    for (auto& c : cases) {
        std::string result = s.countAndSay(c.input);
        EXPECT_EQ(c.expect, result);
    }
}