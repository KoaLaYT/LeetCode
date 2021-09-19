#include "solution.hpp"
#include <gtest/gtest.h>

struct TestCase {
    std::vector<int> nums;
    int              expect;
    std::vector<int> removed;
};

TEST(remove_duplicates_from_sorted_array_II, basic)
{
    std::vector<TestCase> cases{
        {{1, 1, 1, 2, 2, 3},
         5,
         {1, 1, 2, 2, 3}},
        {{0, 0, 1, 1, 1, 1, 2, 3, 3},
         7,
         {0, 0, 1, 1, 2, 3, 3}},
        {{1, 2, 3},
         3,
         {1, 2, 3}},
        {{1, 1, 2, 2, 2, 3, 3, 3},
         6,
         {1, 1, 2, 2, 3, 3}},
        {{0, 1, 1, 1, 1, 2, 2, 2},
         5,
         {0, 1, 1, 2, 2}}};

    Solution s;
    for (auto& c : cases) {
        int result = s.removeDuplicates(c.nums);
        ASSERT_EQ(c.expect, result);
        for (int i = 0; i < c.expect; i++) {
            EXPECT_EQ(c.removed[i], c.nums[i]);
        }
    }
}