#include "solution.hpp"

#include <algorithm>

namespace impl {

static void dfs(
    std::vector<std::vector<int>>& result,
    std::vector<int>&              combination,
    std::vector<int>&              candidates,
    int                            target,
    int                            index)
{
    // find a combination
    if (target == 0) {
        result.push_back(combination);
        return;
    }

    for (int i = index; i < candidates.size(); i++) {
        if (candidates[i] > target) break;
        if (i > index && candidates[i] == candidates[i - 1]) continue;

        combination.push_back(candidates[i]);
        dfs(result, combination, candidates, target - candidates[i], i + 1);
        combination.pop_back();
    }
}

};  // namespace impl

std::vector<std::vector<int>>
Solution::combinationSum2(std::vector<int>& candidates, int target)
{
    std::vector<std::vector<int>> result;
    std::vector<int>              combination;
    std::vector<int>              inputs{candidates};

    std::sort(std::begin(inputs), std::end(inputs));

    impl::dfs(result, combination, inputs, target, 0);

    return result;
}