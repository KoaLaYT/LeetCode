#include "../catch.hpp"
#include "solution.hpp"

#include <vector>

struct TestCase {
    std::string s;
    int         num_rows;
    std::string expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {"PAYPALISHIRING", 5, "PHASIYIRPLIGAN"},
        {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
        {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
        {"A", 1, "A"},
        {"AB", 1, "AB"},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.convert(c.s, c.num_rows);
        CHECK(result == c.expect);
    }
}