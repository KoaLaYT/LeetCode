package _20221016_MaximumXorOfTwoNumbersInAnArray;

public class Solution {

    private static final int BITS = 30;

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            add(root, nums[i - 1]);
            max = Math.max(max, check(root, nums[i]));
        }

        return max;
    }

    private void add(Trie root, int num) {
        Trie current = root;
        for (int i = BITS; i >= 0; i--) {
            if (((num >> i) & 1) == 0) {
                if (current.left == null) {
                    current.left = new Trie();
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Trie();
                }
                current = current.right;
            }
        }
    }

    private int check(Trie root, int num) {
        int x = 0;
        Trie current = root;
        for (int i = BITS; i >= 0; i--) {
            if (((num >> i) & 1) == 0) {
                if (current.right != null) {
                    current = current.right;
                    x = (x << 1) | 1;
                } else {
                    current = current.left;
                    x = x << 1;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                    x = (x << 1) | 1;
                } else {
                    current = current.right;
                    x = x << 1;
                }
            }
        }
        return x;
    }

    private static class Trie {
        Trie left; // represent 0
        Trie right; // represent 1
    }

}
