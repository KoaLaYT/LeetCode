package _20220207_ConvertSortedArrayToBinarySearchTree;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mi = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mi]);
        node.left = sortedArrayToBST(nums, lo, mi - 1);
        node.right = sortedArrayToBST(nums, mi + 1, hi);
        return node;
    }

}