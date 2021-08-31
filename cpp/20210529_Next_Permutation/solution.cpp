#include "solution.hpp"

namespace impl {

struct Node {
    int   val;
    Node* next;
};

class List {
public:
    List() : m_head{nullptr} {}

    Node* insert(int val)
    {
        Node* cur = m_head;
        Node* parent = nullptr;
        while (cur != nullptr && cur->val <= val) {
            parent = cur;
            cur = cur->next;
        }
        Node* node = new Node{val, cur};
        if (parent == nullptr) {
            m_head = node;
        } else {
            parent->next = node;
        }
        return node;
    }

    void remove(Node* node)
    {
        if (m_head == node) {
            m_head = node->next;
            return;
        }

        Node* parent = m_head;
        while (parent->next != node) {
            parent = parent->next;
        }
        parent->next = node->next;
    }

    bool empty() { return m_head == nullptr; }

    Node* pop_front()
    {
        Node* node = m_head;
        m_head = m_head->next;
        return node;
    }

private:
    Node* m_head;
};

};  // namespace impl

void Solution::nextPermutation(std::vector<int>& nums)
{
    impl::List list;
    int        i = nums.size() - 1;

    for (; i >= 0; i--) {
        impl::Node* node = list.insert(nums[i]);
        impl::Node* next = node->next;
        if (next != nullptr) {
            list.remove(next);
            nums[i] = next->val;
            delete next;
            break;
        }
    }

    while (!list.empty()) {
        impl::Node* head = list.pop_front();
        nums[++i] = head->val;
        delete head;
    }
}