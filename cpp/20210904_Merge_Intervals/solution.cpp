#include "solution.hpp"

std::vector<std::vector<int>>
Solution::merge(std::vector<std::vector<int>>& intervals)
{
    std::sort(intervals.begin(), intervals.end(),
              [](auto a, auto b) { return a[0] < b[0]; });

    std::vector<std::vector<int>> result;

    for (auto& interval : intervals) {
        if (result.empty() || result.back()[1] < interval[0]) {
            result.push_back(interval);
        } else {
            result.back()[1] = std::max(result.back()[1], interval[1]);
        }
    }

    return result;
}