#include "../catch.hpp"
#include "solution.hpp"

#include <vector>

struct TestCase {
    int         num;
    std::string expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {3, "III"},
        {4, "IV"},
        {9, "IX"},
        {58, "LVIII"},
        {1994, "MCMXCIV"},
        {3999, "MMMCMXCIX"},
    };

    Solution s;
    for (auto& c : cases) {
        std::string result = s.intToRoman(c.num);
        CHECK(result == c.expect);
    }
}