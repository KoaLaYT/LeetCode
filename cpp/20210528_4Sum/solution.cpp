#include "solution.hpp"

#include <algorithm>

namespace impl {

static std::vector<std::vector<int>> two_sum(std::vector<int>& nums, int target, int begin)
{
    std::vector<std::vector<int>> result;
    int                           lo = begin;
    int                           hi = nums.size() - 1;

    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        if (target == sum) {
            result.push_back({nums[lo], nums[hi]});
            do {
                lo++;
            } while (lo < nums.size() && nums[lo - 1] == nums[lo]);
            do {
                hi--;
            } while (hi >= 0 && nums[hi + 1] == nums[hi]);
        } else if (target > sum) {
            do {
                lo++;
            } while (lo < nums.size() && nums[lo - 1] == nums[lo]);
        } else {
            do {
                hi--;
            } while (hi >= 0 && nums[hi + 1] == nums[hi]);
        }
    }

    return result;
}

static std::vector<std::vector<int>> ksum(std::vector<int>& nums, int target, int k, int begin)
{
    if (k == 2) return two_sum(nums, target, begin);

    std::vector<std::vector<int>> result;
    for (int i = begin; i < nums.size(); i++) {
        if (i != begin && nums[i] == nums[i - 1]) continue;

        auto partial_result = ksum(nums, target - nums[i], k - 1, i + 1);
        for (auto& r : partial_result) {
            result.push_back({nums[i]});
            result.back().insert(result.back().end(), r.begin(), r.end());
        }
    }
    return result;
}

};  // namespace impl

std::vector<std::vector<int>> Solution::fourSum(std::vector<int>& nums, int target)
{
    std::vector<int> copy{nums};
    std::sort(std::begin(copy), std::end(copy));

    return impl::ksum(copy, target, 4, 0);
}