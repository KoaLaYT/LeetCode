#include "solution.hpp"

#include <map>
#include <list>
#include <vector>

namespace impl {

class Store {
public:
    bool has(char c) { return m_store.find(c) != m_store.end(); }
    int  size() { return m_store.size(); }

    void insert(char c, int index)
    {
        m_store[c] = index;
        m_list.push_back(c);
    }

    void remove_util(char c)
    {
        int index = m_store[c];
        while (!m_list.empty()) {
            char front = m_list.front();
            if (m_store[front] > index) break;
            m_list.pop_front();
            m_store.erase(front);
        }
    }

private:
    std::map<char, int> m_store;
    std::list<char>     m_list;
};

int length_of_longest_substring(std::string& s)
{
    int   len = 0;
    Store store;

    for (int index = 0; index < s.length(); index++) {
        char c = s[index];
        if (store.has(c)) {
            store.remove_util(c);
        }
        store.insert(c, index);
        if (store.size() > len) {
            len = store.size();
        }
    }

    return len;
}

namespace sliding_window {

int length_of_longest_substring(std::string& s)
{
    int                 len = 0;
    std::map<char, int> store;

    int i = 0;
    for (int j = 0; j < s.length(); j++) {
        char c = s[j];
        if (store.find(c) != store.end()) {
            i = std::max(store[c], i);
        }
        store[c] = j + 1;
        len = std::max(j - i + 1, len);
    }

    return len;
}

};  // namespace sliding_window

namespace sliding_window_bitmap {

int length_of_longest_substring(std::string& s)
{
    int              len = 0;
    std::vector<int> store;
    store.resize(256, -1);

    int i = 0;
    for (int j = 0; j < s.length(); j++) {
        int c = s[j];
        if (store[c] != -1) {
            i = std::max(store[c], i);
        }
        store[c] = j + 1;
        len = std::max(j - i + 1, len);
    }

    return len;
}

};  // namespace sliding_window_bitmap

};  // namespace impl

int Solution::lengthOfLongestSubstring(std::string s)
{
    // return impl::length_of_longest_substring(s);
    // return impl::sliding_window::length_of_longest_substring(s);
    return impl::sliding_window_bitmap::length_of_longest_substring(s);
}