#include "../catch.hpp"
#include "solution.hpp"

#include <vector>

struct TestCase {
    std::string input;
    std::string expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {"aaaa", "aaaa"},
        {"aacabdkacaa", "aca"},
        {"123abacba133", "aba"},
        {"123abcba133", "abcba"},
        {"abcba", "abcba"},
        {"dbabcd", "bab"},
        {"cbbd", "bb"},
        {"a", "a"},
        {"ac", "a"},
    };

    Solution s;
    for (auto& c : cases) {
        std::string result = s.longestPalindrome(c.input);
        CHECK(result == c.expect);
    }
}