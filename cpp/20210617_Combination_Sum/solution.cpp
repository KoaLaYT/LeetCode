#include "solution.hpp"

#include <algorithm>
#include <map>

namespace impl {

struct Finder {
    int                        target;
    std::vector<int>           candidates;
    std::vector<int>::iterator end;

    std::vector<std::vector<int>>             result{};
    int                                       length{1};
    std::map<int, std::vector<int>::iterator> record{};
    std::vector<int>                          combination{};

    Finder(int t, std::vector<int>& c)
        : target{t},
          candidates{c}
    {
        std::sort(candidates.begin(), candidates.end());
        end = std::end(candidates);
    }

    void start();
    void search();
    bool backtrace();

    auto& last() { return record[combination.size() - 1]; }
    int   left_target()
    {
        int result = 0;
        for (int v : combination) {
            result += v;
        }
        return target - result;
    }
};

void Finder::start()
{
    combination.clear();
    record.clear();
    int first = candidates[0];
    for (int i = 0; i < length - 1; i++) {
        combination.push_back(first);
        record[i] = candidates.begin();
    }
    if (left_target() < first) return;

    search();

    // next round
    length++;
    start();
}

void Finder::search()
{
    auto start = !combination.empty() ? last() : std::begin(candidates);

    int t = left_target();
    if (t < *start) {
        combination.pop_back();
        if (!backtrace()) return;
        return search();
    }

    if (std::binary_search(start, end, t)) {
        // find combination
        combination.push_back(t);
        result.push_back(combination);
        combination.pop_back();
    }

    if (!backtrace()) return;
    return search();
}

bool Finder::backtrace()
{
    while (true) {
        if (combination.empty()) return false;
        if (++last() == end) {
            combination.pop_back();
            continue;
        }
        break;
    }

    auto v = last();
    combination.pop_back();
    for (int i = combination.size(); i < length - 1; i++) {
        combination.push_back(*v);
        record[i] = v;
    }
    return true;
}

};  // namespace impl

std::vector<std::vector<int>>
Solution::combinationSum(std::vector<int>& candidates, int target)
{
    auto finder = impl::Finder{target, candidates};
    finder.start();
    return finder.result;
}