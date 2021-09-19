#include "solution.hpp"

int Solution::removeDuplicates(std::vector<int>& nums)
{
    if (nums.size() <= 1) {
        return nums.size();
    }

    int i = 2;
    for (int j = 2; j < nums.size(); j++) {
        if (nums[j] != nums[i - 2]) {
            nums[i] = nums[j];
            i++;
        }
    }

    return i;
}