package _20220630_LowestCommonAncestorInTree;

public class Solution {

    public int lowestCommonAncestorInTree(int[][] childs, int root, int p, int q) {
        if (root == p || root == q) {
            return root;
        }

        int[] children = childs[root];

        int v1 = -1;
        int v2 = -1;
        for (int child : children) {
            int found = lowestCommonAncestorInTree(childs, child, p, q);
            if (found == -1) {
                continue;
            }
            if (v1 == -1) {
                v1 = found;
            } else {
                v2 = found;
            }
        }

        if (v2 == -1) {
            return v1;
        }

        return root;
    }

}
