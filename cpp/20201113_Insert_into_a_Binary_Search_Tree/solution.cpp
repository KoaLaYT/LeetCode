#include "solution.hpp"

TreeNode* Solution::insertIntoBST(TreeNode* root, int val)
{
    if (root == nullptr) return new TreeNode{val};
    if (val < root->val) {
        root->left = insertIntoBST(root->left, val);
    } else if (val > root->val) {
        root->right = insertIntoBST(root->right, val);
    }
    return root;
}