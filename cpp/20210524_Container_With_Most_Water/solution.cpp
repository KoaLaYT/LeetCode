#include "solution.hpp"

#include <cmath>

int Solution::maxArea(std::vector<int>& height)
{
    if (height.size() <= 1) return 0;

    int area = 0;
    int left = 0;
    int right = height.size() - 1;
    while (true) {
        if (right - left <= 0) break;

        int current_area = std::min(height[left], height[right]) * (right - left);
        area = std::max(current_area, area);

        if (height[left] < height[right]) {
            int next_left = left + 1;
            while (next_left < height.size() && height[left] >= height[next_left]) {
                next_left++;
            }
            left = next_left;
        } else {
            int next_right = right - 1;
            while (next_right >= 0 && height[right] >= height[next_right]) {
                next_right--;
            }
            right = next_right;
        }
    }

    return area;
}