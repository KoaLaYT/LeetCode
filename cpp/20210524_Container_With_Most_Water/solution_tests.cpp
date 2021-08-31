#include "../catch.hpp"
#include "solution.hpp"

struct TestCase {
    std::vector<int> height;
    int              expect;
};

TEST_CASE("basic")
{
    std::vector<TestCase> cases{
        {{1, 3, 2, 5, 25, 24, 5}, 24},
        {{1, 8, 6, 2, 5, 4, 8, 3, 2}, 40},
        {{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},
        {{1, 1}, 1},
        {{4, 3, 2, 1, 4}, 16},
        {{1, 2, 1}, 2},
    };

    Solution s;
    for (auto& c : cases) {
        int result = s.maxArea(c.height);
        CHECK(result == c.expect);
    }
}