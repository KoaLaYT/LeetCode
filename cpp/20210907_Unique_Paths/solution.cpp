#include "solution.hpp"
#include <vector>

int Solution::uniquePaths(int m, int n)
{
    if (m == 1 || n == 1) {
        return 1;
    }

    std::vector<int> map;
    map.resize(m * n - 1);

    for (int i = 0; i < m - 1; i++) {
        map[n * i + n - 1] = 1;
    }

    for (int i = 0; i < n - 1; i++) {
        map[(m - 1) * n + i] = 1;
    }

    for (int i = m - 2; i >= 0; i--) {
        for (int j = n - 2; j >= 0; j--) {
            map[i * n + j] = map[(i + 1) * n + j] + map[i * n + j + 1];
        }
    }

    return map[0];
}