#include "solution.hpp"

#include <list>
#include <vector>
#include <cmath>

/*

    PAYPALISHIRING  5

    P       H
    A     S I
    Y   I   R
    P L     I G
    A       N

    PHASIYIRPLIGAN

 */
std::string Solution::convert(std::string s, int numRows)
{
    std::vector<std::list<char>> zigzag;
    zigzag.reserve(numRows);
    for (int i = 0; i < numRows; i++) {
        zigzag.push_back({});
    }

    int dir = 1;
    int row = 0;
    for (char c : s) {
        zigzag[row].push_back(c);
        row += dir;
        if (row >= numRows || row < 0) {
            dir *= -1;
            if (row >= numRows) {
                row = std::max(0, numRows - 2);
            }
            if (row < 0) {
                row = std::min(1, numRows - 1);
            }
        }
    }

    std::string result;
    result.reserve(s.length());
    for (int i = 0; i < numRows; i++) {
        for (auto it = zigzag[i].begin(); it != zigzag[i].end(); it++) {
            result.push_back(*it);
        }
    }

    return result;
}