#include "solution.hpp"
#include <list>

namespace impl {

static char itoc(int i)
{
    return (char)(i - 1 + (int)'1');
}

static std::list<int> candidates(int n)
{
    std::list<int> result;
    for (int i = 0; i < n; i++) {
        result.push_back(i + 1);
    }
    return result;
}

static int factorial(int n)
{
    int result = 1;
    while (n > 1) {
        result *= n;
        n--;
    }
    return result;
}

// index start from 1
static int remove(std::list<int>& list, int index)
{
    auto it = list.begin();
    std::advance(it, index - 1);
    int value = *it;
    list.erase(it);
    return value;
}

};  // namespace impl

std::string
Solution::getPermutation(int n, int k)
{
    std::list<int> candidates = impl::candidates(n);
    std::string    permutation;

    while (!candidates.empty()) {
        if (k == 0) {
            permutation.push_back(impl::itoc(candidates.back()));
            candidates.pop_back();
            continue;
        }

        int factorial = impl::factorial(candidates.size() - 1);
        int position = k / factorial;
        k %= factorial;
        if (k > 0) {
            position += 1;
        }
        permutation.push_back(impl::itoc(impl::remove(candidates, position)));
    }

    return permutation;
}