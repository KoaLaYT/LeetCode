#include "solution.hpp"

#include <cmath>
#include <limits>

namespace impl {

static int divide(long dividend, long divisor)
{
    if (dividend < divisor) {
        return 0;
    }
    int  result = 1;
    long init_divisor = divisor;

    for (int next = divisor << 1; next > 0 && next <= dividend; next = divisor << 1) {
        result <<= 1;
        divisor <<= 1;
    }
    result += divide(dividend - divisor, init_divisor);

    return result;
}

};  // namespace impl

int Solution::divide(int dividend, int divisor)
{
    if (divisor == 1) return dividend;
    if (divisor == -1) {
        if (dividend == std::numeric_limits<int>::min()) {
            return std::numeric_limits<int>::max();
        } else {
            return -dividend;
        }
    }

    long abs_dividend = std::abs((long)dividend);
    long abs_divisor = std::abs((long)divisor);

    int result = impl::divide(abs_dividend, abs_divisor);

    return (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)
               ? -result
               : result;
}