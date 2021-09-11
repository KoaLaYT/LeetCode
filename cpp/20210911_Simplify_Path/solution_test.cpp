#include "solution.hpp"
#include <gtest/gtest.h>

#include <vector>

struct TestCase {
    std::string path;
    std::string expect;
};

TEST(simplify_path, basic)
{
    std::vector<TestCase> cases{
        {"/home/", "/home"},
        {"/../", "/"},
        {"/home//foo/", "/home/foo"},
        {"/a/./b/../../c/", "/c"},
        {"/a//b////c/d//././/..", "/a/b/c"},
    };

    Solution s;
    for (auto& c : cases) {
        auto result = s.simplifyPath(c.path);
        EXPECT_EQ(c.expect, result);
    }
}