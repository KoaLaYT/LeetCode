#include "solution.hpp"
#include <set>

namespace impl {

using Record = std::set<char>;
using Records = std::vector<Record>;

static Records init_records()
{
    Records records;
    records.reserve(9);
    for (int i = 0; i < 9; i++) {
        records.push_back({});
    }
    return records;
}

static bool find_or_insert(Record& record, char c)
{
    if (record.find(c) != record.end()) {
        return false;
    } else {
        record.insert(c);
        return true;
    }
}

};  // namespace impl

bool Solution::isValidSudoku(std::vector<std::vector<char>>& board)
{
    auto rows = impl::init_records();
    auto cols = impl::init_records();
    auto boxs = impl::init_records();

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (c == '.') continue;
            // check row
            if (!impl::find_or_insert(rows[i], c)) {
                return false;
            }
            // check col
            if (!impl::find_or_insert(cols[j], c)) {
                return false;
            }
            // check box
            int box_index = (i / 3) * 3 + j / 3;
            if (!impl::find_or_insert(boxs[box_index], c)) {
                return false;
            }
        }
    }

    return true;
}