#include "solution.hpp"

#include <set>

namespace impl {

static void swap(std::vector<int>& array, int i, int j)
{
    if (i == j) return;
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

static void permute(std::vector<int>&           nums,
                    std::vector<int>&           permutation,
                    int                         index,
                    std::set<std::vector<int>>& results)
{
    if (permutation.size() == nums.size()) {
        results.insert(permutation);
        return;
    }

    for (int i = index; i < nums.size(); i++) {
        if (i != index && (nums[i] == nums[index] || nums[i] == nums[i - 1])) continue;
        permutation.push_back(nums[i]);
        impl::swap(nums, i, index);
        permute(nums, permutation, index + 1, results);
        permutation.pop_back();
        impl::swap(nums, i, index);
    }
}

};  // namespace impl

std::vector<std::vector<int>>
Solution::permuteUnique(std::vector<int>& nums)
{
    std::set<std::vector<int>> results;
    std::vector<int>           permutation;

    impl::permute(nums, permutation, 0, results);

    return {results.begin(), results.end()};
}