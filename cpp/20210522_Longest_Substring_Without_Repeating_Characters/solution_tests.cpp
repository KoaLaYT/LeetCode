#include "../catch.hpp"
#include "solution.hpp"

#include <vector>

struct TestCase {
    std::string input;
    int         expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {"abba", 2},
        {"abcdcefg", 5},
        {"abcdce", 4},
        {"abcabcbb", 3},
        {"bbbbb", 1},
        {"pwwkew", 3},
        {"", 0},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.lengthOfLongestSubstring(c.input);
        CHECK(result == c.expect);
    }
}