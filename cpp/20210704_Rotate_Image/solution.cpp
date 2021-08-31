#include "solution.hpp"

namespace impl {

struct Position {
    int row;
    int col;

    Position(int r, int c) : row{r}, col{c} {}
};

static void swap(
    std::vector<std::vector<int>>& matrix,
    Position                       p1,
    Position                       p2)
{
    int temp = matrix[p1.row][p1.col];
    matrix[p1.row][p1.col] = matrix[p2.row][p2.col];
    matrix[p2.row][p2.col] = temp;
}

};  // namespace impl

void Solution::rotate(std::vector<std::vector<int>>& matrix)
{
    int size = matrix.size();
    int max_layer = size / 2;

    for (int layer = 0; layer < max_layer; layer++) {
        for (int i = 0; i < size - layer * 2 - 1; i++) {
            impl::Position start{layer, layer + i};
            impl::swap(matrix, start, impl::Position{layer + i, size - 1 - layer});
            impl::swap(matrix, start, impl::Position{size - 1 - layer, size - 1 - layer - i});
            impl::swap(matrix, start, impl::Position{size - 1 - layer - i, layer});
        }
    }
}