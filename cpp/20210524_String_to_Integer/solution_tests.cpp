#include "../catch.hpp"
#include "solution.hpp"

#include <vector>

struct TestCase {
    std::string s;
    int         expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {"-91283472332", -2147483648},
        {"words and 987", 0},
        {"4193 with words", 4193},
        {"   -42", -42},
        {"42", 42},
        {"+42", 42},
        {"3.14", 3},
        {"2147483648", 2147483647},
        {"2147483647", 2147483647},
        {"-2147483648", -2147483648},
        {"-2147483647", -2147483647},
        {"  0000000000012345678", 12345678},
        {"00000-42a1234", 0},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.myAtoi(c.s);
        CHECK(result == c.expect);
    }
}