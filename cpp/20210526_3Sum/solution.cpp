#include "solution.hpp"

#include <algorithm>
#include <set>
#include <string>

namespace impl {

static int search(std::vector<int>& nums, int target, int lo, int hi)
{
    if (lo > hi) return -1;

    int mi = lo + (hi - lo) / 2;
    if (nums[mi] == target)
        return mi;
    else if (nums[mi] > target)
        return search(nums, target, lo, mi - 1);
    else
        return search(nums, target, mi + 1, hi);
}

static void add_if_not_duplicate(
    std::set<std::vector<int>>& store,
    std::vector<int>&           nums,
    int i, int j, int k)
{
    static std::vector<int> s;
    s.clear();

    s.push_back(nums[i]);
    s.push_back(nums[j]);
    s.push_back(nums[k]);

    if (store.find(s) == store.end()) {
        store.insert(s);
    }
}

static void two_sum(
    std::set<std::vector<int>>& store,
    std::vector<int>&           nums,
    int                         i)
{
    int sum = 0 - nums[i];
    for (int j = i + 1; j < nums.size(); j++) {
        int target = sum - nums[j];

        if (target < nums[j]) break;

        int k = search(nums, target, j + 1, nums.size() - 1);

        if (k != -1) {
            add_if_not_duplicate(store, nums, i, j, k);
        }
    }
}

};  // namespace impl

std::vector<std::vector<int>> Solution::threeSum(std::vector<int>& nums)
{
    std::vector<int> copy{nums};
    std::sort(copy.begin(), copy.end());

    std::set<std::vector<int>> store;
    for (int i = 0; i < copy.size(); i++) {
        impl::two_sum(store, copy, i);
    }
    return {store.begin(), store.end()};
}