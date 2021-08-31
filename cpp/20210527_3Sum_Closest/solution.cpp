#include "solution.hpp"

#include <algorithm>
#include <limits>

int Solution::threeSumClosest(std::vector<int>& nums, int target)
{
    std::vector<int> copy{nums};
    std::sort(std::begin(copy), std::end(copy));

    int diff = std::numeric_limits<int>::max();

    for (int i = 0; i < copy.size() && diff != 0; i++) {
        int lo = i + 1;
        int hi = copy.size() - 1;
        while (lo < hi) {
            int sum = copy[i] + copy[lo] + copy[hi];
            if (std::abs(target - sum) < std::abs(diff)) {
                diff = target - sum;
            }
            if (diff == 0) break;
            if (sum < target) {
                lo += 1;
            } else {
                hi -= 1;
            }
        }
    }

    return target - diff;
}