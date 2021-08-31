#include "solution.hpp"
#include <cstdio>

namespace impl {

namespace brute_force {

bool is_palindrome(std::string& s, int lo, int hi)
{
    while (lo <= hi) {
        if (s[lo] != s[hi]) {
            return false;
        }
        lo++;
        hi--;
    }
    return true;
}

std::string longest_palindrome(std::string& s)
{
    int len = 0;
    int start = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.length() - i < len) break;
        for (int j = s.length() - 1; j >= i; --j) {
            if (j - 1 + 1 < len) break;
            if (is_palindrome(s, i, j) && j - i + 1 > len) {
                len = j - i + 1;
                start = i;
            }
        }
    }

    return s.substr(start, len);
}

}  // namespace brute_force

namespace dp {

std::string longest_palindrome(std::string& s)
{
    bool store[s.length() + 1][s.length() + 1];

    int longest = 0;
    int start = 0;
    for (int len = 0; len <= s.length(); len++) {
        for (int i = 0; i <= s.length() - len; i++) {
            if (len <= 1) {
                store[i][len] = true;
                longest = len;
                continue;
            }

            bool is_palindrome = store[i + 1][len - 2] && (s[i] == s[i + len - 1]);
            store[i][len] = is_palindrome;
            if (is_palindrome && len > longest) {
                longest = len;
                start = i;
            }
        }
    }

    return s.substr(start, longest);
}

}  // namespace dp

namespace expand_around_center {

std::pair<int, int> expand(std::string& s, int lo, int hi)
{
    while (lo >= 0 && hi <= s.length() - 1) {
        if (s[lo] != s[hi]) {
            break;
        }
        lo--;
        hi++;
    }
    return {lo + 1, hi - lo - 1};
}

std::string longest_palindrome(std::string& s)
{
    if (s.length() <= 1) return s;

    int start = 0;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
        auto expand_odd = expand(s, i, i);
        auto expand_even = expand(s, i, i + 1);
        if (expand_odd.second > len) {
            start = expand_odd.first;
            len = expand_odd.second;
        }
        if (expand_even.second > len) {
            start = expand_even.first;
            len = expand_even.second;
        }
    }

    return s.substr(start, len);
}

};  // namespace expand_around_center

};  // namespace impl

std::string Solution::longestPalindrome(std::string s)
{
    // return impl::brute_force::longest_palindrome(s);
    // return impl::dp::longest_palindrome(s);
    return impl::expand_around_center::longest_palindrome(s);
}