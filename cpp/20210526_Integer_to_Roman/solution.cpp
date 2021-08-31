#include "solution.hpp"

#include <vector>

namespace impl {

struct Roman {
    int         val;
    std::string symbol;
};

static std::vector<Roman> roman_table()
{
    return {
        {1000, "M"},
        {900, "CM"},
        {500, "D"},
        {400, "CD"},
        {100, "C"},
        {90, "XC"},
        {50, "L"},
        {40, "XL"},
        {10, "X"},
        {9, "IX"},
        {5, "V"},
        {4, "IV"},
        {1, "I"},
    };
}

};  // namespace impl

std::string Solution::intToRoman(int num)
{
    auto table = impl::roman_table();

    int         index = 0;
    std::string result;
    while (num > 0) {
        while (num < table[index].val) {
            index++;
        }
        num -= table[index].val;
        result += table[index].symbol;
    }

    return result;
}