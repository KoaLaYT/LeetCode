#include "solution.hpp"

#include <limits>
#include <map>
#include <vector>
#include <cmath>

namespace impl {

static int ignore_leading_whitespace(std::string& s)
{
    int i = 0;
    while (i < s.length() && s[i] == ' ') {
        i++;
    }
    return i;
}

static int check_sign(std::string& s, int& i)
{
    if (s[i] == '-') {
        i = i + 1;
        return -1;
    }
    if (s[i] == '+') {
        i = i + 1;
    }
    return 1;
}

static bool is_num(char c) { return c >= '0' && c <= '9'; }

static int pow10(int n)
{
    int result = 1;
    while (n > 0) {
        if (result > std::numeric_limits<int>::max() / 10) {
            return -1;
        }
        result *= 10;
        n--;
    }
    return result;
}

static int atoi(std::string& s, int i)
{
    std::vector<int> nums;
    nums.reserve(s.length() - i + 1);
    int end = i;

    while (end < s.length()) {
        if (!is_num(s[end])) break;
        nums.push_back(s[end] - '0');
        end++;
    }

    int result = 0;
    int j = 0;
    int tens = 0;
    while (j < nums.size()) {
        int num = nums[j];
        if (tens == 0 && num == 0) {
            j++;
            continue;
        }
        if (tens == 0) {
            tens = pow10(end - i - j - 1);
            if (tens < 0) return -1;
        } else {
            tens /= 10;
        }

        if (num > std::numeric_limits<int>::max() / tens) {
            return -1;
        }
        int tmp = num * tens;
        if (tmp > std::numeric_limits<int>::max() - result) {
            return -1;
        }
        result += tmp;
        j++;
    }

    return result;
}

};  // namespace impl

int Solution::myAtoi(std::string s)
{
    int i = impl::ignore_leading_whitespace(s);
    int sign = impl::check_sign(s, i);
    int result = impl::atoi(s, i);

    if (result == -1) {
        return sign == 1 ? std::numeric_limits<int>::max() : std::numeric_limits<int>::min();
    }
    return sign * result;
}