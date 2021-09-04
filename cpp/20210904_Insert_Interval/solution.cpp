#include "solution.hpp"

std::vector<std::vector<int>>
Solution::insert(std::vector<std::vector<int>>& intervals, std::vector<int>& newInterval)
{
    std::vector<std::vector<int>> result;
    int                           index = 0;

    while (index < intervals.size() && intervals[index][1] < newInterval[0]) {
        result.push_back(intervals[index]);
        index++;
    }

    while (index < intervals.size() && intervals[index][0] <= newInterval[1]) {
        newInterval[0] = std::min(intervals[index][0], newInterval[0]);
        newInterval[1] = std::max(intervals[index][1], newInterval[1]);
        index++;
    }
    result.push_back(newInterval);

    while (index < intervals.size()) {
        result.push_back(intervals[index]);
        index++;
    }

    return result;
}