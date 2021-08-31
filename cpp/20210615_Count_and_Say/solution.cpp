#include "solution.hpp"

namespace impl {

static std::string process(std::string& str)
{
    std::string words = str + "$";
    std::string result;
    int         count = 0;
    char        digit = -1;

    for (char c : words) {
        if (c == digit) {
            count++;
            continue;
        }
        if (count > 0) {
            result += std::to_string(count);
            result += digit;
        }
        count = 1;
        digit = c;
    }

    return result;
}

static std::string count_and_say(int n)
{
    if (n <= 1) return "1";
    std::string str = count_and_say(n - 1);
    return process(str);
}

};  // namespace impl

std::string Solution::countAndSay(int n)
{
    return impl::count_and_say(n);
}