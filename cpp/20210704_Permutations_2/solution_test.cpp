#include "solution.hpp"
#include <gtest/gtest.h>

#include <algorithm>

struct Case {
    std::vector<int>              nums;
    std::vector<std::vector<int>> expected;
};

static bool array_equal(std::vector<int>& arr1, std::vector<int>& arr2)
{
    if (arr1.size() != arr2.size()) return false;

    std::sort(arr1.begin(), arr1.end());
    std::sort(arr2.begin(), arr2.end());

    return arr1 == arr2;
}

TEST(permutations, basic)
{
    std::vector<Case> cases{
        {{1, 1, 2}, {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}}},
        {{1, 2, 3}, {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 2, 1}, {3, 1, 2}}},
        {{1, 1}, {{1, 1}}},
        {{1}, {{1}}},
        {{1, 1, 1, 2}, {{1, 1, 1, 2}, {1, 1, 2, 1}, {1, 2, 1, 1}, {2, 1, 1, 1}}},
        {{3, 3, 0, 3}, {{3, 3, 0, 3}, {3, 3, 3, 0}, {3, 0, 3, 3}, {0, 3, 3, 3}}},
        {{2, 2, 1, 1}, {{2, 2, 1, 1}, {2, 1, 2, 1}, {2, 1, 1, 2}, {1, 2, 2, 1}, {1, 2, 1, 2}, {1, 1, 2, 2}}},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.permuteUnique(c.nums);
        ASSERT_EQ(c.expected.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            EXPECT_TRUE(array_equal(c.expected[i], result[i]));
        }
    }
}