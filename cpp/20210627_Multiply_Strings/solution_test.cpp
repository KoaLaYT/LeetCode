#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct Case {
    std::string num1;
    std::string num2;
    std::string expected;
};

std::string multiply(std::string& s1, std::string& s2)
{
    int num1 = std::atoi(s1.c_str());
    int num2 = std::atoi(s2.c_str());
    return std::to_string(num1 * num2);
}

TEST(multiply_string, basic)
{
    std::vector<Case> cases{
        {"123", "456"},
        {"0", "123"},
        {"123", "0"},
        {"123", "32"},
        {"123", "9"},
        {"10001", "101"},
    };

    Solution s;
    for (auto& c : cases) {
        std::string result = s.multiply(c.num1, c.num2);
        std::string expected = multiply(c.num1, c.num2);

        EXPECT_EQ(expected, result);
    }
}