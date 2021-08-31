#include "solution.hpp"

#include <limits>

int Solution::jump(std::vector<int>& nums)
{
    if (nums.size() <= 1) return 0;

    std::vector<int> record;
    record.resize(nums.size(), std::numeric_limits<int>::max());

    for (int i = nums.size() - 2; i >= 0; i--) {
        int jump_len = nums[i];
        if (jump_len == 0) continue;
        if (jump_len + i >= nums.size() - 1) {
            record[i] = 1;
        } else {
            int min = std::numeric_limits<int>::max();
            for (int j = 1; j <= jump_len; j++) {
                min = std::min(min, record[i + j]);
            }
            record[i] = min == std::numeric_limits<int>::max() ? min : min + 1;
        }
    }

    return record[0];
}