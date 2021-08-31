#include "solution.hpp"

#include <vector>

namespace impl {

static int  char_to_num(char c) { return c - '0'; }
static char num_to_char(int i) { return i + '0'; }

};  // namespace impl

std::string Solution::multiply(std::string num1, std::string num2)
{
    if (num1 == "0" || num2 == "0") return "0";

    std::string& longer = num1.size() > num2.size() ? num1 : num2;
    std::string& shorter = num1.size() > num2.size() ? num2 : num1;

    std::vector<std::string> results;

    for (auto c1 = std::crbegin(shorter); c1 != std::crend(shorter); c1++) {
        std::string result;
        int         n1 = impl::char_to_num(*c1);
        int         carry = 0;

        for (auto c2 = std::crbegin(longer); c2 != std::crend(longer); c2++) {
            int n2 = impl::char_to_num(*c2);
            int mul = n1 * n2 + carry;
            int digit = mul % 10;
            carry = mul / 10;

            result.push_back(impl::num_to_char(digit));
        }

        if (carry > 0) {
            result.push_back(impl::num_to_char(carry));
        }

        results.push_back(result);
    }

    std::string result;
    int         index = 0;
    int         carry = 0;

    for (int index = 0; index < results.back().size() + results.size() - 1; index++) {
        int sum = carry;
        for (int i = 0; i < results.size(); i++) {
            if (i > index) break;
            if (index - i > results[i].size() - 1) continue;

            sum += impl::char_to_num(results[i][index - i]);
        }
        result.push_back(impl::num_to_char(sum % 10));
        carry = sum / 10;
    }

    if (carry > 0) {
        result.push_back(impl::num_to_char(carry));
    }

    return {result.crbegin(), result.crend()};
}